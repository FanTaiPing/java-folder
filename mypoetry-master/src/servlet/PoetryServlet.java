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

/**
 * 诗词详情页
 * 展示同类型诗词
 * 诗词id和页数
 * @author ljsy
 **/
@WebServlet("/poetry")
public class PoetryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PoetryService poetryService = new PoetryServiceImpl();

        int poetryId = RequestUtil.getIntParameter(request,"poetry");
        int pageNo = RequestUtil.getIntParameter(request,"page");

        // 当前诗词
        Poetry poetry = poetryService.findById(poetryId);
        // 如果没找到诗词
        if(poetry==null){
            request.setAttribute("msg","没有这首诗词");
            request.getRequestDispatcher("/pages/404.jsp").forward(request,response);
            return;
        }

        Page page = new Page(pageNo, 5, poetryService.countByType(poetry.getType().getId()));
        // 同类型诗词
        List<Poetry> list = poetryService.findByType(poetry.getType().getId(), page);

        request.setAttribute("poetry",poetry);
        request.setAttribute("page",page);
        request.setAttribute("list",list);

        request.getRequestDispatcher("/pages/poetry.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
