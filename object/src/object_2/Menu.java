package object_2;

import java.util.Scanner;

/**
 * 实现MyShopping菜单，输入菜单项编号，可以自由切换各个菜
 * 
 * @author HXZY
 *
 */
public class Menu {
	Scanner input = new Scanner(System.in);
	String root;
	String password;
	int num;
	/*
	 * 登录功能
	 */
	public void login() {
		System.out.println("欢迎使用我行我素购物管理系统");
		System.out.println("1.登录系统");
		System.out.println("2.退出");
		System.out.print("请选择，输入数字：");
		num = input.nextInt();
		switch (num) {
		case 1:
			System.out.print("请输入初始用户名：");
			root = input.next();
			System.out.print("请输入初始密码：");
			password = input.next();
			while (true) {

				System.out.print("请输入用户名：");
				String root1 = input.next();
				System.out.print("请输入密码：");
				String password1 = input.next();

				if (root1.equals(root) && password1.equals(password)) {
					System.out.println("登录成功！");
					showMainMenu();// 调用主菜单方法

					break;

				} else {
					System.out.println("用户名或密码输入错误，请重新输入：");
				}
			}

			break;
		case 2:
			System.out.println("您的输入有误，系统已结束运行！");
			exit();
			break;
		default:
			System.out.println("您的输入有误，系统已结束运行！");
			break;
		}

	}

	/*
	 * 退出功能
	 */
	public void exit() {
		System.exit(0);
	}

	/**
	 * 主菜单显示
	 */
	public void showMainMenu() {
		System.out.println("欢迎使用我行我素购物管理系统主菜单");
		System.out.println("*******************************");
		System.out.println("1.客户信息管理");
		System.out.println("2.真情回馈");
		System.out.println(" ");
		System.out.print("请选择，输入数字或按0返回上一级菜单：");
		num = input.nextInt();
		if (num == 0) {
			login();
		} else {
			switch (num) {
			case 1:
				customerManage();	//调用客户信息管理方法			
				break;
			case 2:
				feelingsBack();// 调用真情回馈方法
				break;
			default:
				System.out.println("您的输入有误，系统已结束运行！");
				break;

			}
		}

	}

	/*
	 * 客户信息管理
	 */
	public void customerManage() {

		System.out.println("1.客户信息管理");
		System.out.print("请选择，输入数字或按0返回上一级菜单：");
		num = input.nextInt();
		if(num == 0) {
			showMainMenu();
		}else {
			System.out.println("您的输入有误，系统已结束运行！");
		}
		
	}

	/*
	 * 真情回馈
	 */
	public void feelingsBack() {
		System.out.println("我行我素购物管理系统> 真情回馈");
		System.out.println("*******************************");
		System.out.println("1.幸运大放送");
		System.out.println(" ");
		System.out.println("2.幸运抽奖");
		System.out.println(" ");
		System.out.println("3.生日问候");
		System.out.println(" ");
		System.out.println("********************************");

		System.out.print("请选择，输入数字或按0返回上一级菜单：");
		int num = input.nextInt();
		if (num == 0) {
			showMainMenu();
		} else {

			switch (num) {
			case 1:
				System.out.println("1.幸运大放送");
				System.out.println(" ");
				System.out.print("请选择，输入数字或按0返回上一级菜单：");
				num = input.nextInt();
				if(num == 0) {
				feelingsBack();	
				}else {
					System.out.println("您的输入有误，系统已结束运行！");
				}
				
				break;
			case 2:
				System.out.println("2.幸运抽奖");
				System.out.println(" ");
				System.out.print("请选择，输入数字或按0返回上一级菜单：");
				num = input.nextInt();
				if(num == 0) {
				feelingsBack();	
				}else {
					System.out.println("您的输入有误，系统已结束运行！");
				}
				break;
			case 3:
				System.out.println("3.生日问候");
				System.out.println(" ");
				System.out.print("请选择，输入数字或按0返回上一级菜单：");
				num = input.nextInt();
				if(num == 0) {
				feelingsBack();	
				}else {
					System.out.println("您的输入有误，系统已结束运行！");
				}
				break;
			default:
				System.out.println("您的输入有误，系统已结束运行！");
				break;
			}
		}
	}
}
