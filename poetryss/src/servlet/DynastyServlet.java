package servlet;

import entity.Dynasty;
import entity.PageBean;
import service.DynastyService;
import service.impl.DynastyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author y
 */
@WebServlet("/DynastyServlet")
public class DynastyServlet extends HttpServlet {
    private DynastyService dynastyService = new DynastyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if(rows == null || "".equals(rows)){
            rows = "10";
        }
        PageBean<Dynasty> pageBeanDynasty = dynastyService.findAllDynasty(Integer.parseInt(currentPage),Integer.parseInt(rows));
        if(pageBeanDynasty != null){
            request.setAttribute("pageBeanDynasty",pageBeanDynasty);
            request.getRequestDispatcher("/pages/dynasty.jsp").forward(request,response);
        }else{
            response.sendRedirect(request.getContextPath()+"/UserServlet");
        }
    }
}
