package io;
import java.io.File;
/**
 * 自定义文件操作类
 * 
 * @author y
 *
 */
public class CustomFile {
	/**
	 * 创建一个新的空的文件
	 * 
	 * @param file
	 */
	public void createrFile(File file) {
		// 如果文件不存在
		if (!file.exists()) {
			try {
				// 创建一个新的空的文件
				file.createNewFile();
				System.out.println("文件创建成功");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param file
	 */
	public void deleteFile(File file) {
//如果文件存在
		if (file.exists()) {
			file.delete();
			System.out.println("文件删除成功！");
		}
	}

	/**
	 * 查看文件属性
	 * 
	 * @param file
	 */
	public void showFile(File file) {
		if (file.exists()) {
			try {
				System.out.println("是一个文件吗？" + file.isFile());
				System.out.println("是一个目录吗？" + file.isDirectory());
				System.out.println("绝对路径是" + file.getAbsolutePath());
				System.out.println("相对路径是" + file.getPath());
				System.out.println("文件长度是" + file.length());
			} catch (Exception e) {
				System.err.println("文件找不到！");
			}
		}
	}
}
