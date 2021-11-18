package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.News;
import entity.NewsType;
import service.NewsService;
import service.NewsTypeService;
import service.impl.NewsServiceImpl;
import service.impl.NewsTypeServiceImpl;

/**
 * Servlet implementation class NewsTypeService
 */
@WebServlet("/NewsTypeServlet")
public class NewsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsTypeService ntService = new NewsTypeServiceImpl();
	private NewsService newsService = new NewsServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsTypeServlet() {
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
		int newId = Integer.parseInt(request.getParameter("id"));

		News newsId = newsService.findNewsById(newId);
		if (newsId != null) {
			request.setAttribute("newsId", newsId);

			List<NewsType> newsType = ntService.findNewsTypeById(newsId.getTypeId());
			if (newsType != null) {
				request.setAttribute("newsType", newsType);
				request.getRequestDispatcher("/newsUpdate.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/NewsEmplistServlet");
			}
		}
	}
}
