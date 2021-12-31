package com.fan.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.UUID;

/**
 * 首页控制器
 * @author y
 *  @Controller(告诉spring一个控制器)
 */
@Controller
public class IndexController {
    /**
     * @RequestMapping:  不写默认根目录，也可以自定以访问的路径，如（“/index”）,访问的时候需加上/index
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "pages/login";
    }

    /**
     * 启动项目时访问文件上传jsp页面
     * @return
     */
    @GetMapping("upload")
    public String upload() {
        return "pages/upload";
    }

    /**
     *前端form表单post请求时访问的路径
     * @param img
     * @param request
     * @return
     */
    @PostMapping("upload")
    public String upload(MultipartFile[] img, HttpServletRequest request) {
        for (int i = 0; i < img.length; i++) {
            System.out.println("文件名：" + img[i].getOriginalFilename());
            System.out.println("文件大小：" + img[i].getSize());
            System.out.println("文件类型：" + img[i].getContentType());
        }

        try {
        //文件上传
        // 1.根据upload相对路径获取部署到服务之后的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");

        //2.修改源文件名称
        String extension = null;
//        String extensionOne = null;
        for(int i=0;i<img.length;i++){
            //判断上传的几张图片中是否有不需要上传的，如果不需要上传即让其为空即可，
            // 当文件名为空时，不需要获得截取到的文件后缀名称或文件名称，跳出循环，判断下一个
            if(img[i].getOriginalFilename() == null || "".equals(img[i].getOriginalFilename()) ){
                continue;
            }
            //获取到文件的后缀名称，如jpg/txt等
            extension = FilenameUtils.getExtension(img[i].getOriginalFilename());
            //获取到上传的文件的完整名称  根据个人需求：如果只需要上传一张图片则可以直接使用拼接完整的文件名称；
            //如果是上传多张图片可以使用拼接文件后缀名称的方式
//            extensionOne = img[i].getOriginalFilename();
        }

        //3.生成当天日期目录

            LocalDate now = LocalDate.now();
            File dataDir = new File(realPath, now.toString());
            //文件夹不存在，创建
            if (!dataDir.exists()) {
                dataDir.mkdirs();
            }
            //4.将文件上传到upload文件夹对应日期目录中
            for (int i = 0; i<img.length; i++) {
                //如果截取的文件名后缀或者文件名称为空时，不自动生成新的文件名称前缀，结束循环跳出继续下一次循环
                if(img[i].getOriginalFilename() ==null || "".equals(img[i].getOriginalFilename())){
                    continue;
                }
                String newFileName = UUID.randomUUID().toString().replace("-", "") + "." + extension;
//                    String newFileNameOne = UUID.randomUUID().toString().replace("-", "") + "." + extensionOne;
                img[i].transferTo(new File(dataDir, newFileName));
//                    img[i].transferTo(new File(dataDir, newFileNameOne));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "pages/upload";
    }

    /**
     *
     * @param fileName
     * @param request
     * @param response
     */
    @RequestMapping("download")
    public void download(String openStyle, String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("下载文件的名称：" + fileName);

        //在线打开还是附件下载
        openStyle = openStyle == null ? "inline" : "attachment";

        //1.根据下载相对目录获取下载目录在服务器部署之后的绝对目录
        String realPath = request.getSession().getServletContext().getRealPath("/down");

        //2.通过文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, fileName));

        //3.获取响应输出流
        response.setContentType("text/plain;charset=utf-8");

        //4.附件下载(inline代表在线打开，attachment代表下载文件)
        response.setHeader("content-disposition", openStyle + ";fileName=" + URLEncoder.encode(fileName, "UTF-8"));

        //5.处理下载流复制
        ServletOutputStream os = response.getOutputStream();

        //6.使用springMVC工具类
        IOUtils.copy(is, os);
        //优雅关闭
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }
}
