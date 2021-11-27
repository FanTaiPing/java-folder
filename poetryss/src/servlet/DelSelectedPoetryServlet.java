package servlet;

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
@WebServlet("/DelSelectedPoetryServlet")
public class DelSelectedPoetryServlet extends HttpServlet {
    private PoetryService poetryService = new PoetryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取所有id
        String[] ids = request.getParameterValues("uid");
        //2.调用service的删除选中方法
        PoetryService service = new PoetryServiceImpl();
        service.delSelectedPoetry(ids);

        //3.跳转查询所有servlet
        response.sendRedirect(request.getContextPath()+"/PoetryServlet");
    }
}
