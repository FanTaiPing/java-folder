package chapter3;

import java.util.Scanner;
/**
 * 成绩比较
 */
public class CompareScore {
	public static void main(String[] args) {
		boolean compare = true;
		while (compare) {
			Scanner input = new Scanner(System.in);
			System.out.println("张三的成绩为：");
			int ZsScore = input.nextInt();
			System.out.println("李四的成绩为：");
			int LsScore = input.nextInt();
			compare = ZsScore > LsScore;
			System.out.println("张三的成绩比李四高吗？" + compare);
		}
	}

}
