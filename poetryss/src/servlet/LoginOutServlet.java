package servlet;

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
@WebServlet("/LoginOutServlet")
public class LoginOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        HttpSession session = request.getSession();
        //用户对象不为空，移出session对象里面的用户
        if(session.getAttribute("user") !=null) {
            session.removeAttribute("user");
            response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
        }
    }
}
