package chapter9;

import java.util.Scanner;

/**
 * 吃货联盟订餐系统
 * 
 * @author HXZY
 *
 */

public class OrderingSystem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int conpiesNum;// conpiesNum 份数
		String orderingTime;// 送餐时间
		String orderingAddress;// 送餐地址
//		double distributionFee;//送餐费
		String[] MealBag = new String[7];
		boolean flag = true;
		while (flag) {
			String[] menusOrdering = { "1.我要订餐", "2.查看餐袋", "3.签收订单", "4.删除订单", "5.我要点餐", "6.退出系统" };
			System.out.println("欢迎来到“吃货联盟订餐系统”");
			System.out.println("*******************************");
			for (int i = 0; i < menusOrdering.length; i++) {
				System.out.println(menusOrdering[i]);
			}
			System.out.print("请选择：");
			int num = input.nextInt();

			switch (num) {
			case 1:
				Ordering(input);
				Dish firstLine = new Dish("红烧带鱼", 38.0, 0);
				Dish secondLine = new Dish("鱼香肉丝", 20.0, 0);
				Dish thirdLine = new Dish("时令鲜蔬", 10.0, 0);
				Dish dishs[] = { firstLine, secondLine, thirdLine };
				for (int i = 0; i < dishs.length; i++) {
					System.out.println(
							(i + 1) + "\t" + dishs[i].dishName + "\t" + dishs[i].dishPrice + "\t" + dishs[i].dishLikes);

				}

				System.out.print("请选择您要点的菜品编号：");
//				while(input.hasNextInt());{
				int orderingNum = input.nextInt();
				for (int i = 0; i < dishs.length; i++) {
					if (orderingNum == i + 1) {
						System.out.println("请输入你需要的份数：");
						// conpiesNum 份数
						conpiesNum = input.nextInt();
//						if() {}
						System.out.println("请输入送餐时间（送餐时间是10点至20点间整点送餐）：");
						// 送餐时间
						orderingTime = input.next();
						System.out.println("请输入送餐地址：");
						// 送餐地址
						orderingAddress = input.next();
						double distributionFee;// 送餐费
						if (dishs[i].dishPrice < 50) {
							distributionFee = 5;
						} else {
							distributionFee = 0;
						}
						System.out.println("订餐成功！");
						System.out.println("您订的是：" + dishs[i].dishName + (conpiesNum) + "份" + "\n" + "送餐时间："
								+ orderingTime + "\n" + "餐费：" + (dishs[i].dishPrice * conpiesNum) + "元" + "\t" + "送餐费:"
								+ distributionFee + "元" + "\t" + "总计："
								+ ((dishs[i].dishPrice * conpiesNum) + distributionFee) + "元");
					} // else {
//						System.out.println("输入有误，请重新输入：");
//					}
//					String orderingPeople = name;
//					String foodInfo = dishs[i].dishName, deliverDate = orderingTime, deliverAddress = orderingAddress;
//							double totalAmout = (dishs[i].dishPrice * conpiesNum) + distributionFee);
				}
//				System.out.println("输入有误，请重新输入：");
//			}
				break;
			case 2:
//				System.out.println("******2.查看餐袋******");
//				MealBag one = new MealBag("orderingPeople",foodInfo,conpiesNum,deliverDate,deliverAddress,totalAmout,orderStatue);
//				MealBag tow = new MealBag("鱼香肉丝", 20.0, 0);

				for (int i = 0; i < MealBag.length; i++) {
					System.out.println(MealBag[i]);
				}

				break;
			case 3:
				System.out.println("******3.签收订单******");
				break;
			case 4:
				System.out.println("******4.删除订单******");
				break;
			case 5:
				System.out.println("******5.我要点赞******");
				break;
			case 6:
				System.out.println("谢谢使用，欢迎下次光临！");
				flag = false;
				break;

			default:
				System.out.println("输入0返回：0");
//			num = input.nextInt();
//			if (num == 0) {
				flag = true;
//			}
				System.out.println("********************************");

				break;
			}

//			System.out.println("*********************************");
			System.out.println("\n");
		}

	}

	/**
	 * 我要订餐的 方法
	 */
	static void Ordering(Scanner input) {
		System.out.println("******1.我要订餐******");
		System.out.print("请输入订餐人姓名：");
		String name = input.next();
		System.out.println("序号" + "\t" + "菜名" + "\t" + "单价" + "\t" + "点赞数");
//		System.out.println();
	}

	/**
	 * 查看餐袋的 方法
	 */
	static void Bag(Scanner input) {
		System.out.println("******2.查看餐袋******");
		System.out.println("序号" + "\t" + "订餐人" + "\t" + "餐品信息" + "\t" + "送餐日期" + "\t" + "总金额" + "\t" + "订单状态");

	}
}

//创建一个菜品类
class Dish {
	String dishName;// 菜品名
	double dishPrice;// 菜品价格
	int dishLikes;// 菜品点赞数

	// 创建一个菜品构造函数

	public Dish(String dishName, double dishPrice, int dishLikes) {
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.dishLikes = dishLikes;
	}
}

//创建一个餐袋类
class MealBag {
	String orderingPeople;// 订餐人
	String foodInfo; // 餐品信息
	String deliveryDate;// 送餐日期
	String deliveryAddress;// 送餐地址
	double totalAmount;// 总金额
	String orderStatus;// 订单状态

	public MealBag(String orderingPeople, String foodInfo, String deliveryDate, String deliveryAddress,
			double totalAmount, String orderStatus) {
		this.orderingPeople = orderingPeople;
		this.foodInfo = foodInfo;
		this.deliveryDate = deliveryDate;
		this.deliveryAddress = deliveryAddress;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
	}

}
