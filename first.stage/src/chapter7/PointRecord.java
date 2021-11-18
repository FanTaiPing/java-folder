package chapter7;

import java.util.Scanner;

public class PointRecord {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入会员本月的消费记录");
		double[] array = new double[5];
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			System.out.print("请输入第" + (i + 1) + "笔购物金额：");
			array[i] = input.nextDouble();
		}
		System.out.print("序号");
		System.out.println("\t金额(元)");
		for(int i = 0; i < array.length; i++) {
			System.out.print(i+1);
			System.out.println("\t"+array[i]);
			sum += array[i];
		}
	System.out.print("总金额 " + sum);
	}
}
