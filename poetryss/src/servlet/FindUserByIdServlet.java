package servlet;

import entity.Author;
import entity.PageBean;
import entity.User;
import service.AuthorService;
import service.UserService;
import service.impl.AuthorServiceImpl;
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
@WebServlet("/FindUserByIdServlet")
public class FindUserByIdServlet extends HttpServlet {
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
            if (request.getAttribute("user") != null) {
                request.removeAttribute("user");
            } else {
                User user = userService.FindUserByIdServlet(Integer.parseInt(id));
                if (user != null) {
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("/pages/updateUser.jsp").forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/UserServlet");
                }
            }
        }
    }
}
