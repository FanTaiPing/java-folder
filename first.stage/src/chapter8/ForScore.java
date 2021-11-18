package chapter8;

import java.util.Scanner;

public class ForScore {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double score;
		double totalScore = 0;
		double average;
		System.out.print("请输入学生姓名：");
		String name = input.next();
		
		for(int i=1;i<=5;i++) {
			
			System.out.print("请输入5门功课中的第"+ i + "门课的成绩：");
			score = input.nextDouble();
			totalScore += score;
		}
		average = totalScore / 5;
		System.out.print(name +"的平均分是" + average);
	}

}
