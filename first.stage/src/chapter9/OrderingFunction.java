package chapter9;

import java.util.InputMismatchException;
/**
 * 菜单功能
 */
import java.util.Scanner;

public class OrderingFunction {
	Scanner input = new Scanner(System.in);
	OrderingAttribute order = new OrderingAttribute();

	/**
	 * 初始化信息方法
	 */
	public void initial() {
		// 1.菜品信息
		// 2.给2条订单信息一个初始值
		order.names[0] = "张晴";
		order.dishMegs[0] = "红烧带鱼2份";
		order.times[0] = 3;
		order.address[0] = "天成路207号";
		order.sumPrices[0] = 76.0;
		order.states[0] = 1;

		order.names[1] = "张晴";
		order.dishMegs[1] = "鱼香肉丝2份";
		order.times[1] = 10;
		order.address[1] = "天成路207号";
		order.sumPrices[1] = 45.0;
		order.states[1] = 0;
	}

	// 1.我要订餐
	public void add() throws Exception {

		System.out.println("****我要订餐****");
		System.out.print("请输入订餐人姓名:");
		String name = input.next();
		// 1.展示菜品信息
		System.out.println("序号\t" + "菜名\t" + "单价\t" + "点赞数\t");
		System.out.println("1\t红烧带鱼\t38.3\t0");
		System.out.println("2\t鱼香肉丝\t20.0\t0");
		System.out.println("3\t时令鲜蔬\t10.0\t0");
		try {
			System.out.print("请输入您要点的菜品编号:");
			int num = input.nextInt();
			System.out.print("请选择您需要的份数:");
			int count = input.nextInt();
			System.out.print("请输入送餐时间(送餐时间是10点-20点期间的整点送餐):");
			int time = input.nextInt();
			System.out.print("请输入送餐地址:");
			String address = input.next();
			System.out.println("订餐成功!!!");
			// 2.保存订单信息
			// a.找到数组中的空位
			int index = 0;// 保存找到的空位的下标
			for (int i = 0; i < order.names.length; i++) {
				if (order.names[i] == null) {
					// 找到空位的下标
					index = i;
					break;
				}
			}
			// b.存储信息
			order.names[index] = name;
			// 根据菜品编号得出菜品名称
			String dishName = "";
			Double price = 0.0;
			switch (num) {
			case 1:
				price = 38.0 * count;
				dishName = "红烧带鱼";
				break;
			case 2:
				price = 20.0 * count;
				dishName = "鱼香肉丝";
				break;
			case 3:
				price = 10.0 * count;
				dishName = "时令鲜蔬";
				break;
			default:
				System.out.println("您输入的操作有误，！！");
				break;
			}
			order.dishMegs[index] = dishName + count + "份";
			order.times[index] = time;
			order.address[index] = address;
			order.sumPrices[index] = price;
			if (price < 50) {
				order.sumPrices[index] = price + 5.0;
			} else {
				order.sumPrices[index] = price;
			} /*
				 * order.states[index]=1;
				 */

			// 3.显示订餐信息
			System.out.println("您订的是" + order.dishMegs[index]);
			System.out.println("送餐时间:" + order.times[index]);
			System.out.println("餐费:" + price + "元，送餐费:" + (price >= 50.0 ? 0 : 5) + "总计:" + order.sumPrices[index]);

			returnMenu();
		} catch (InputMismatchException e) {
			System.err.print("输入的必须是数字....");
			returnMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2.查看餐袋；
	public void display() throws Exception {
		System.out.println("***查看餐袋***");

		System.out.println("序号\t订餐人\t餐品信息\t\t送餐日期\t\t送餐地址\t\t总金额\t订单状态");
		for (int i = 0; i < order.names.length; i++) {
			if (order.names[i] != null) {
				System.out.print((i + 1) + "\t");
				System.out.print(order.names[i] + "\t");
				System.out.print(order.dishMegs[i] + "\t\t");
				System.out.print(order.times[i] + "\t\t");
				System.out.print(order.address[i] + "\t\t");
				System.out.print(order.sumPrices[i] + "\t");
				System.out.println(order.states[i] == 0 ? "已预定" : "已完成"); // 三元运算符
			}
		}
		returnMenu();
	}

	// 3.签收订单
	public void sign() throws Exception {
		boolean isSignFind = false;// 找到要签收的订单号
		System.out.println("请选择要签收的订单号:");
		int signOrderId = input.nextInt();// 控制台输入需要签收的订单号
		for (int i = 0; i < order.names.length; i++) {
			if (order.names != null && order.states[i] == 0 && i == signOrderId - 1) {
				order.states[i] = 1;
				System.out.println("订单签收成功");
				isSignFind = true;
			} else if (order.names != null && order.states[i] == 1 && i == signOrderId - 1) {
				System.out.println("您选择的订单已签收,不能再次签收!");
				isSignFind = true;
			}
		}
		if (!isSignFind) {
			System.out.println("您选择的订单不存在!");
		}
		System.out.println("输入0返回");
		int inputZero = input.nextInt();
		if (inputZero == 0) {
			showMenu();
		}
	}

	// 4.删除订单
	public void delte() throws Exception {
		System.out.println("****删除订单****");
		// 1.展示餐袋
		System.out.println("序号\t订餐人\t餐品信息\t\t送餐日期\t\t送餐地址\t\t总金额\t订单状态");
		for (int i = 0; i < order.names.length; i++) {
			if (order.names[i] != null) {
				System.out.print((i + 1) + "\t");
				System.out.print(order.names[i] + "\t");
				System.out.print(order.dishMegs[i] + "\t\t");
				System.out.print(order.times[i] + "\t\t");
				System.out.print(order.address[i] + "\t\t");
				System.out.print(order.sumPrices[i] + "\t");
				System.out.println(order.states[i] == 0 ? "已预定" : "已完成" + "\n"); // 三元运算符

			}
		}
		// 2.删除订单信息
		System.out.print("请输入要删除的订单编号:");
		int num = input.nextInt();
		for (int i = num - 1; i < order.names.length - 1; i++) {
			order.names[i] = order.names[i + 1];
			order.dishMegs[i] = order.dishMegs[i + 1];
			order.times[i] = order.times[i + 1];
			order.address[i] = order.address[i + 1];
			order.sumPrices[i] = order.sumPrices[i + 1];
			order.states[i] = order.states[i + 1];
		}
		// 将数组的最后一个位置内容置空
		int lastIndex = order.names.length - 1;
		order.names[lastIndex] = null;
		order.dishMegs[lastIndex] = null;
		order.times[lastIndex] = 0;
		order.address[lastIndex] = null;
		order.sumPrices[lastIndex] = 0;
		order.states[lastIndex] = 0;
		System.out.println("订单删除成功!!!");

		// 返回菜单
		returnMenu();

	}

	// 5.我要点赞
	public void praise() throws Exception {
		System.out.println("****我要点赞****");
		System.out.println("序号\t菜品名称\t单价\t点赞数");
		for (int i = 0; i < order.dishNames.length; i++) {
			String price = order.prices[i] + "元";
			String praiseNums = (order.praiseNums[i] > 0 ? order.praiseNums[i] + "赞" : "");
			System.out.println((i + 1) + "\t" + order.dishNames[i] + "\t" + price + "\t" + praiseNums);
		}
//		try {
			System.out.print("请选择您要点赞的菜品编号:");
			int praiseNum = input.nextInt();

			order.praiseNums[praiseNum - 1]++;
			System.out.println("点赞成功!!!");

			// 返回主菜单
			returnMenu();
//		} catch (InputMismatchException e) {
//			System.err.println("输入的必须是数字....");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	// 输入0返回菜单
	public void returnMenu() throws Exception {
		System.out.println("输入0返回:");
		int num = input.nextInt();
		if (num == 0) {
			showMenu();
		} else {
			System.out.println("输入有误，系统退出！！");
		}

	}

	/**
	 * 显示菜单方法
	 */
	public void showMenu() throws Exception {
//		while (true) {
			Scanner input = new Scanner(System.in);
			initial();

			System.out.println("欢迎使用订餐系统!!!");
			System.out.println("*******************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("*******************");
			try {
				System.out.println("请选择:");
				int num = input.nextInt();
				switch (num) {
				case 1:
					// 1.我要订餐
					add();
					break; 
				case 2:
					// 2.查看餐袋
					display();
					break;
				case 3:
					// 3.签收订单
					sign();
					break;
				case 4:
					// 4.删除订单
					delte();
					break;
				case 5:
					// 5.我要点赞
					praise();
					break;
				case 6:
					// 6.退出系统
					System.out.println("欢迎下次光临本店!!!");
					break;
				default:
					System.out.println("您的操作有误，请重新输入！！！");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("输入的必须是数字.................");
				returnMenu();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//	}
}
