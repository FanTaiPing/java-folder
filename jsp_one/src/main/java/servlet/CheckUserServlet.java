package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class CheckUserServlet
 */
@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUserServlet() {
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

		String username = request.getParameter("username");
		String flag = request.getParameter("flag");

		PrintWriter out = response.getWriter();
		Map<String, Object> map = new HashMap<String, Object>(20);
		User user = userService.isExistsUser(username);

		if ("注册".equals(flag)) {
			if (user != null) {
				map.put("flag", true);
				map.put("msg", "此用户已存在，请重新输入！！！");
				out.println(new JSONObject(map));
			} else {
				map.put("flag", false);
				map.put("msg", "用户名不存在，可以注册");
				out.println(JSON.toJSON(map));

			}
		} else if ("登录".equals(flag)) {
			if (user != null) {
				map.put("flag", true);
				map.put("msg", "此用户已存在，可以登录");
				out.println(new JSONObject(map));
			} else {
				map.put("flag", false);
				map.put("msg", "此用户不存在，请先注册");
				out.println(JSON.toJSON(map));
			}
		}

	}

}
