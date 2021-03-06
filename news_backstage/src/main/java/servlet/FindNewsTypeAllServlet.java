package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.NewsType;
import service.NewsTypeService;
import service.impl.NewsTypeServiceImpl;

/**
 * Servlet implementation class FindNewsTypeAllServlet
 */
@WebServlet("/FindNewsTypeAllServlet")
public class FindNewsTypeAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsTypeService newsTypeService = new NewsTypeServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindNewsTypeAllServlet() {
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
		List<NewsType> newsType = newsTypeService.findAllNewsType();
		if(newsType != null) {
			request.setAttribute("newsType", newsType);
			request.getRequestDispatcher("/addNews.jsp").forward(request, response);
		}
		
	}

}
