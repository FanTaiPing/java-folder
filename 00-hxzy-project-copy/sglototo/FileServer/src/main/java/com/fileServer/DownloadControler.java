package com.fileServer;

import com.util.UrlFilesToZip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@RestController
public class DownloadControler {

	@GetMapping("/abc")
	public void filesdown(HttpServletResponse response) {
		try {
			String[] urls = { "http://127.0.0.1:10000/files/other/20180620162019.xls",
					"http://127.0.0.1:10000/files/other/测试系统-日常巡检输出结果-2017112208_2017112213.xls" };
			String filename = new String("xx.zip".getBytes("UTF-8"), "ISO8859-1");// 控制文件名编码
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ZipOutputStream zos = new ZipOutputStream(bos);
			UrlFilesToZip s = new UrlFilesToZip();
			int idx = 1;
			for (String oneFile : urls) {
				zos.putNextEntry(new ZipEntry("profile" + idx+".xls"));
				byte[] bytes = s.getImageFromURL(oneFile);
				zos.write(bytes, 0, bytes.length);
				zos.closeEntry();
				idx++;
			}
			zos.close();
			response.setContentType("application/force-download");// 设置强制下载不打开
			response.addHeader("Content-Disposition", "attachment;fileName=" + filename);// 设置文件名
			OutputStream os = response.getOutputStream();
			os.write(bos.toByteArray());
			os.close();
		} catch (FileNotFoundException ex) {
			// logger.error("FileNotFoundException", ex);
		} catch (Exception ex) {
			// logger.error("Exception", ex);
		}
	}
}
