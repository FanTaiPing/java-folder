package chapter7;

import java.util.Scanner;

public class ArrayWhile {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] array = { 8, 4, 2, 1, 23, 344, 12 };
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
			sum += array[i];
		}
		System.out.println("数列中所有数值的和为：" + sum);
		boolean flag = true;
		System.out.print("请输入任意一个数字：");
		int anyNumber = input.nextInt();
		for (int i = 0; i < array.length; i++) {

			if (array[i] == anyNumber) {

				System.out.println("恭喜你中奖了！");
				//
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("没有找到这个数字！");
		}
	}
}
