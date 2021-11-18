package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import io.utils.PathUtils;

/**
 * 文件缓冲流配合读写流更改模板内容
 * 
 * @author y
 *
 */
public class TestBuffered {
	public static void main(String[] args) throws Exception {
		Reader re = null;
		BufferedReader br = null;
		Writer wr = null;
		BufferedWriter bw = null;
		StringBuffer sb = new StringBuffer();
		try {
			// 创建读取流对象读取
			re = new FileReader(PathUtils.namePath);
			// 读到的读取流对象添加到缓冲区读取流对象里
			br = new BufferedReader(re);

			// 循环读取并追加字符
			while (br.ready()) {
				sb.append(br.readLine());
			}
			System.out.println("替换前：" + sb);

			// 替换内容
			String str = sb.toString();
			str = str.replace("{name}", "欧欧").replace("{type}", "哈士奇").replace("{master}", "小姐姐");
			System.out.println("\n替换后：" + str);
			// 写入流对象
			wr = new FileWriter(PathUtils.nameOutPath);
			// 写入流对象添加到缓冲写入流对象里
			bw = new BufferedWriter(wr);
			// 写入文件
			bw.write(str);
			// 刷新缓冲区
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (re != null) {
				re.close();
			}
			if (br != null) {
				br.close();
			}
			if (wr != null) {
				wr.close();
			}
			if (bw != null) {
				bw.close();
			}
		}

	}
}
