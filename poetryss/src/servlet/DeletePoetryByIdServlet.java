package servlet;
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
@WebServlet("/DeletePoetryByIdServlet")
public class DeletePoetryByIdServlet extends HttpServlet {
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
            int flag = poetryService.deletePoetryById(Integer.parseInt(id));
            if (flag == 1) {
                response.sendRedirect(request.getContextPath() + "/PoetryServlet");
            } else {
                response.sendRedirect(request.getContextPath() + "/PoetryServlet");
            }
        }
    }
}
