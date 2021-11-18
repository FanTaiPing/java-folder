package str;

import java.util.Scanner;

/**
 * 作业提交系统
 * 
 * @author y
 *
 */
public class TestIndexOf {

	/**
	 * 检查文件名
	 * 
	 * @param name
	 * @return
	 */
	public boolean checkFileName(String fileName) {
		// 等于-1，证明没找到字符串里包含.java
		if (fileName.indexOf(".java") != -1) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * 检查Email
	 * 
	 * @param args
	 */
	public boolean checkEmail(String email) {
		// 判断是否包含@和.符号
		if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {
			return false;
		}
		// 判断@符号是否在.之前
		if (email.indexOf("@") >= email.indexOf(".")) {
			return false;
		}
		return true;
	}



	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TestIndexOf ti = new TestIndexOf();
		System.out.println("欢迎进入作业提交系统！");
		System.out.print("请输入你的java文件名：");
		String fileName = input.next();
		System.out.print("请输入你的邮箱：");
		String email = input.next();
		if (!ti.checkFileName(fileName)) {
			System.out.println("文件名无效！");
			System.out.println("作业提交失败！");
			return;
		}
		if (!ti.checkEmail(email)) {
			System.out.println("Email无效！");
			System.out.println("作业提交失败！");
			return;
		}
		System.out.println("作业提交成功！");
	}
}
