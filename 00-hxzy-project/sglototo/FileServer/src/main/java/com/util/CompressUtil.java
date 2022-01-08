package com.util;

import com.fileServer.ParamInit;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;

public class CompressUtil {
 
    
	public static String test_unZipFiles_report() {
		// zip文件解压路径
		String filename = "20180716112143.zip";

		String fileAddress = ParamInit.REPORT_ZIP_PATH + filename;
		StringBuffer sbf = new StringBuffer();

		String copyAddress = "";

		CompressUtil.unZipFiles(fileAddress, ParamInit.REPORT_ZIP_PATH);

		String[] strArr = filename.split("/.");
//		String[] strArr = filename.split("\\.");

		filename = strArr[0];

		if (filename != null) {
			copyAddress = ParamInit.REPORT_HTML_PATH + filename + "/";
		}
		FileUtil.copyDir(ParamInit.REPORT_ZIP_PATH + filename, copyAddress);
		// fileUtil.delFolder(fileAddress);

		List<File> files = FileUtil.searchFiles(new File(ParamInit.REPORT_ZIP_PATH + filename), ".htm");
		// System.out.println("共找到:" + files.size() + "个文件");

		for (File file : files) {
			sbf.append(file.getAbsolutePath());
			System.out.println(file.getAbsolutePath());
		}
		return sbf.toString();
	}

	public static void main(String args[]){
	    CompressUtil.unZipFiles("d:/fileServer//2019041115175992437.rar",ParamInit.REPORT_ZIP_PATH);
    }

    /** 
     * 解压文件到指定目录 
     * 解压后的文件名，和之前一致 
     * @param zipFile   待解压的zip文件 
     * @param descDir   指定目录 
     */  
    @SuppressWarnings("rawtypes")  
    public static void unZipFiles(String zipFileDir, String descDir)  {  
          
    	File zipFile=new File(zipFileDir);
    	
        ZipFile zip;
		try {
			zip = new ZipFile(zipFile,"UTF-8");
		
			//解决中文文件夹乱码  
        String name = zipFile.getName().substring(zipFile.getName().lastIndexOf('\\')+1, zipFile.getName().lastIndexOf('.'));  

        File pathFile = new File(descDir+name);  
        if (!pathFile.exists()) {  
            pathFile.mkdirs();  
        }  
          
        for (Enumeration<? extends ZipEntry> entries = zip.getEntries(); entries.hasMoreElements();) {  
            ZipEntry entry = (ZipEntry) entries.nextElement();  
            String zipEntryName = entry.getName();  
            InputStream in = zip.getInputStream(entry);  
            String outPath = (descDir + name +"/"+ zipEntryName).replaceAll("\\*", "/");  
              
            // 判断路径是否存在,不存在则创建文件路径  
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));  
            if (!file.exists()) {  
                file.mkdirs();  
            }  
            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压  
            if (new File(outPath).isDirectory()) {  
                continue;  
            }  
            // 输出文件路径信息  
//          System.out.println(outPath);  
  
            FileOutputStream out = new FileOutputStream(outPath);  
            byte[] buf1 = new byte[1024];  
            int len;  
            while ((len = in.read(buf1)) > 0) {  
                out.write(buf1, 0, len);  
            }  
            in.close();  
            out.close();  
        }  
        System.out.println("******************解压完毕********************"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return;  
    }  
    
}



