package object1;

import java.util.Scanner;

public class TestRoot {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//创建一个对象
		Root root = new Root();
		System.out.print("请输初始化用户名：");
		root.root = input.next();
		System.out.print("请输入初始化密码：");
		root.passward = input.next();
		root.showInfo();
	}

}
