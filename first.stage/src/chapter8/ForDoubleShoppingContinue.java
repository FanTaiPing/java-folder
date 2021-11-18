package chapter8;

import java.util.Scanner;

public class ForDoubleShoppingContinue {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			int count = 0;
			System.out.println("请输入" + (i + 1) + "个人所购的三件商品的价格：");
			for (int j = 0; j < 3; j++) {
				double price = input.nextDouble();
				if(price <= 300 && price >=0) {
					continue;
				}
				count++;
			}
			System.out.println("第" + (i + 1) + "个人共有" + count + "件商品享受8折优惠！");
		}

	}
}
