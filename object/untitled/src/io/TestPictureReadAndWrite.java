package io;
/**
 * 复制图片  图片top.bmp位于C盘根目录下，要求将此图片复制到D:\myDoc\myPicture.bmp
*/
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import io.utils.PathUtils;

public class TestPictureReadAndWrite {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = null;
		DataInputStream dis = null;
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			//构造数据输入流对象
			fis = new FileInputStream(PathUtils.picPath);
			dis = new DataInputStream(fis);
			
			fos = new FileOutputStream(PathUtils.picTwoPath);
			dos = new DataOutputStream(fos);

			int temp;
			//调用read（）方法读取二进制数据
			while ((temp = dis.read()) != -1) {
				dos.write(temp);
			}
			dos.flush();
			System.out.println("文件复制成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis.close();
			dis.close();
			fos.close();
			dos.close();
		}
	}
}
