package filter;

import entity.PageBean;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 公共过滤器
 *
 * @author y
 */
@WebFilter("/*")
public class PublicFilter implements Filter {


    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();

        // 获取请求URL路径
        String url = request.getRequestURI();
//		System.out.println("请求的url:" + url);

        // 获取最后“/”的索引位置
        int idx = url.lastIndexOf("/");
        // 截取url里/的最后一段字符串
        String endWidth = url.substring(idx + 1);
//        不是登录页面，进行拦截处理
//|| "UserServlet".equals(endWidth) || "AuthorServlet".endsWith(endWidth) || "DynastyServlet".equals(endWidth) || "TypeServlet".equals(endWidth) || "PoetryServlet".equals(endWidth)
        if ("index.jsp".equals(endWidth) || "register.jsp".equals(endWidth)){

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
        chain.doFilter(req, res);
    }

    private boolean isLogin(HttpSession session) {

        return session.getAttribute("user") != null ? true : false;
    }
}
