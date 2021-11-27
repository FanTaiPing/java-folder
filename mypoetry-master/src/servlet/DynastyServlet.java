package servlet;

import entity.Dynasty;
import entity.Page;
import entity.Poetry;
import service.DynastyService;
import service.PoetryService;
import service.impl.DynastyServiceImpl;
import service.impl.PoetryServiceImpl;
import util.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 需要朝代id, 页数
 *
 * @author ljsy
 **/
@WebServlet("/dynasty")
public class DynastyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DynastyService dynastyService = new DynastyServiceImpl();
        PoetryService poetryService = new PoetryServiceImpl();

        // 取朝代id
        int dynastyId = RequestUtil.getIntParameter(request, "dynasty");
        // 取页数
        int pageNo = RequestUtil.getIntParameter(request, "page");
        pageNo = pageNo == 0 ? 1 : pageNo;

        int size = 10;
        // 计数查询耗时太长, 所以总数依当前页数增加
        int itemCount = pageNo * size * 4;
        Page page = new Page(pageNo, size, itemCount);

        // 所有朝代
        List<Dynasty> dynastyList = dynastyService.findAll();
        // 诗词列表
        List<Poetry> poetryList;
        // 若有朝代参数, 显示朝代的所有诗词
        if (dynastyId > 0) {

            poetryList = poetryService.findByDynasty(dynastyId, page);
            // 若返回的数据少于size, 说明数据到末页了
            if (poetryList.size() < size) {
                page.setTotalPages(pageNo);
            }

            Dynasty dynasty = dynastyService.findById(dynastyId);
            request.setAttribute("dynasty", dynasty);
        }
        // 没有传入朝代则显示默认诗词
        else {
            // 取从id1开始的诗词
            poetryList = poetryService.findAll(1, page);
        }

        request.setAttribute("page", page);
        request.setAttribute("dynastyList", dynastyList);
        request.setAttribute("poetryList", poetryList);
        request.getRequestDispatcher("/pages/dynasty.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
