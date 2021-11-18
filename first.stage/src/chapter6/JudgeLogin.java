package chapter6;

import java.util.Scanner;

public class JudgeLogin {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String root = "ftp";
		String passward = "123456";
		for (int i = 1; i <= 3; i++) {
			System.out.print("请输入用户名：");
			String newRoot = input.next();
			System.out.print("请输入登录密码：");
			String newPassward = input.next();
			if (!newRoot.equals(root) || !passward.equals(newPassward)) {
				System.out.println("输入用户名错误，您还有" + (3 - i) + "次输入机会，请重新输入：");
				continue;
			}
			System.out.println("欢迎登录MyShopping系统！");
			break;
		}

	}

}
