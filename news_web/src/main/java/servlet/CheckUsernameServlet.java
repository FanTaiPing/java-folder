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
 * Servlet implementation class CheckUsernameServlet
 */
@WebServlet("/CheckUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUsernameServlet() {
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

		// 创建打印流对象
		PrintWriter out = response.getWriter();

		// 取
		String flag = request.getParameter("flag");
		String username = request.getParameter("username");

		// 调
		User user = userService.isExistsUser(username);
		Map<String, Object> map = new HashMap<String, Object>(16);
		// 转
		// 响应客户端Ajax请求，返回流字符串数据
		if ("注册".equals(flag)) {
			// 查看用户名不存在，可以注册
			if (user == null) {

				out.println("{\r\n" + "	\"msg\": \"用户名不存在，可以注册\",\r\n" + "	\"flag\": true\r\n" + "}");
			} else {
				/*
				 * out.println("{\r\n" + "    \"msg\":\"用户名已存在，请重新输入\",\r\n" +
				 * "    \"flag\":false\r\n" + "}");
				 */

				map.put("flag", false);
				map.put("msg", "用户名已存在，请重新输入！！");
				// fastJson转换java的map对象成Json对象
				// 方法一：
				// out.println(new JSONObject(map));
				// 方法二：
				out.println(JSON.toJSON(map));
			}

		} else if ("登录".equals(flag)) {
			// 查询用户名存在，可以登录

			if (user != null) {
				map.put("flag", true);
				map.put("msg", "用户名已存在，可以登录");
				// fastJson转换java的map对象成Json对象
				out.println(new JSONObject(map));
			} else {
				map.put("flag", false);
				map.put("msg", "用户名不存在，请先去<a href='/news_web/pages/register.jsp'>注册</a>");
				out.println(JSON.toJSON(map));
			}
		}
	}
}
