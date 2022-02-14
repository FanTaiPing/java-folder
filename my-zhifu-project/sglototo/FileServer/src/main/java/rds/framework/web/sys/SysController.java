package rds.framework.web.sys;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping({"/projects/"})
public class SysController {

    String FILEPATH;

    private int fileLevel;


    /**
     */
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String getinfo(HttpServletResponse response, HttpServletRequest request ) throws IOException {

        return "";
    }

     /**
      * @return
      * @throws IOException
      */
     @RequestMapping(value="/remove/{project}",method = RequestMethod.GET)
     public void remove(@RequestParam("filename") String filename, HttpServletResponse response, HttpServletRequest request,
                          @PathVariable String project) throws IOException {

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



    /**
     */
    @RequestMapping(value="/getinfo",method = RequestMethod.GET)
    public String getinfo(HttpServletResponse response, HttpServletRequest request,
                                 @PathVariable String project) throws IOException {
        String path = project.replace(".","/");
        StringBuffer sbf = new StringBuffer();
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        if (file.exists()) {
            LinkedList<File> list = new LinkedList<File>();
            File[] files = file.listFiles();
            for (File file2 : files) {
                if (file2.isDirectory()) {
//                    System.out.println("file夹:" + file2.getAbsolutePath());
                    sbf.append("</br>");
                    sbf.append("folder:" + file2.getAbsolutePath());
                    list.add(file2);
                    folderNum = folderNum+1 ;
                } else {
//                    System.out.println("file:" + file2.getAbsolutePath());
                    sbf.append("</br>");
                    sbf.append("file:" + file2.getAbsolutePath());
                    fileNum++;
                }
            }
            File temp_file;
            while (!list.isEmpty()) {
                temp_file = list.removeFirst();
                files = temp_file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
//                        System.out.println("folder :" + file2.getAbsolutePath());
                        sbf.append("</br>");
                        sbf.append(" :" + file2.getAbsolutePath());
                        list.add(file2);
                        folderNum++;
                    } else {
//                        System.out.println("file:" + file2.getAbsolutePath());
                        sbf.append("</br>");
                        sbf.append("file:" + file2.getAbsolutePath());
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



}