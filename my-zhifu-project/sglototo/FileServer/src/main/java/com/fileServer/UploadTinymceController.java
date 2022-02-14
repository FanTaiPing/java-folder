package com.fileServer;

import com.util.FileBean;
import com.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadTinymceController {

	@Value("${windows_server.filepath}")
    String FILEPATH;
 
    @Value("${windows_server.filepath}")
    String windows_filepath;
    
    @Value("${linux_server.filepath}")
    String linux_filepath;
    
	//zip文件解压路径
	 String REPORT_ZIP_PATH;
	 String REPORT_HTML_PATH;

    private static final Logger logger = LoggerFactory.getLogger(UploadTinymceController.class);
    
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
    


    @PostMapping(value = "/tinymce/upload/{project}")
    public FileBean uploadFile( @RequestBody  MultipartFile file, @PathVariable String project){
    	setFilepath();
    	 String module="";//request.getParameter("module");
    	 /**
    	  * 客户端自定义文件名称
    	  */
    	 String myfilename=null;//request.getParameter("filename");
        String fileRealName = file.getOriginalFilename();
//        System.out.println("fileRealName-->" + fileRealName);
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
        logger.info("OriginalFilename:{}", fileRealName, "newFilename:"+FILEPATH_ + fileNewName+extenName);
        FileBean f = new FileBean();
        f.setNewname(fileNewName+extenName);
        f.setOriginalFilename(fileRealName);
        return f;
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