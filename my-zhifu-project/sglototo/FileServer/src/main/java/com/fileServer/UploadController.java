package com.fileServer;

import com.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

@RestController
public class UploadController {
	@Value("${windows_server.filepath}")
    String FILEPATH;
 
    @Value("${windows_server.filepath}")
    String windows_filepath;
    
    @Value("${linux_server.filepath}")
    String linux_filepath;
    
	//zip文件解压路径
	 String REPORT_ZIP_PATH;
	 String REPORT_HTML_PATH; 
	
    
    public void setFilepath() {
     	String osType=System.getProperty("os.name");
    	if(osType.startsWith("Win")) {
    		FILEPATH=windows_filepath;
    	}else {
    		FILEPATH=linux_filepath;
    	}
    	REPORT_ZIP_PATH=FILEPATH+"autoops/report_zip/";
    	REPORT_HTML_PATH=FILEPATH+"autoops/report_html/"; 
    }
    
    //文件下载相关代码
    @RequestMapping("/index")
    public String downloadFile(){
    	 
        return ParamInit.REPORT_HTML_PATH;
    }
    


    @RequestMapping(value = "/upload/{project}")
    @Transactional
    public ResponseEntity<?> uploadFile(Model model, @RequestParam("file") MultipartFile file,
                                        HttpServletRequest request, @PathVariable String project){
    	setFilepath();
    	 String module=request.getParameter("module");
    	 /**
    	  * 客户端自定义文件名称
    	  */
    	 String myfilename=request.getParameter("filename");
        String fileRealName = file.getOriginalFilename();
        System.out.println("fileRealName-->" + fileRealName);
        byte[] bytes=null;
		try {
			bytes = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        Path path = Paths.get(ParamInit.FILEPATH + fileServer.getOriginalFilename());
        System.out.println(bytes.length);
        String fileNewName=FileUtil.getNewFileName();
        String extenName=FileUtil.getFileExten4Str(fileRealName);
        String FILEPATH_="";
        if(module!=null) {
       	  FILEPATH_ =ParamInit.FILEPATH+project+"/"+module+"/";
        }else {
       	  FILEPATH_ =ParamInit.FILEPATH+project+"/";
        }
        FileUtil.createDir(FILEPATH_);
        
        /*
         * 使用客户端传输的文件名
         * 否则系统自动生成唯一文件名
         */
        if(myfilename!=null) {
        	fileNewName=myfilename;       	
        }
        Path  path = Paths.get(FILEPATH_ + fileNewName+extenName);
        try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String fileExten=FileUtil.getFileExten(FILEPATH_ + file.getOriginalFilename());

        return new ResponseEntity<Object>("{originalfilename:'"+fileRealName+"',filename:'"+
                fileNewName+extenName+"'}", new HttpHeaders(), HttpStatus.OK);
    }


    /**
     * post 方式上传
     * @param model
     * @param file
     * @param request
     * @param project
     * @return
     */
    @PostMapping(value = "/uploadfiles/{project}")
    @Transactional
    public ResponseEntity<?> uploadFiles(Model model, @RequestParam("file") MultipartFile file,
                                         HttpServletRequest request, @PathVariable String project){
    	setFilepath();
    	 String module=request.getParameter("module");
    	 /**
    	  * 客户端自定义文件名称
    	  */
    	 String myfilename=request.getParameter("filename");
        String fileRealName = file.getOriginalFilename();
        System.out.println("fileRealName-->" + fileRealName);
        byte[] bytes=null;
		try {
			bytes = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        Path path = Paths.get(ParamInit.FILEPATH + fileServer.getOriginalFilename());
        System.out.println(bytes.length);
        String fileNewName=FileUtil.getNewFileName();
        String extenName=FileUtil.getFileExten4Str(fileRealName);
        String FILEPATH_="";
        if(module!=null) {
       	  FILEPATH_ =ParamInit.FILEPATH+project+"/"+module+"/";
        }else {
       	  FILEPATH_ =ParamInit.FILEPATH+project+"/";
        }
        FileUtil.createDir(FILEPATH_);

        /*
         * 使用客户端传输的文件名
         * 否则系统自动生成唯一文件名
         */
        if(myfilename!=null) {
        	fileNewName=myfilename;
        }
        Path  path = Paths.get(FILEPATH_ + fileNewName+extenName);
        try {
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String fileExten=FileUtil.getFileExten(FILEPATH_ + file.getOriginalFilename());

        return new ResponseEntity<Object>("{originalfilename:'"+fileRealName+"',filename:'"+
                fileNewName+extenName+"'}", new HttpHeaders(), HttpStatus.OK);
    }


    /**
     * 上传发布文件： 先保存在临时目录，用户确认后再拷贝到指定目录
     * @param model
     * @param file
     * @param request
     * @param project
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadPublish/{project}")
    @Transactional
    public ResponseEntity<?> uploadPublishFile(Model model, @RequestParam("file") MultipartFile file, HttpServletRequest request, @PathVariable String project){
        setFilepath();
        String module=request.getParameter("module");
        module = "publish/"+module;

        if(!limitFile(file,500)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        /**
         * 客户端自定义文件名称
         */
        String myfilename=request.getParameter("filename");
        String fileRealName = file.getOriginalFilename();
        System.out.println("fileRealName-->" + fileRealName);

        String fileNewName=FileUtil.getNewFileName();
        String extenName=FileUtil.getFileExten4Str(fileRealName);
        String FILEPATH_="";
        if(module!=null) {
            FILEPATH_ =ParamInit.FILEPATH+project+"/"+module+"/";
        }else {
            FILEPATH_ =ParamInit.FILEPATH+project+"/";
        }
        FileUtil.createDir(FILEPATH_);



        if(myfilename!=null) {
            fileNewName=myfilename;
        }
        Path  path = Paths.get(FILEPATH_ + fileNewName+extenName);
        try {
            /**
             * 保存到一个目标文件中。
             */
            file.transferTo(new File(FILEPATH_ + fileNewName+extenName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String fileExten=FileUtil.getFileExten(FILEPATH_ + file.getOriginalFilename());
        return new ResponseEntity<Object>("{originalfilename:'"+fileRealName+"',filename:'"+
                fileNewName+extenName+"'}", new HttpHeaders(), HttpStatus.OK);
    }


     /**
      * @return
      * @throws IOException
      */
     @RequestMapping(value="/download/{project}",method = RequestMethod.GET)
     public void download(@RequestParam("filename") String filename, HttpServletResponse response, HttpServletRequest request,
                          @PathVariable String project) throws IOException {
    	 setFilepath();
         response.setContentType("text/html");
    	 String module=request.getParameter("module");
    	 String fileshowname=request.getParameter("fileshowname");
         javax.servlet.ServletOutputStream ou = response.getOutputStream();
         System.out.println("DownloadFile filepath:" + filename);
         String FILEPATH_="";
         if(module!=null) {
        	  FILEPATH_ =FILEPATH+project+"/"+module+"/";
         }else {
        	  FILEPATH_ =FILEPATH+project+"/";
         }
         File file = new File(FILEPATH_+filename);
         if (!file.exists()) {
             System.out.println(file.getAbsolutePath() + " 文件不存在!");
             return;
         }
         java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
         // 下载文件
         // 设置响应头和下载保存的文件名
         if (filename != null && filename.length() > 0) {
             //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        	 
             response.setContentType("application/x-msdownload; charset=utf-8");
//             response.setContentType("multipart/form-data");
             filename=fileshowname==null?filename:fileshowname;
             response.addHeader("Content-Disposition", "attachment;filename="
                     + new String(filename.replaceAll(" ", "").getBytes("utf-8"),
                     "iso8859-1"));

             if (fileInputStream != null) {
                 int filelen = fileInputStream.available();
                 //文件太大时内存不能一次读出,要循环
                 byte a[] = new byte[filelen];
                 fileInputStream.read(a);
                 ou.write(a);
             }
             fileInputStream.close();
             ou.close();
         }
     }


    /**
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/getinfo/{project}",method = RequestMethod.GET)
    public String traverseFolder(HttpServletResponse response, HttpServletRequest request,
                         @PathVariable String project) throws IOException {
        String path = project.replace(".","/");
        StringBuffer sbf = new StringBuffer();
        String level = "0";
        String state = request.getParameter("state");
        level = state==null? "0":state;
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
//                    System.out.println("file夹:" + file2.getAbsolutePath());
                    if(level=="1")sbf.append("file:" + file2.getAbsolutePath()+"</br>");
                    list.add(file2);
                    folderNum = folderNum+1 ;
                } else {
//                    System.out.println("file:" + file2.getAbsolutePath());
                    if(level=="1")sbf.append("file:" + file2.getAbsolutePath()+"</br>");
                    fileNum++;
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
//                        System.out.println("" + file2.getAbsolutePath());
                        sbf.append("" + file2.getAbsolutePath()+"</br>");
                        list.add(file2);
                        folderNum++;
                    } else {
//                        System.out.println("file:" + file2.getAbsolutePath());
                        if(level=="1")sbf.append("file:" + file2.getAbsolutePath()+"</br>");
                        fileNum++;
                    }
                }
            }
        } else {
//            System.out.println("file不存在");
            sbf.append("</br>");
            sbf.append("file不存在!");
        }
//        System.out.println("folder共有:" + folderNum + ",file共有:" + fileNum);
        sbf.append("</br>");
        sbf.append("folder共有:" + folderNum + ",file共有:" + fileNum);

        return sbf.toString();
    }

     /**
      * @return
      * @throws IOException
      */
     @RequestMapping(value="/remove/{project}",method = RequestMethod.GET)
     public void remove(@RequestParam("filename") String filename, HttpServletResponse response, HttpServletRequest request,
                          @PathVariable String project) throws IOException {
    	 setFilepath();
         String module=request.getParameter("module");
         String fileshowname=request.getParameter("fileshowname");
         javax.servlet.ServletOutputStream ou = response.getOutputStream();
         String FILEPATH_="";
         project= project.replace(fileshowname,module);
         if(module!=null) {
             FILEPATH_ =project+"/"+filename;
         }else {
             FILEPATH_ =project+"/";
         }
         File file = new File(FILEPATH_);

         if (file.isDirectory()) {
             File folder = new File(FILEPATH_);
             getDelete(folder);
             return;
         }else {
             file.delete();
         }
     }

    private  void getDelete(File file) {
        File[] files = file.listFiles();
        if(files!=null){
            for (File file2 : files) {
                if(file2.isFile()){
                    file2.delete();
                }else if(file2.isDirectory()){
                    getDelete(file2);
                    file2.delete();
                }
            }
        }

    }



    private boolean limitFile(MultipartFile file, int LIMIT_SIZE){
        boolean state=false;
        Double d=new Double(file.getSize());
        Double fileSize = new Double(d/1048576);
        int size = (int)Math.ceil(d/1048576);
        if(size<=LIMIT_SIZE){
            state=true;
        }
        return state;
    }

}