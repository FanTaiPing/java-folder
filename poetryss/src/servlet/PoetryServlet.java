package servlet;

import entity.PageBean;
import entity.Poetry;
import entity.User;
import service.PoetryService;
import service.impl.PoetryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author y
 */
@WebServlet("/PoetryServlet")
public class PoetryServlet extends HttpServlet {
    private PoetryService poetryService = new PoetryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        //首次进入列表信息显示页面时，默认从第一页开始显示，每页显示rows条记录
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }
        int _currentPage = Integer.parseInt(currentPage);
        int _rows = Integer.parseInt(rows);
        //将用户对象存到request域对象里
        PageBean<Poetry> pageBeanPoetry = poetryService.findAllPoetry(_currentPage, _rows);
        if (pageBeanPoetry != null) {
            request.setAttribute("pageBeanPoetry", pageBeanPoetry);
            //转发到index.jsp界面
            request.getRequestDispatcher("/pages/poetry.jsp").forward(request, response);
        } else {
            //重定向到登录界面
            response.sendRedirect(request.getContextPath() + "/UserServlet");
        }
    }
}
