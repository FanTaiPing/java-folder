package io;
import java.io.FileReader;
import java.io.Reader;
import io.utils.PathUtils;
/**
 * 文件读写流读文件信息
 * 
 * @author y
 *
 */
public class TestFileReader {
	public static void main(String[] args) throws Exception {
		// 创建文件读写流对象
		Reader re = null;
		StringBuffer sb = null;
		try {
        //创建文件读取流对象
			re = new FileReader(PathUtils.namePath);
			// 创建字符数组作为中转站
			char[] ch = new char[1024];
			sb = new StringBuffer();
			// 将字符读入数组
			int length = re.read(ch);
			while (length != -1) {
				// 把ch里的字符数组追加到sb对象里
				sb.append(ch);
				// 读取到最后会返回-1
				length = re.read();
			}
			// 控制台输出读取到的内容
			System.out.println(sb);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (re != null) {
				re.close();
			}
		}
	}
}
