package object1;

import java.util.Scanner;

public class Root {
	/*
	 * 定义类的属性
	 */
//	String root = "ftp";// 用户名
//	String passward = "123456";// 密码
	String root; 
	String passward;

	/*
	 * 定义类的方法
	 */
	public void showInfo() {
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.print("请输入用户名:");
			String inputRoot = input.next();
			System.out.print("请输入密码:");
			String inputPassward = input.next();
			if (!inputRoot.equals(root) || !inputPassward.equals(passward)) {
				System.out.println("用户名和密码不匹配！您没有权限更新管理员信息");
			}else{
				System.out.print("请输入新密码:");
				String newPassward = input.next();
				passward = newPassward;
				System.out.println("修改密码成功，您的新密码为：" + passward);
				break;
			}
			

		}
	}

}
