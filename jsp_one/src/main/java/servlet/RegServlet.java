package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet(urlPatterns = { "/RegServlet" }, initParams = { @WebInitParam(name = "HttpServlet", value = "") })
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegServlet() {
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

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//字符集编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//取
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");

		//转发
		if("admin".equals(username)&&"admin".equals(password)) {
			//注册成功，转发到欢迎页面
			request.getRequestDispatcher("one/welcome.jsp").forward(request, response);
		}else {
			//注册失败，重定向回注册页面
			response.sendRedirect("one/register.jsp");
		}
	}
}
