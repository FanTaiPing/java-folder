package chapter6;

import java.util.Scanner;

public class additionTable {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sum =0;
		System.out.print("请输入一个值：");
		int j = input.nextInt();
		System.out.println("根据这个值可以输出以下加法表：");
		for(int i=0;i<=j;i++) {
			sum = i+j;
			System.out.println(i + "" + "+" + "" + j + "=" + "" + sum );	
		}
		j--;
		
	}

}
