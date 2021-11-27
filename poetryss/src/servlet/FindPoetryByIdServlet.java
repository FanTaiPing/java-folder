package servlet;

import entity.Poetry;
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
@WebServlet("/FindPoetryByIdServlet")
public class FindPoetryByIdServlet extends HttpServlet {
    private PoetryService poetryService = new PoetryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            response.sendRedirect(request.getContextPath() + "/PoetryServlet");
        } else {
            Poetry poetry = poetryService.findPoetryById(Integer.parseInt(id));
            if (poetry != null) {
                request.setAttribute("poetry", poetry);
                request.getRequestDispatcher("/pages/updatePoetry.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/PoetryServlet");
            }
        }
    }
}
