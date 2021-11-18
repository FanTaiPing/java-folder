package chapter5;

import java.util.Scanner;

public class MyShopingWhile {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("MyShopping管理系统 > 客户信息管理 > 添加客户信息");
		
		boolean flag = true;
		while(flag) {
			System.out.print("请输入会员号(<4位整数)：");
			int pointNum = input.nextInt();
			if (pointNum <1000 || pointNum >=10000) {
				System.out.println("输入的会员号不正确(<4位整数)，请重新输入");
			continue;
		}
			System.out.print("请输入会员生日(月/日<2位整数表示)：");
			String pointBirthday = input.next();
			System.out.print("请输入会员积分：");
			int pointIngetra = input.nextInt();
			System.out.println("您录入的会员信息是：" + pointNum + "\t" + pointBirthday + "\t" + pointIngetra);
			
			System.out.println("");
		}
		
	}

}
