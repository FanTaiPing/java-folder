package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.News;
import entity.PageBean;
import service.NewsService;
import service.impl.NewsServiceImpl;

/**
 * Servlet implementation class newsEmplistServlet
 */
@WebServlet("/NewsEmplistServlet")
public class NewsEmplistServlet extends HttpServlet {
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
		//获取前端显示的当前页码和每页显示数据的条数
		//前端获取到的值时拼接字符串，因此需要强转为int类型
		String _currnetPage = request.getParameter("currentPage");
		String _rows = request.getParameter("rows");

		
		//首次进入列表信息显示页面时，默认从第一页开始显示，每页显示rows条记录
		if(_currnetPage == null || "".equals(_currnetPage)){
			_currnetPage = "1";	
		}
		if(_rows == null || "".equals(_rows)) {
			_rows = "5";
		}
		int currentPage = (Integer.parseInt(_currnetPage));
		int rows = (Integer.parseInt(_rows));
		//调用查询每页显示数据的查询方法
		PageBean<News> news = newsService.findNewsByPage(currentPage, rows);
		if(news != null) {
			//将news对象存到request域中
			request.setAttribute("news", news);
			
			//转发到newsEmplist.jsp界面显示查到的数据
			request.getRequestDispatcher("/newsEmplist.jsp").forward(request, response);
			
		}	
	}
}
