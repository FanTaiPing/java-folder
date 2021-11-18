package chapter8;

import java.util.Scanner;

/**
 * 直角三角形打印
 * 
 * @author HXZY
 *
 */
public class Triangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入直角三角形的行数：");
		int rows = input.nextInt();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		for (int i = 0; i < rows; i++) {

			for (int j = 2 * i - 1; j >= 0; j--) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		for (int i = rows; i >= 0; i--) {

			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}

}
