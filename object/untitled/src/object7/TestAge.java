package object7;

import java.util.Scanner;

public class TestAge {
	public static void main(String[] args) throws AbnormalAgeException{
		Scanner input = new Scanner(System.in);
		Age age = new Age();
		try {
			System.out.print("请输入年龄：");
			int ages = input.nextInt();
			age.setAge(ages);
			System.out.print("输入的年龄为：" + age.getAge());
		} catch (AbnormalAgeException e) {
			e.printStackTrace();

		}
	}
}
