package chapter3;

import java.util.Scanner;
/**
 * 成绩判断
 * @author HXZY
 *
 */
public class judgeScore {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你的考试成绩：");
		double score = input.nextDouble();
		if (score >= 80){
			System.out.print("成绩>= 80:良好！");
		}
		else if(score >= 60){
			System.out.print("成绩>= 60:中等！");
		}
		else if(score < 60){
			System.out.print("成绩< 60差！");
		}
	}

}
