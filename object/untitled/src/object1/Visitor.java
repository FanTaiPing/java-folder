package object1;

import java.util.Scanner;

public class Visitor {
	String name;
	int age;

	/**
	 * 买票方法
	 */
	public void buyTicket() {
		Scanner input = new Scanner(System.in);
		while (!"n".equals(name)) {
			System.out.print("请输入姓名：");
			name = input.next();
			// 如果等于n退出循环
			if ("n".equals(name)) {
				System.out.print("退出程序！");
				break;
			}
			System.out.print("请输入年龄：");
			age = input.nextInt();
			// 判断年龄买票
			if (age >= 18 && age < 59) {
				System.out.println(name + "的年龄为：" + age + ",门票价格为：20元");
			} else {
				System.out.println(name + "的年龄为：" + age + ",门票免费！");
			}
		}

	}

}
