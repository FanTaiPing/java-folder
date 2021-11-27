package servlet;

import entity.Page;
import entity.Poetry;
import service.PoetryService;
import service.impl.PoetryServiceImpl;
import util.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * 首页展示, 随机诗词
 * @author ljsy
 **/
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PoetryService poetryService = new PoetryServiceImpl();
        // 取参数
        int start = RequestUtil.getIntParameter(request, "s");
        int pageNo = RequestUtil.getIntParameter(request,"page");
        // 随机数
        start = start == 0 ? new Random().nextInt(100) + 1 : start;
        // 页数, 只显示4页
        Page page = new Page(pageNo,10,40);
        // 取诗词
        List<Poetry> list = poetryService.findAll(start, page);

        request.setAttribute("list", list);
        request.setAttribute("page",page);
        request.setAttribute("s",start);
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
