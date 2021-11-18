package chapter5;

import java.util.Scanner;

/**
 * 学习任务
 * 
 * @author HXZY
 *
 */
public class Task {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("今天的学习任务合格了吗？");
		String answer = input.next();
		while (!"y".equals(answer)) {
			System.out.print("上午阅读教材，学习理论部分，下午上机编程，掌握代码部分");
			answer = input.next();
		}
		System.out.print("已经合格了！");
	}

}
