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
 * Servlet implementation class NewsServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private NewsService newsService = new NewsServiceImpl();
    private NewsTypeService newsTypeService = new NewsTypeServiceImpl();
       
       /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
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
	//将string类型强转为int	
	int id =Integer.parseInt(request.getParameter("id"));
	List<News> newsId = newsService.findDetail(id);

		request.setAttribute("newsId", newsId);
		
		if(request.getAttribute("hotNews") ==null){
			List<News> hotNews = newsService.findHotNews();
			request.setAttribute("hotNews",hotNews);	
		}else{
			request.removeAttribute("hotNews");
		}
		

		if(request.getAttribute("newsTypeName") ==null){
			
			List<NewsType> newsTypeName = newsTypeService.findTypeId(id);
			request.setAttribute("newsTypeName",newsTypeName);	
			
		}else{
			request.removeAttribute("newsTypeName");
		}
		//转发
		request.getRequestDispatcher("/pages/detail.jsp").forward(request, response);

	}

}
