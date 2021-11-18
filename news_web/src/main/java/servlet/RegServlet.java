package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

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

		// 设置请求和响应字符集编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");

		// 取
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 调
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		int flag = us.insertUser(user);
		//int flag =0;
		// 转
		// 注册失败
		if (flag != 1) {
			// 会话对象
			HttpSession session = request.getSession();
			session.setAttribute("msg", "注册失败！！");
			// 重定向回注册页面;
			response.sendRedirect(request.getContextPath() + "/pages/register.jsp");
			// 注册成功
		} else {
			//设置request对象里的属性
			request.setAttribute("username", username);
	
			// 转发到登录页面
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath()+"/pages/login.jsp?username="+ username);
		
		}
	}
}
