package com.fileServer;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by pangkunkun on 2017/9/3.
 */
@Component
public class ParamInit implements ApplicationRunner {
 
    @Value("${windows_server.filepath}")
    String windows_filepath;
    
    @Value("${linux_server.filepath}")
    String linux_filepath;
    
	//zip文件解压路径
	public static String REPORT_ZIP_PATH;
	public static String REPORT_HTML_PATH; 
	public static String FILEPATH; 
	
    
    public void setFilepath() {
     	String osType=System.getProperty("os.name");
    	if(osType.startsWith("Win")) {
    		FILEPATH=windows_filepath;
    	}else {
    		FILEPATH=linux_filepath;
    	}
    	REPORT_ZIP_PATH=FILEPATH+"/";
    	REPORT_HTML_PATH=FILEPATH+"autoops/report_html/"; 
    }
    
    @Override
    public void run(ApplicationArguments var1) throws Exception{
    	setFilepath();
        System.out.println(REPORT_ZIP_PATH);
    }
 
}
