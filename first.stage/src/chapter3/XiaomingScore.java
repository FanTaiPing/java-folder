package chapter3;

import java.util.Scanner;

public class XiaomingScore {
	public static void main(String[] args) {
		Scanner input = new  Scanner(System.in);
		int i = 0;
		while(i <= 4) {
		System.out.println("请输入学生的考试成绩：");
		double score = input.nextDouble();
		if (score == 100){
			System.out.println("成绩==100分，爸爸给他买辆车");
		}else if(score >= 90 && score < 100){
			System.out.println("100分>成绩>=90分，妈妈给他买MP4");
		}else if (score >= 60 && score < 90) {
			System.out.println("90分>成绩>=60分,妈妈给他买本参考书");
		}else if(score < 60 && score >= 0){
			System.out.println("成绩<60分,什么都不买");
		}
		i++;
		}
	}

}
