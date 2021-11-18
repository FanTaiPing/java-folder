package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.News;
import service.NewsService;
import service.impl.NewsServiceImpl;
import utils.FileUpload;

/**
 * Servlet implementation class AddNews
 */
@WebServlet("/AddNews")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsService newsService = new NewsServiceImpl();


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
		String path="D:\\study\\news_backstage\\src\\main\\webapp\\img\\images";
		News news =new FileUpload().fileUpload(request, path);
		
		int flag = newsService.addNews(news);
		if(flag != 0) {
			response.sendRedirect(request.getContextPath()+"/NewsEmplistServlet");
			
		}else {
			response.sendRedirect(request.getContextPath()+"/NewsEmplistServlet");
		}
	}
}
