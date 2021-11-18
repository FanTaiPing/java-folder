package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HellowServlet
 */
@WebServlet(urlPatterns={"/HellowServlet"},initParams = {@WebInitParam(name = "initParam",value="Hellow Servlet"),@WebInitParam(name ="aaa",value ="1234566")})
public class HellowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HellowServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//设置请求和响应字符编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String init = getInitParameter("initParam");
		String aaa = getInitParameter("aaa");
		//打印流对象，生成动态HTML（一般用于Ajax返回）
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>这是我的Servlet生成的动态HTLM内容</title>");
		out.println("</head>");
		
		out.println("<body><h1>这是我的第一个Servlet</h1>"
				+ "<h1>初始化参数是"+ init +aaa+"</h1></body>");
		out.println("</html>");
		
		//关闭打印流
		out.close();
	}

}
