package chapter6;

import java.util.Scanner;

// Proportion
public class Proportion {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		System.out.print("请输入班级总人数：");
		int num = input.nextInt();
		int count = 0;
		for(int i=1;i<=num;i++) {
			System.out.print("请输入第" + i + "个学生的成绩：");
			double score = input.nextDouble();
			if(score < 80) {
				break;
			}else {
				count++;
			}
		}
		System.out.println("80分以上的学生人数为：" + count);
		System.out.print("80分以上的学生所占的比例为：" +((double)count/num)*100 +"%");
	}

}
