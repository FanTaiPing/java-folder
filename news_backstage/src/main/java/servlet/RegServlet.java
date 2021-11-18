package servlet;

import java.io.IOException;
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
 * Servlet implementation class loginServlet
 */
@WebServlet("/regServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		response.setContentType("text/html;charset=utf-8");

		// 验证码验证
		HttpSession session = request.getSession();
		// toLower() 忽略大小写 trim() 去除前后空格
		String code = request.getParameter("number").toLowerCase().trim();
		String systemCode = (String) session.getAttribute("rand");
		if (!systemCode.equals(code)) {
			request.setAttribute("msg", "验证码错误，请重新注册！！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("pwd");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			int flag = userService.userInsert(user);
			if (flag == 1) {
				request.getRequestDispatcher("login.jsp").forward(request, response);

			} else {
				response.sendRedirect(request.getContextPath() + "/register.jsp");
			}
		}
	}

}
