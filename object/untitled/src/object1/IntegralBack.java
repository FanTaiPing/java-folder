package object1;

import java.util.Scanner;

/**
 * 实现积分回馈功能金卡客户积分大于1000分或普卡客户积分大于5000，获得回馈积分500分,创建客户对象输出他得到的回馈积分
 * @author HXZY
 *
 */

public class IntegralBack {
	/*
	 * 定义类的属性
	 */
int point;//积分
String cardType;//卡类型



/*
 * 定义类的方法
 */
public void showPoint() {
	Scanner input = new Scanner(System.in);
	System.out.print("请输入会员积分：");
	point = input.nextInt();
	System.out.print("请输入会员卡类型：");
	cardType = input.next();
	if((point >1000 && "金卡".equals(cardType)) || (point >5000 && "普卡".equals(cardType))) {
		point += 500; 
		System.out.print("回馈积分500分！"+"\n总积分为：" + point);
	}else {
		System.out.print("不满足获得积分条件，无法获得回馈积分！");
	}
}

}
