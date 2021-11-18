package chapter3;

import java.util.Scanner;
/**
 * 会员购物信息
 * @author HXZY
 *
 */
public class infoMember {
	public static void main(String[] args) {
		System.out.println("我行我素购物管理系统 > 客户信息管理 > 添加客户信息");
		boolean repect = true;
		while (repect) {
			Scanner input = new Scanner(System.in);
			System.out.println("请输入会员号(<4位整数>)：");
			int idCard = input.nextInt();
			if (idCard <= 9999 && idCard >= 1000) {
				System.out.println("请输入会员生日(月/日<用两位数表示>):");
				String birthday = input.next();
				System.out.println("请输入积分：");
				// integral 积分
				int integral = input.nextInt();
				System.out.println("已录入的会员信息是：" + idCard + "\t" + birthday + "\t" + integral);
				repect = false;
			} else {
				System.out.println("您输入的卡号不符合会员卡");
				
			}
		}
	}

}
