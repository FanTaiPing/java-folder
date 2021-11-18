package object4;

import java.util.Random;
import java.util.Scanner;

/**
 * 租车测试类
 * 
 * @author HXZY
 *
 */
public class TestCarRental {
	Scanner input = new Scanner(System.in);
	Car car = new Car();
	Bus bus = new Bus();
	int days;
	public void carShop() {		
		System.out.println("********欢迎来到QQ飞车租车行！*******");
		System.out.print("请你要租车的天数：");
		days = input.nextInt();
		System.out.print("请选择你要租的车的类型：1.轿车 2.客车:");
		int num = input.nextInt();	
		switch (num) {
		case 1:
			creatCar();	
			break;
		case 2:
			creatBus();
			break;
		default:
			System.out.println("请输入正确的数字：");
			break;
		}
	}
	/**
	 * 租轿车
	 */
	public void creatCar() {
		System.out.println("别克商务舱GL8" + "\t\t" + "600元/天");
		System.out.println("宝马550i" + "\t\t\t" + "500元/天");
		System.out.println("别克林荫大道" + "\t\t" + "300元/天");
		System.out.print("请选择你要租的车的品牌：" + "\n" + "1.别克商务舱GL8  " + "\n" + "2.宝马550i " + "\n" + "3.别克林荫大道:");
		int num = input.nextInt();

		switch (num) {
		case 1:
			System.out.println("给你分配的别克商务舱GL8车的车牌号为：" + creatNo());
			car.setRent(600);
			car.setDays(days);
			car.calcRent();
			break;
		case 2:
			System.out.println("给你分配的宝马550i车的车牌号为：" + creatNo());
			car.setRent(500);
			car.setDays(days);
			car.calcRent();
			break;
		case 3:
			System.out.println("给你分配的别克林荫大道车的车牌号为：" + creatNo());
			car.setRent(300);
			car.setDays(days);
			car.calcRent();
			break;
		default:
			System.out.println("请输入正确的数字：");
			break;
		}
	}
	/**
	 * 租客车
	 */
	public void creatBus() {
		System.out.println("金杯 <=16座 " + "\t\t" + "800元/天");
		System.out.println("金龙 > 16座" + "\t\t" + "1500元/天");
		System.out.print("请选择你要租的车的品牌： 1.金杯  2.金龙");
		int num = input.nextInt();		
		switch (num) {
		case 1:
			System.out.print("请选择你要租的车的座位数：" + "\n" + "1.<=16座  " + "\n" + "2.>16座:");
			num = input.nextInt();
			switch (num) {
			case 1:
				System.out.println("给你分配的金杯<=16座车的车牌号为：" + creatNo());
				bus.setRent(800);
				bus.setDays(days);
				bus.calcRent();
				break;
			case 2:
				System.out.println("给你分配的金杯>16座车的车牌号为：" + creatNo());
				bus.setRent(1500);
				bus.setDays(days);
				bus.calcRent();
				break;
			default:
				System.out.println("请输入正确的数字：");
				break;
			}
		case 2:
			System.out.println("请选择你要租的车的座位数：1.<=16座   2.>16座:");
			num = input.nextInt();
			switch (num) {
			case 1:
				System.out.println("给你分配的金龙>16座车的车牌号为：" + creatNo());
				bus.setRent(800);
				bus.setDays(days);
				bus.calcRent();
				break;
			case 2:
				System.out.println("给你分配的金龙>16座车的车牌号为：" + creatNo());
				bus.setRent(1500);
				bus.setDays(days);
				bus.calcRent();
				break;
			default:
				System.out.println("请输入正确的数字：");
				break;
			}
			break;
		default:
			System.out.println("请输入正确的数字：");
			break;
		}
	}

	/**
	 * 随机生成车牌号
	 * @param args
	 */
	public String creatNo() {
		String str = "云A";
		for(int i = 0;i<5;i++){
			//new Random().nextInt(9) 生成0-9之间的随机数
			int num = new Random().nextInt(9);
			str += num;
		}
		return str;
	}
	
	
	public static void main(String[] args) {
		new TestCarRental().carShop();
	}

}
