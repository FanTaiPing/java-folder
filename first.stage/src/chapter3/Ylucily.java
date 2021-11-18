package chapter3;

import java.util.Scanner;
/**
 * 双重if的使用方法
 * @author HXZY
 *
 */
public class Ylucily {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int repect = 0;
		while (repect < 3) {
			System.out.println("请输入是否是会员：是(y) / 否(其它字符)");
			String correct = input.next();
			if (correct.equals("y")) {
				System.out.println("请输入购物金额：");
				double money = input.nextDouble();
				if (money >= 200) {
					System.out.println(money * 0.75);
				} else {
					System.out.println(money * 0.8);
				}
			} else {
				System.out.println("请输入购金额：");
				double money = input.nextDouble();
				System.out.println(money * 0.9);
			}
			repect++;
		}
	}

}
