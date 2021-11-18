package chapter4;

import java.util.Scanner;

public class MyShopping {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("欢迎使用MyShopping管理系统");
		System.out.println("*******************************");
		System.out.println("\t1.客户信息管理");
		System.out.println("\t2.购物结算");
		System.out.println("\t3.真情回馈");
		System.out.println("\t4.注销");
		System.out.println("*******************");
		System.out.print("请选择，输入数字：");
		int num;
		boolean judge = true;
		while (judge) {
			if (input.hasNextInt()) {
				num = input.nextInt();
				switch (num) {
				case 1:
					System.out.println("执行客户信息管理");
					judge = false;
					break;
				case 2:
					System.out.println("执行购物结算");

					System.out.println("***********************");
					System.out.println("请选择购买的商品编号：");
					System.out.println("1.T 恤" + "\t2.网球鞋" + "\t3.网球拍");
					double tShitnum,Shosenum,tTentnum;// T血数量// 网球鞋数量// 网球数量拍价格
					double totalPrice = 0,realMoney,giveChange;//总价  实付金额  找钱
					double tShitMoney = 245,ShoseMoney = 300,tTentMoney = 350;// T血价格// 网球鞋价格 // 网球拍价格
					String answer;
					do {
						System.out.print("请输入商品编号：");					
						if (input.hasNextInt()) {
							int num1 = input.nextInt();
							switch (num1) {
							case 1:
								System.out.print("请输入购买数量：");
								while(!input.hasNextInt()) {
									input.next();
									System.out.print("输入错误!请输入数字：");
								}
								tShitnum = input.nextInt();
								System.out.println("1.T 恤" + "\t" + "¥" + tShitMoney + "\t" + "数量：" + tShitnum + "\t"
										+ "¥" + (tShitMoney * tShitnum));
								totalPrice += tShitMoney * tShitnum;
//								else {
//									System.out.println("输入错误!");
//								}
								break;
							case 2:
								System.out.print("请输入购买数量：");
								while(!input.hasNextInt()) {
									input.next();
									System.out.print("输入错误!请输入数字：");
								}
								Shosenum = input.nextInt();
								System.out.println("2.网球鞋" + "\t" + "¥" + ShoseMoney + "\t" + "数量：" + Shosenum + "\t"
										+ "¥" + (ShoseMoney * Shosenum));
								totalPrice += ShoseMoney * Shosenum;
								break;
							case 3:
								System.out.print("请输入购买数量：");
								while(!input.hasNextInt()) {
									input.next();
									System.out.print("输入错误!请输入数字：");
								}
								tTentnum = input.nextInt();
								System.out.println("3.网球拍" + "\t" + "¥" + tTentMoney + "\t" + "数量：" + tTentnum + "\t"
										+ "¥" + (tTentnum * tTentMoney));
								totalPrice += (tTentnum * tTentMoney);
								break;
							default:
								System.out.print("输入有误！");
								break;
							}
						} else {
							System.out.print("输入有误！");
						}
						System.out.print("是否继续(y/n):");
						answer = input.next();
					} while ("y".equals(answer));
//					while("y".equalsIgnoreCase(answer));
					System.out.println("折扣：0.8");
					System.out.println("应付金额：" + (totalPrice * 0.8));
					System.out.print("请输入实付金额：");
					realMoney = input.nextDouble();
					System.out.println("找钱：" + (realMoney - (totalPrice * 0.8)));
					judge = false;
					break;	
				case 3:
					System.out.println("执行真情回顾");
					judge = false;
					break;
				case 4:
					System.out.println("执行注销");
					judge = false;
					break;

				default:
					System.out.print("输入错误，请重新输入数字：");
					judge = true;
					break;

				}
				

			} else {
				System.out.print("输入错误，请重新输入数字：");
				judge = false;
			}

		}
		
		
		System.out.println("你已退出购买功能！");
		System.out.print("程序结束！");
	}

}
