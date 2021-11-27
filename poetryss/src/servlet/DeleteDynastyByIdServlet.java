package servlet;

import service.AuthorService;
import service.DynastyService;
import service.impl.AuthorServiceImpl;
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
@WebServlet("/DeleteDynastyByIdServlet")
public class DeleteDynastyByIdServlet extends HttpServlet {
    private DynastyService dynastyService = new DynastyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            response.sendRedirect(request.getContextPath() + "/DynastyServlet");
        } else {
            int flag = dynastyService.deleteDynastyById(Integer.parseInt(id));
            if (flag == 1) {
                response.sendRedirect(request.getContextPath() + "/DynastyServlet");
            } else {
                response.sendRedirect(request.getContextPath() + "/DynastyServlet");
            }
        }
    }
}
