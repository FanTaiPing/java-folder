package chapter6;

import java.util.Scanner;

/**
 * 倒三角打印
 * 
 * @author HXZY
 *
 */
public class InvertedTriangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入倒三角形的行数：");
		int rows = input.nextInt();
		for (int i = rows; i >= 0; i--) {

			for (int j = 0; j < i ; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}
}
