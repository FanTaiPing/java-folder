package utils;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.News;

public class FileUpload {
	public News fileUpload(HttpServletRequest request, String uploadPath) {
		News news = new News();

		// 上传的文件名
		String uploadFileName = "";
		// 表单字段元素的属性值
		String filedName = "";
		// 请求信息中的内容是否是multipart类型
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		// 上传文件的存储路径（服务器文件系统上的绝对路径）
//		String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
//		uploadPath = "D:\\study\\news_backstage\\src\\main\\webapp\\img\\images";
		// 判断是否是带multipart类型文件上传的表单
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			try {
				// 解析form表单中所有文件对象
				List<FileItem> items = upload.parseRequest(request);

				// 迭代FileItem
				Iterator<FileItem> iter = items.iterator();

				// 循环迭代
				while (iter.hasNext()) {
					FileItem item = iter.next();

					// 如果是普通表单字段
					if (item.isFormField()) {
						filedName = item.getFieldName();
						if ("title".equals(filedName)) {
							// 输出姓名普通字段
							news.setTitle(item.getString("UTF-8"));
//							out.print(item.getString("UTF-8")+"上传了文件<br/>");

						} else if ("author".equals(filedName)) {
							news.setAuthor(item.getString("UTF-8"));

						} else if ("content".equals(filedName)) {
							news.setContent(item.getString("UTF-8"));

						} else if ("typeId".equals(filedName)) {
							news.setTypeId(Integer.parseInt(item.getString("UTF-8")));
						}

						// 如果是文件表单字段
					} else {
						String fileNames = item.getFieldName();

						if ("smImg".equals(fileNames)) {
							String fileNameSm = item.getName();
							if (fileNameSm != null && !"".equals(fileNameSm)) {
								uploadFileName = UUID.randomUUID().toString().replaceAll("-", "") + fileNameSm;
								File saveFile = new File(uploadPath, uploadFileName);
								item.write(saveFile);
								news.setSmImg(uploadFileName);
							}
						} else if ("laImg".equals(fileNames)) {
							String fileNameLa = item.getName();
							if (fileNameLa != null && !"".equals(fileNameLa)) {
								uploadFileName = UUID.randomUUID().toString().replaceAll("-", "") + fileNameLa;
								File saveFile = new File(uploadPath, uploadFileName);
								item.write(saveFile);
								news.setLaImg(uploadFileName);
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return news;
	}
}
