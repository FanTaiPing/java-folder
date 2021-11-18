package object7;

import java.util.Scanner;

public class TestThree {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		try {
			System.out.print("请输入被除数：");
			int numOne = input.nextInt();
			System.out.print("请输入除数：");
			int numTwo = input.nextInt();
			System.out.println(String.format("%d / %d = %d", numOne, numTwo, numOne / numTwo));
			System.out.println("感谢使用本程序！");
		} catch (Exception e) {
//			e.printStackTrace();
			return;
		} finally {
			System.exit(0);
			System.out.println("正常情况下，我这个finally都执行，除非遇到System.exit(1)才不会执行");

		}
	}
}
