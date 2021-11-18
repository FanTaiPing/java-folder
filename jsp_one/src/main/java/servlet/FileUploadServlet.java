package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class fileUploadServlet
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//上传的文件名
		String uploadFileName ="";
		 //表单字段元素的属性值
		String filedName="";
		//请求信息中的内容是否是multipart类型
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		//上传文件的存储路径（服务器文件系统上的绝对路径）
		//String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
		String uploadPath = "D:\\study\\news_\\webapps\\image";
		//判断是否是带multipart类型文件上传的表单
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				//解析form表单中所有文件对象
				List<FileItem> items = upload.parseRequest(request);
				
				//迭代FileItem
				Iterator<FileItem> iter = items.iterator();
				
				//循环迭代
				while(iter.hasNext()) {
					FileItem item = iter.next();
					 
					//如果是普通表单字段
					if(item.isFormField()) {
						filedName = item.getFieldName();
						if("name".equals(filedName)) {
							//输出姓名普通字段
							out.print(item.getString("UTF-8")+"上传了文件<br/>");
						}
						//如果是文件表单字段
					}else {
						String fileName = item.getName();
						if(fileName !=null && !"".equals(fileName)) {
						File fullFile = new File(item.getName());
						File saveFile = new File(uploadPath,fullFile.getName());
						item.write(saveFile);
						uploadFileName = fullFile.getName();
						out.println("上传文件成功后的文件名是：" + uploadFileName);
						out.print("<img src='../image/"+uploadFileName +"'>");

						}
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
