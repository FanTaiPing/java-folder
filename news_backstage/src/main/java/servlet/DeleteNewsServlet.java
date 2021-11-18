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

/**
 * Servlet implementation class DeleteNewsServlet
 */
@WebServlet(name = "deleteNewsServlet", urlPatterns = { "/deleteNewsServlet" })
public class DeleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsService newsService = new NewsServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewsServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		
		int flag = newsService.delNewsById(id);
		if(flag !=0) {
			request.getRequestDispatcher("/NewsEmplistServlet").forward(request, response);
		}else {
			request.getRequestDispatcher("/NewsEmplistServlet").forward(request, response);
		}
		
	}

}
