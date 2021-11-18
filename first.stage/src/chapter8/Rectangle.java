package chapter8;

import java.util.Scanner;

/**
 * 矩形
 * 
 * @author HXZY
 *
 */
public class Rectangle {
	public static void main(String[] args) {
		System.out.print("打印矩形：");
		for (int i = 0; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}
}
