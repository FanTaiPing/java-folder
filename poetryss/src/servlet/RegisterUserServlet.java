package servlet;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author y
 */
@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {
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
        if(flag ==1){
            response.sendRedirect(request.getContextPath()+"/UserServlet");
        }else{
            response.sendRedirect(request.getContextPath()+"/pages/register.jsp");
        }
    }
}
