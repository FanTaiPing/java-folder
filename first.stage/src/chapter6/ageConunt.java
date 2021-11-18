package chapter6;

import java.util.Scanner;

public class ageConunt {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double count = 0;
		double count1 = 0;
		for (int i = 1; i <= 10; i++) {
			System.out.print("请输入第" + i + "位顾客的年龄：");
			int age = input.nextInt();
			if (age <=30) {
				count++;
			} else {
				count1++;
			}
//			System.out.println(count);
//			System.out.println(count1);
		}
		double percentage1 = count / 10;
		double percentage2 = count1 / 10;
		System.out.println("30岁以下的比例是：" + (percentage1*100) + "%");
		System.out.print("30岁以上下的比例是：" + (percentage2)*100 + "%");

	}

}
