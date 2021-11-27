package servlet;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.FileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author y
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="D:\\study\\poetryss\\web\\images";
        User user = new FileUpload().fileUpload(request,path);
        int flag = userService.updateUser(user);
        if(flag == 1){
            //修改成功之后，跳回登录界面重新登录
            response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/pages/updateUser.jsp");
        }
    }
}
