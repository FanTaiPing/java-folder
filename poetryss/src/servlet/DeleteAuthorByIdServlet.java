package servlet;

import service.AuthorService;
import service.impl.AuthorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author y
 */
@WebServlet("/DeleteAuthorByIdServlet")
public class DeleteAuthorByIdServlet extends HttpServlet {
    private AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || "".equals(id)) {
            response.sendRedirect(request.getContextPath() + "/AuthorServlet");
        } else {
            int flag = authorService.deleteAuthorById(Integer.parseInt(id));
            if (flag == 1) {
                response.sendRedirect(request.getContextPath() + "/AuthorServlet");
            } else {
                response.sendRedirect(request.getContextPath() + "/AuthorServlet");
            }
        }
    }
}
