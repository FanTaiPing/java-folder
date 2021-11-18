package chapter3;

import java.util.Scanner;
/**
 * 100米赛跑
 * @author HXZY
 *
 */
public class Run100 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入学生百米赛跑的成绩：");
		double score = input.nextDouble();
		//成绩小于10s
		if (score <= 10) {
			System.out.println("请输入学生百米赛跑的性别：");
			String sex = input.next();
			if (sex.equals("男")) {
				System.out.println("恭喜您已进入男子组决赛！");
			} else if (sex.equals("女")) {
				System.out.println("恭喜您已进入女子组决赛！");
			}

		} else {
			System.out.println("抱歉！您未进入决赛，请下次继续努力！");
		}
	}

}
