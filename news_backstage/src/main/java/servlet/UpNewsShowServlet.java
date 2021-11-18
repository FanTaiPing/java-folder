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
import service.impl.NewsServiceImpl;
import utils.FileUpload;

/**
 * Servlet implementation class UpNewsShowServlet
 */
@WebServlet("/UpNewsShowServlet")
public class UpNewsShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsService newsService = new NewsServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpNewsShowServlet() {
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
		String path="D:\\study\\news_backstage\\src\\main\\webapp\\img\\images";
		News news =new FileUpload().fileUpload(request, path);
		int id = Integer.parseInt(request.getParameter("id"));
		news.setId(id);

		int flag = newsService.updateNews(news);
		if(flag == 1) {
			//添加成功
			response.sendRedirect(request.getContextPath()+"/NewsEmplistServlet");
			
		}else {
			response.sendRedirect(request.getContextPath()+"/NewsEmplistServlet");
		}
	}
}
