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

import entity.News;
import entity.NewsType;
import entity.Page;
import service.NewsService;
import service.NewsTypeService;
import service.impl.NewsServiceImpl;
import service.impl.NewsTypeServiceImpl;

/**
 * Servlet Filter implementation class QindexFilter
 */
@WebFilter("/pages/index.jsp")
public class QindexFilter implements Filter {
	private NewsTypeService newsTypeService = new NewsTypeServiceImpl();
	private NewsService newsService = new NewsServiceImpl();

	/**
	 * Default constructor.
	 */
	public QindexFilter() {
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

		if (request.getAttribute("newsType") == null) {

			// 新闻分类列表
			List<NewsType> newsType = newsTypeService.findAll();
			// 存到request对象里
			request.setAttribute("newsType", newsType);

			if (request.getAttribute("news") == null) {
				Page page = new Page();
				//设置新闻总记录条数（从数据库中查新）
				page.setTotalCount(newsService.count());
				int current = 0;
				
				if(request.getParameter("currentSize")== null) {
				current = 1;	
				}else {
					current = Integer.parseInt(request.getParameter("currentSize"));
					page.setCurrentPageNo(current);
				}
				
				// 中间内容部分显示列表
				page.setNewsList(newsService.findAll(current,page.getPageSize(),page.getTotalPageCount())); 
				// 将news对象存到request请求域中
				request.setAttribute("news", page.getNewsList());
				request.setAttribute("page", page);
							
					// 中间内容部分显示列表
					List<News> hotNews = newsService.findHotNews();
					// 将news对象存到request请求域中
					request.setAttribute("hotNews", hotNews);
			}
		}
		chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}
}
