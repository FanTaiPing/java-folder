package chapter8;

import java.util.Scanner;

/**
 * 等腰三角打印
 * 
 * @author HXZY
 *
 */
public class IsoscelesTriangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入等腰三角形的行数：");
		int rows = input.nextInt();
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= rows - i; j++) {
				System.out.print("#");

			}
			for (int a = 1; a <= 2 * i - 1; a++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}
}
