package chapter7;

import java.util.Scanner;

public class MaxMin {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in); 
	int score[] = new int[5];
	int max = score[0];	
	System.out.println("请输入5位同学的成绩：");
	for(int i =0;i<score.length;i++) {
		score[i] = input.nextInt();
		if(score[i]>max) {
			max = score[i];
		}
	}
	System.out.println("输入的5位同学成绩的最大值是：" + max);
	int min = score[0];
	System.out.println("请输入5位同学的成绩：");
	for(int i =0;i<score.length;i++) {
		score[i] = input.nextInt();
		if(score[i]<min) {
			min = score[i];
		}
	}
	System.out.println("输入的5位同学成绩的最小值是：" + min);
}
}
