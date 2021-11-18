package object_2;

import java.util.Scanner;

public class TestStudentName {
	public static void main(String[] args) {
		Student student = new Student();
		Scanner input = new Scanner(System.in);
//		for (int i =0;i < 5;i++) {
//			System.out.print("请输入学生的姓名：");
//			String newName = input.next();
//			student.addName(newName);
//			if(student.searchName(start,end,name)) {
//				
//			}
//		}			
		
		System.out.print("请输入开始位置：");
		int start  =input.nextInt();
		System.out.print("请输入结束位置：");
		int end  =input.nextInt();
		System.out.print("请输入要查找的姓名：");
		String name  =input.next();
		if(student.searchName(start,end,name)) {
		System.out.println("找到了这个叫" + name + "名字的人");
		}else {
			System.out.println("没有找到叫" + name + "这个名字的人");
		}

		 student.showNames();
	}

}
