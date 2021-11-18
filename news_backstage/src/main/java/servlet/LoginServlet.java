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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserService userService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		;
		String username = request.getParameter("name");
		String password = request.getParameter("pwd");
		
		session.removeAttribute("msg");
		User user = userService.login(username, password);
		session.removeAttribute("msg");
		if(user ==null) {
			session.setAttribute("msg", "用户名或密码错误！！");
			response.sendRedirect("login.jsp");
			
		}else {
			if(!user.getUsername().equals(username) && !user.getPassword().equals(password)) {
			session.setAttribute("msg", "用户名或密码错误！！");
			response.sendRedirect("login.jsp");
			return;
				
			}
			//登录成功
			session.setAttribute("user", user);
			
			//刷新用户列表数据
			//request.getRequestDispatcher("/emplistServlet").forward(request, response);
			
			//刷新新闻列表数据
			request.getRequestDispatcher("/NewsEmplistServlet").forward(request, response);
		}
	}
}
