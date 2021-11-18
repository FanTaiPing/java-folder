package object7;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 课程名称异常处理
 * 
 * @author y
 *
 */
public class Course {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("请输入课程代码(1-3之间的数字)：");
			int num = input.nextInt();
			switch (num) {
			case 1:
				System.out.println("Java课程");
				break;
			case 2:
				System.out.println("Html+Css课程");
				break;
			case 3:
				System.out.println("JavaScript课程");
				break;
			default:
				//throw 抛出异常
				throw new RuntimeException(new InputMismatchException());
			}
		} catch (Exception e) {
			System.err.println("请输入正确的数字！");
		} finally {
			System.out.println("欢迎提出建议！");
		}

	}
}
