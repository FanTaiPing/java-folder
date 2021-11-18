package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegiServlet
 */
@WebServlet("/RegiServlet")
public class RegiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegiServlet() {
		super();

	}

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
		// 设置字符集编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		// 取值
		String username = request.getParameter("reusername");
		String password = request.getParameter("password");

		// 创建一个打印流对象
		PrintWriter out = response.getWriter();

		// 调用service层的查询用户是否存在数据库中的方法
		// 先判断用户是否存在，如果存在则可以直接登录，如不存在则需要注册
		UserService us = new UserServiceImpl();
		User user =us.isExistsUser(username);
		if (user != null) {
			out.print("<span style ='color:green'>用户名已存在，您可以直接登录！！去<a href='login.jsp'>登录</a></span>");
			if (us.insertUser(username, password) != null) {

				// 转发
				// request.getRequestDispatcher("ajax/login.jsp");
			} else {
				// 重定向
				// response.sendRedirect("ajax/register.jsp");
			}
		} else {
			out.print("<span style = 'color:red'>用户名不存在，可以注册！！</span>");
		}
	}
}
