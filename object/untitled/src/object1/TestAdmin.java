package object1;

import java.util.Scanner;

public class TestAdmin {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//创建两个管理员对象
		Admin admin1 = new Admin();
		Admin admin2 = new Admin();
		
		System.out.print("请输入第一个初始化用户名：");
		admin1.name = input.next();
		System.out.print("请输入第一个初始化密码：");
		admin1.password = input.next();
		
		System.out.print("请输入第二个初始化用户名：");
		admin2.name = input.next();
		System.out.print("请输入第二个初始化密码：");
		admin2.password = input.next();
//		admin1.name = "admin1";
//		admin1.password = "123456";
//		
//		admin2.name = "admin2";
//		admin2.password = "111111";
		
		admin1.showAdmin();
		admin2.showAdmin();
	}

}
