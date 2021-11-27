package servlet;

import entity.Author;
import entity.Dynasty;
import entity.Page;
import service.AuthorService;
import service.DynastyService;
import service.impl.AuthorServiceImpl;
import service.impl.DynastyServiceImpl;
import util.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 当选中不同朝代时, 更新作者; 当选中不同作者时, 更新类型
 * 展示所有朝代, 作者
 * 需要朝代id, pinyin, 作者页数
 *
 * @author ljsy
 **/
@WebServlet("/author")
public class AuthorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DynastyService dynastyService = new DynastyServiceImpl();
        AuthorService authorService = new AuthorServiceImpl();
        int size = 80;

        List<String> pinyinList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "w", "x", "y", "z");
        // 选中的朝代
        int dynastyId = RequestUtil.getIntParameter(request, "dynasty");
        // 选中的拼音
        String pinyin = request.getParameter("pinyin");
        pinyin = "".equals(pinyin) ? null : pinyin;
        // 当前作者页数
        int pageNo = RequestUtil.getIntParameter(request, "page");

        // 作者页数对象
        Page page;

        // 所有朝代
        List<Dynasty> dynastyList = dynastyService.findAll();
        // 展示的作者列表
        List<Author> authorList;
        // 拼音列表
        if (dynastyId > 0) {
            pinyinList = authorService.findPinyinByDynasty(dynastyId);
        }

        //以朝代和拼音找作者
        //     * 朝代为0, 则以拼音找作者
        //     * 拼音为*, 则以朝代找作者
        //     * 若两者为空, 则以id排序作者
        if (dynastyId > 0 && pinyin != null) {
            // 有朝代和拼音
            page = new Page(pageNo, size, authorService.countByDynastyAndPinyin(dynastyId, pinyin));
            authorList = authorService.findAuthorByDynastyAndPinyin(dynastyId, pinyin, page);
        } else if (dynastyId > 0) {
            // 只有朝代
            page = new Page(pageNo, size, authorService.countByDynasty(dynastyId));
            authorList = authorService.findAuthorByDynasty(dynastyId, page);
        } else if (dynastyId == 0 && pinyin != null) {
            // 只有拼音
            page = new Page(pageNo, size, authorService.countByPinyin(pinyin));
            authorList = authorService.findAuthorByPinyin(pinyin, page);
        } else {
            // 没有拼音也没有朝代选项
            page = new Page(pageNo, size, authorService.countAll());
            authorList = authorService.findAll(page);
        }


        // 设置到请求
        request.setAttribute("pinyinList", pinyinList);
        request.setAttribute("dynasty", dynastyId);
        request.setAttribute("dynastyList", dynastyList);
        request.setAttribute("pinyin", pinyin);
        request.setAttribute("page", page);
        request.setAttribute("authorList", authorList);

        // 转发到分类页面
        request.getRequestDispatcher("/pages/author.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
