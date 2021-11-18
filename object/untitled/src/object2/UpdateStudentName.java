package object2;

import java.util.Scanner;

public class UpdateStudentName {
	Scanner input = new Scanner(System.in);
	String names[] = new String[5];

	
	/*
	 * 添加客户姓名
	 */
	public void editName(String oldName, String newName) {
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				names[i] = oldName;
				break;
			}
		}
		

	}
	
	/**
	 * 显示客户姓名
	 */
	public void showName() {
		System.out.println("客户姓名列表：");	
		System.out.println("******************************");
		for (int i= 0;i<names.length;i++) {
			System.out.print(names[i] + "\t");
		}
	}
/*
 * 修改客户姓名
 */
	public void updateName() {
		System.out.print("\n请输入要修改的客户的姓名：");		
		String oldName =input.next();
		for (int i = 0;i<names.length;i++) {
			if(oldName.equals(names[i])) {
				System.out.print("请输入新的客户姓名：");		
				String newName =input.next();
				names[i] = newName;
				System.out.println(" ");
				System.out.println("*******修改结果*******");
				System.out.println("找到并修改成功！");
				System.out.println("*******************************");				
				break;
			}		
		}
		showName();
	}
	
	
}
