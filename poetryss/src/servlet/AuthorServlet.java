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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author y
 */
@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "10";
        }

        PageBean<Author> pageBeanAuthor = authorService.findAllAuthor(Integer.parseInt(currentPage), Integer.parseInt(rows));
        if (pageBeanAuthor != null) {
            request.setAttribute("pageBeanAuthor", pageBeanAuthor);
            request.getRequestDispatcher("/pages/author.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/UserServlet");
        }
    }
}
