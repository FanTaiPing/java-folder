package chapter4;
/*
 * 用户登录switch和if的混合使用
 */
import java.util.Scanner;
/**
 * 商品换购
 * @author HXZY
 *
 */
//swap 换购
public class Swap {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入消费金额：");
		double money = input.nextDouble();
		System.out.print("是否参加优惠换购活动(y):");
		String judge = input.next();
		if("y".equals(judge)) {
			System.out.println("1:满50元，加2元换购百世可乐饮料1瓶");
			System.out.println("2:满100元，加3元换购500ml可乐1瓶");
			System.out.println("3:满100元，加10元换购5公斤面粉");
			System.out.println("4:满200元，加10元可换购1个苏泊尔炒菜锅");
			System.out.println("5:满200元，加20元可换购欧莱雅爽肤水一瓶");
			System.out.println("0:不换购");
			System.out.print("请选择：");
			if(input.hasNextInt()) {
			int num = input.nextInt();
			switch(num) {
			case 1:
				if(money >= 50) {
					System.out.println("本次消费总金额为："+ (money+2));
					System.out.println("成功换购：百世可乐饮料1瓶");
				}else {
					System.out.println("不满足换购金额！");
				}
				break;
			case 2:
				if(money >= 100) {
					System.out.println("本次消费总金额为："+ (money+3));
					System.out.print("成功换购：500ml可乐1瓶");
				}else {
					System.out.println("不满足换购金额！");
				}
				break;
			case 3:
				if(money >= 100) {
					System.out.println("本次消费总金额为："+ (money+10));
					System.out.print("成功换购：5公斤面粉");
				}else {
					System.out.println("不满足换购金额！");
				}
				break;
			case 4:
				if(money >= 200) {
					System.out.println("本次消费总金额为："+ (money+10));
					System.out.print("成功换购：1个苏泊尔炒菜锅");
				}else {
					System.out.println("不满足换购金额！");
				}
				break;
			case 5:
				if(money >= 200) {
					System.out.println("本次消费总金额为："+ (money+20));
					System.out.print("成功换购：欧莱雅爽肤水一瓶");
				}else {
					System.out.println("不满足换购金额！");
				}
				break;		
			case 0:
				System.out.print("不换购");
			default :
			}
			}else {
				System.out.print("请输入正确的数字！");
			}
			
		}
		
		
	}

}
