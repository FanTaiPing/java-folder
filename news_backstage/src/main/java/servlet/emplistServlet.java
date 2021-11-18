package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.PageBean;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class emplistServlet
 */
@WebServlet("/emplistServlet")
public class emplistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserService userService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public emplistServlet() {
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
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取显示页面拼接的的参数
		String currentPage = request.getParameter("currentPage");//当前页码
		String rows = request.getParameter("rows");//每页显示条数
		
		//首次进入列表信息显示页面时，默认从第一页开始显示，每页显示rows条记录
		if(currentPage == null || "".equals(currentPage)){
			currentPage = "1";	
		}
		if(rows == null || "".equals(rows)) {
			rows = "5";
		}
		
		//获取条件查询的参数
		//Map<String,String[]> condition = request.getParameterMap();
		
		
		//调用service 查询
		PageBean<User> user = userService.findAll(currentPage, rows);
//		System.out.println(user);
		//将PageBean存入request
		request.removeAttribute("user");
		if(user != null) {
			request.setAttribute("user", user);
			//转发到emplist.jsp显示用户信息页面
			request.getRequestDispatcher("/emplist.jsp").forward(request, response);
		}		
	}
}
