package chapter3;

import java.util.Scanner;
/**
 * && || ！ 的判断用法
 * @author HXZY
 *
 */
//逻辑运算
public class Logic {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("请输入张浩的java成绩：" );
	int javaScore = input.nextInt();
	System.out.println("请输入张浩的音乐成绩：");
	int musicScore = input.nextInt();
	if ((javaScore > 98 && musicScore > 80) && (javaScore == 100 && musicScore >70)) {
		System.out.println("奖励一个鸡腿！");
	}
	else {
		System.out.println("奖励一个大嘴巴子！");
	}
}
}