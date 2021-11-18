package chapter2;

import java.util.Scanner;

public class Score {
	public static void main(String[] args) {
		// 控制台接收语句
		Scanner input = new Scanner(System.in);
		System.out.print("请输入java考试课程的成绩：");
		int java = input.nextInt();
		System.out.print("请输入sql考试的分数：");
		int sql = input.nextInt();
		System.out.print("请输入html考試的分數：");
		int html = input.nextInt();
		double average = (java + sql + html)/3;
		System.out.println("三门考试成绩的平均分为：" +average);
		System.out.print("java课程和sql分数之差为："+(java - sql));
	} 
}
