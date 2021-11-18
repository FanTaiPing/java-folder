package chapter3;

import java.util.Scanner;
/**
 * 会员折扣判定
 * @author HXZY
 *
 */
public class Point {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i = 0;
		while (i < 4) {
			double discount;		
			System.out.println("请输入会员积分：");
			int point = input.nextInt();
			if (point < 2000) {
				discount = 0.9;
				System.out.println("该会员享受的折扣是" + discount);
			} else if (point >= 2000 && point < 4000) {
				discount = 0.8;
				System.out.println("该会员享受的折扣是：" + discount);
			} else if (point >= 4000 && point < 8000) {
				discount = 0.7;
				System.out.println("该会员享受的折扣是：" + discount);
			} else if (point >= 8000) {
				discount = 0.6;
				System.out.println("该会员享受的折扣是：" + discount);
			}
			i++;
		}
	}

}
