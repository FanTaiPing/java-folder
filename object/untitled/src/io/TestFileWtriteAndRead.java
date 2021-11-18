package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

import io.utils.PathUtils;

/**
 * 文件的写和读
 * 
 * @author y
 *
 */
public class TestFileWtriteAndRead {

	public static void write() throws Exception {
		Writer wr = null;

		try {
			// 创建文件写入流对象
			wr = new FileWriter(PathUtils.nameOutPath);

			// 写入信息
			wr.write("您好,我的名字是{name},我是一只{type},我的主人是{master}");

			// 刷新缓冲区
			wr.flush();

			System.out.println("写入文件成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wr != null) {
				wr.close();
			}
		}
	}

	public static void read() throws Exception {
		Reader re = null;
		StringBuffer sb = null;
		try {

			re = new FileReader(PathUtils.nameOutPath);

			// 创建字符数组作为中转站
			char[] str = new char[1024];
			sb = new StringBuffer();
			// 将字符读入字符数组
			int length = re.read(str);
			while (length != -1) {
				// 将str里的字符数组追加到sb对象里面
				sb.append(str);
				// 读取到最后会返回-1
				length = re.read();
			}
			System.out.println(sb);
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			if (re != null) {
				re.close();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		write();
		read();
	}
}
