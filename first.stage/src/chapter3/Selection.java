package chapter3;

import java.util.Scanner;

/*
 * 选择结构  登录
 */
public class Selection {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String root = "ftp";
		String passward = "123456";
		System.out.println("欢迎使用我行我素购物管理系统！");
		System.out.println("1.登录系统");
		System.out.println("2.退出");
		System.out.println("*********************************");
		System.out.print("请选择您想要使用的功能序号：");
		int num = input.nextInt();
		switch (num) {
		case 1:
			System.out.println("1.登录系统");
			System.out.println("请输入您的登录账号：");
			String root1 = input.next();
			boolean repect = true;
			while (repect) {
				if (root1.equals(root)) {
					System.out.print("请输入你的登录密码：");
					String passward1 = input.next();
					if (passward1.equals(passward)) {
						System.out.println("登陆成功！");
						System.out.println("*******************");
						System.out.println("1.客户信息管理");
						System.out.println("2.购物结算");
						System.out.println("3.真情回馈");
						System.out.println("4.注销");
						System.out.println("*******************");
						System.out.println("请输入你要登录的主菜单:");
						int num1 = input.nextInt();
						switch (num1) {
						case 1:
							System.out.println("1.客户信息管理");
							System.out.println("*******************");
							System.out.println("购物管理系统>客户信息管理");
							System.out.println("1.显示所有客户信息");
							System.out.println("2.添加客户信息");
							System.out.println("3.修改客户信息");
							System.out.println("4.查询客户信息");
							System.out.println("*******************");
							System.out.print("请选择输入你要使用的功能:");
							int num2 = input.nextInt();
							switch (num2) {
							case 1:
								System.out.println("1.显示所有客户信息");
								
								break;
							case 2:
								System.out.println("2.添加客户信息");
								
								break;
							case 3:
								System.out.println("3.修改客户信息");
								break;
							case 4:
								System.out.println("4.查询客户信息");
								break;
							default:
								System.out.print("输入有误！");
								break;
							}
							break;
						case 2:
							System.out.println("2.购物结算");
							break;
						case 3:
							System.out.println("3.真情回馈");
							break;
						case 4:
							System.out.println("4.注销");
							break;
						default:
							System.out.print("输入有误！");
							break;
						}
						repect = false;
						break;
					} else {
						System.out.println("密码错误，请重新输入:");
						repect = true;
					}
					// System.out.println("登陆成功！");
				} else {
					System.out.println("用户名错误，请重新输入:");
					repect = true;
				}
			
			break;
			}
		case 2:
			System.out.println("2.退出");
			//强制停止JMV
			System.exit(0);
			break;
		default:
			System.out.print("输入有误！");
			break;
			
		}
			
	}
		

}
