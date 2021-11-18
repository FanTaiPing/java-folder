package object2;

import java.util.Scanner;

public class CustomerBiz {
	Scanner input = new Scanner(System.in);
	String names[] = new String[20];

	/*
	 * 添加客户信息方法
	 */
	public void addNames(String name) {
		for (int i = 0; i < names.length - 1; i++) {
			if (names[i] == null) {
				names[i] = name;
				break;
			}
			
		}

	}

	/*
	 * 打印输入的学生姓名
	 */
	public void showNames() {
		System.out.println("\t\t客户姓名列表：");
		System.out.println(" ");
		System.out.println("******************************");
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null) {
				System.out.print(names[i] + "\t");
			}

		}
	}
}
