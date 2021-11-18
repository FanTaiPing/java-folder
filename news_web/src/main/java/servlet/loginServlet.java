package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Nav;
import entity.NewsType;
import entity.User;
import service.NavService;
import service.NewsTypeService;
import service.UserService;
import service.impl.NavServiceImpl;
import service.impl.NewsTypeServiceImpl;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private NavService navService = new NavServiceImpl();
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setCharacterEncoding("utf-8");
		// response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = userService.login(username, password);
		// 清除一下msg的Session
		if (session.getAttribute("msg") != null) {
			session.removeAttribute("msg");
		}
		if (user != null) {
			session.setAttribute("user", user);
			// 刷首页数据导航条、分类表、新闻类表
//			List<Nav> nav = navService.findAll();			
			// 存到request对象里
//			request.setAttribute("nav", nav);

			
			/**
			 * 登录成功之后
			 */
			// 转发到首页
			//request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
		//重定向到首页
			response.sendRedirect(request.getContextPath() +"/pages/index.jsp");
		
		} else {

			session.setAttribute("msg", "用户名或密码不正确！！");
			// 重定向
			response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
		}
	}
}
