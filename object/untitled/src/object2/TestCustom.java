package object2;

import java.util.Scanner;

/**
 * 测试对象数组
 * 
 * @author HXZY
 *
 */
public class TestCustom {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 创建客户对象类
//		UpdateCustomInfo customer = new UpdateCustomInfo();
//		String judge = "y";
//		int n =1;
//		while ("y".equals(judge)) {
//			System.out.println("请输入第"+ n +"个客户姓名：");
//			customer.name = input.next();// 客户姓名
//			System.out.println("请输入第"+ n +"个客户年龄：");
//			customer.age = input.nextInt();// 客户年龄
//			System.out.println("请输入第"+ n +"个客户是否有会员卡：");
//			customer.idCard = input.nextBoolean();// 客户是否有会员卡
//			//创建学生业务类对象
//			CustomBiz up = new CustomBiz();
//			//接收语句,给每一个学生类对象属性赋值并调用业务类方法存入对象数组
//			up.addCustom(customer);
//			System.out.print("继续添加客户的信息吗？（y/n）:");
//			judge = input.next();
//			n++;
//			
//		}
//		
//		//创建学生业务类对象
//		CustomBiz up1 = new CustomBiz();
////		//接收语句,给每一个学生类对象属性赋值并调用业务类方法存入对象数组
////		up.addCustom(customer);
//		System.out.println("客户信息：");
//		for(int i =0;i<(up1.custInfo).length;i++) {
//			if(up1.custInfo[i] != null) {
//			up1.custInfo[i].showCustomInfo();	
//			}
//			
//		}
		//创建两个学生类对象
		UpdateCustomInfo wangCust = new UpdateCustomInfo();
		wangCust.name = "王一";
		wangCust.age = 30;
		wangCust.idCard = false;
		
		UpdateCustomInfo haoCust = new UpdateCustomInfo();
		haoCust.name = "郝强";
		haoCust.age = 19;
		haoCust.idCard = true;
		//创建学生业务类对象
		CustomBiz up = new CustomBiz();
		//接收语句,给每一个学生类对象属性赋值并调用业务类方法存入对象数组
		up.addCustom(wangCust);
		up.addCustom(haoCust);
		System.out.println("客户信息：");
		up.custInfo[0].showCustomInfo();
		up.custInfo[1].showCustomInfo();
	}

}
