package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import io.utils.PathUtils;

/**
 * 复制文件
 * 
 * @author y
 *
 */
public class TestFileStream {
	public static void main(String[] args) throws Exception {
		// 1.创建输入流对象，负责读取D:\study\object\src\io\test\java.txt
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			//读取文件位置
			fis = new FileInputStream(PathUtils.namePath);
			//写复制后的位置
			fos = new FileOutputStream(PathUtils.nameOutPath);
			//创建中转站数组，存放每次读取的内容
			byte[] words = new byte[1024];
			// 通过循环实现文件读写（-1表示读取到了文件内容的末尾）
			while (fis.read() != -1) {
				// 读取字节并暂存放到words
				fis.read(words);
				// 写入文件
				fos.write(words, 0, words.length);
			}

			System.out.println("复制文件成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 文件输入流对象不为空，关闭
			if (fis != null) {
				fis.close();
			}
			// 文件输出流对象不为空，关闭
			if (fos != null) {
				fos.close();
			}
		}
	}
}
