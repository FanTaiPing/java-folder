package object7;

import java.util.Scanner;

public class TestOne {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numOne = 1;
		System.out.print("请输入被除数:");
		// 判断接受的是否是整型数字
		if (input.hasNextInt()) {
			numOne = input.nextInt();
		}

		System.out.print("请输入除数:");
		int numTwo = 1;
		// 是整形数字时接收
		if (input.hasNextInt()) {
			numTwo = input.nextInt();
		}
        //除数为零时
		if (numTwo == 0) {
			System.out.println("除数不能为零！！");
			return;
		}
		System.out.println(String.format("%d / %d = %d", numOne, numTwo, numOne / numTwo));
		System.out.println("感谢使用本程序！");
	}
}
