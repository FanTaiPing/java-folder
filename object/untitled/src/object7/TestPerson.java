package object7;

import java.util.Scanner;

public class TestPerson {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	Person person = new Person();
	System.out.print("请输入性别：");
	String sex = input.next();
	try {
	person.setSex(sex);	
			
		} catch (Exception e) {
			e.printStackTrace();
//			System.err.println("输入有误！请输入男/女");
	} finally {
		System.out.println("欢迎提出建议！");
	}
			
	
}
}
