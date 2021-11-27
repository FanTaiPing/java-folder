package servlet;

import entity.User;
import service.PoetryService;
import service.UserService;
import service.impl.PoetryServiceImpl;
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
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        int flag = userService.addUser(user);
        if(flag == 1){
            response.sendRedirect(request.getContextPath()+"/UserServlet");
        }else{
            response.sendRedirect(request.getContextPath()+"/pages/register.jsp");
        }
    }
}
