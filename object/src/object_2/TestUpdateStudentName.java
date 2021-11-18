package object_2;

import java.util.Scanner;

/**
 * 修改学生姓名，输入新、旧姓名，进行修改并显示是否修改成功
 * @author HXZY
 *
 */
public class TestUpdateStudentName {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		UpdateStudentName upns = new UpdateStudentName();
		String oldName = null;
		for(int i =0;i<5;i++) {
			System.out.print("请输入客户姓名：");
			oldName = input.next();	
			upns.editName(oldName, null);
		}
		upns.showName();
		upns.updateName();		
	}
	

	


}
