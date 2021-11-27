package servlet;

import service.UserService;
import service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author y
 */
@WebServlet("/DeleteUserByIdServlet")
public class DeleteUserByIdServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            response.sendRedirect(request.getContextPath() + "/UserServlet");
        } else {
            int flag = userService.deleteUserById(Integer.parseInt(id));
            if (flag == 1) {
                response.sendRedirect(request.getContextPath() + "/UserServlet");
            } else {
                response.sendRedirect(request.getContextPath() + "/UserServlet");
            }
        }
    }
}
