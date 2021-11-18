package chapter8;

import java.util.Scanner;

public class ForScoreContinue {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = 0;
		double average;
		for (int j = 0; j < 3; j++) {
			double sum = 0;
			System.out.println("请输入第" + (j + 1) + "个班的成绩");
			for (int i = 0; i < 4; i++) {
				System.out.print("第" + (i + 1) + "个学员的成绩：");
				int score = input.nextInt();
				sum += score;
				if (score <= 85) {
					continue;
				} else {
					count++;
				}
			}

			average = sum / 4;
			System.out.println("第" + (j + 1) + "个班级参赛学员的平均分是：" + average);
		}
		System.out.println("成绩在85分以上的学员人数有" + count + "人");
	}
}
