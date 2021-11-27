package utils;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * @author y
 */
public class FileUpload {
    public User fileUpload(HttpServletRequest request, String uploadPath) {
        User user = new User();

        // 上传的文件名
        String uploadFileName = "";
        // 表单字段元素的属性值
        String filedName = "";
        // 请求信息中的内容是否是multipart类型
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);


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
                        if ("id".equals(filedName)) {
                            // 输出id普通字段
                            user.setId(Integer.parseInt(item.getString("UTF-8")));
//							out.print(item.getString("UTF-8")+"上传了文件<br/>");

                        }else if ("username".equals(filedName)) {
                            // 输出姓名普通字段
                            user.setUsername(item.getString("UTF-8"));

                        } else if ("password".equals(filedName)) {
                            user.setPassword(item.getString("UTF-8"));

                        }

                        // 如果是文件表单字段
                    } else {

                        String fileName = item.getName();
                        if (fileName != null && !"".equals(fileName)) {
                            uploadFileName = UUID.randomUUID().toString().replaceAll("-", "") + fileName;
                            File saveFile = new File(uploadPath, uploadFileName);
                            item.write(saveFile);
                            user.setUserImg(uploadFileName);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
