package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

//取
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserService us = new UserServiceImpl();
//调(数据库查询)
		if (us.isExistsUser(username) != null) {
			out.print("<span style ='color:green'>用户名存在，可以登录！！</span>");
			if(us.login(username, password) != null) {
				request.getRequestDispatcher("").forward(request, response);
			}else {
				response.sendRedirect("");
			}

		} else {
			out.print("<span style = 'color:red'>用户名不存在，请先注册！！去<a href ='register.jsp'>注册</a></span>");
		}

//转发

	}

}
