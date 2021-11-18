package io;
/**
 * 文件读写流文件信息的写入
 */
import java.io.FileWriter;
import java.io.Writer;
import io.utils.PathUtils;
public class TestFileWriter {
	public static void main(String[] args) throws Exception {
		Writer wr = null;
		try {
			// 创建文件写入流对象
			wr = new FileWriter(PathUtils.nameOutPath);
			// 写入信息
			wr.write("这是我写入的文件信息");
			// 刷新缓冲区
			wr.flush();
			System.out.println("写入文件内容成功！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wr != null) {
				wr.close();
			}
		}
	}
}
