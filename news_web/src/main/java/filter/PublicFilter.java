package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Nav;
import entity.NewsType;
import service.NavService;
import service.NewsTypeService;
import service.impl.NavServiceImpl;
import service.impl.NewsTypeServiceImpl;

/**
 * Servlet Filter implementation class PublicFilter
 */
@WebFilter("/*")
public class PublicFilter implements Filter {
	private NavService navService = new NavServiceImpl();

	/**
	 * Default constructor.
	 */
	public PublicFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();

		// 存到session对象里
		if (session.getAttribute("nav") == null) {
//		 刷首页数据导航条、分类表、新闻类表
			List<Nav> nav = navService.findAll();
			session.setAttribute("nav", nav);
		}

		// 获取请求URL路径
		String url = request.getRequestURI();
//		System.out.println("请求的url:" + url);

		// 获取最后“/”的索引位置
		int idx = url.lastIndexOf("/");
		// 截取url里/的最后一段字符串
		String endWidth = url.substring(idx + 1);
		/* 不是登录页面，进行拦截处理 */
		if ("index.jsp".equals(endWidth) || "detail.jsp".equals(endWidth)) {

			// 判断用户是否登录成功，并把登录的user对象存储到session对象里
			if (!isLogin(session)) {
				// 没有登录，跳转到登录页面
				response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
				return;
			}
			chain.doFilter(req, res);
		} else {
			// 是登陆或注册页面，直接放行下一个过滤器
			chain.doFilter(req, res);
			return;
		}
	}

	private boolean isLogin(HttpSession session) {

		return session.getAttribute("user") != null ? true : false;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
