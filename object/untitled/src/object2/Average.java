package object2;

import java.util.Scanner;

/**
 * 从键盘接收三门课分数，计算三门课的平均分和总成绩，编写成绩计算类实现功能
 * 
 * @author HXZY
 *
 */

public class Average {
	double score1;
	double score2;
	double score3;
	double average;

	public void avg() {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入java的成绩：");
		score1 = input.nextDouble();
		System.out.print("请输入C#的成绩：");
		score2 = input.nextDouble();
		System.out.print("请输入DB的成绩：");
		score3 = input.nextDouble();

	}
	/*
	 * 平均分计算类
	 */
	public double calculation() {
		return average = (score1 + score2 + score3)/3;
		
	}
	public double showAvg() {
		return calculation();
		
	}
	
}
