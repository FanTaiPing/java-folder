package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class DelSelectedServlet
 */
@WebServlet("/DelSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelSelectedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取所有id
		String[] ids = request.getParameterValues("uid");
		//2.调用service的删除选中方法
		UserService service = new UserServiceImpl();
		service.delSelectedUser(ids);
		
		//3.跳转查询所有servlet
		response.sendRedirect(request.getContextPath()+"/emplistServlet");
	}

}
