package chapter7;

import java.util.Scanner;

/**
 * 用数组计算学生成绩的平均分 
 * @author HXZY
 *
 */
public class AyyayScoreAverage {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] score = new double[5];
//		int[] score1 = {50,61,30,61,23};
		double average;
		double sum=0;
		for (int i =0;i<score.length;i++) {
			System.out.print("请输入第"+ (i+1) +"个学生的成绩：");
			score[i] = input.nextDouble();
			sum += score[i];
		}
		average = sum/score.length;
		System.out.print("全班学员的平均分为：" + average);
	}

}
