package chapter3;

import java.util.Scanner;
/**
 * if else 判断用法
 * @author HXZY
 *
 */
//judge 判断
public class Judge {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入张浩的java成绩:");
		//从控制台获取张的java成绩
		int javaScore = input.nextInt();
		if (javaScore > 90) {
			System.out.println("老师说：不错，奖励一个MP4！");
		} else {
			System.out.println("老师说：分数太滴，奖励一个大嘴巴子！");
		}
	}
}
