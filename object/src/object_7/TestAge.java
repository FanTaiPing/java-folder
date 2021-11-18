package object_7;

import java.util.Scanner;
/**
 * 年龄测试类
 * @author y
 */
public class TestAge {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Age age = new Age();
		try {
			System.out.print("请输入年龄：");
			int ages = input.nextInt();
			age.setAge(ages);
			System.out.print("输入的年龄为：" + age.getAge());
		} catch (Exception e) {
			e.printStackTrace();
//			System.err.print("");
		}
	}
}
