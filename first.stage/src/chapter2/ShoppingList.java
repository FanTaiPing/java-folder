package chapter2;

import java.util.Scanner;

/**
 * 购物清单
 * @author HXZY
 *
 */
 
public class ShoppingList {
public static void main (String[] args){
	//接收语句
	Scanner input = new Scanner(System.in);
	double tShit =245, tennisShoes= 570, tennisRacket= 320;
	int tsNum = 2,tShose = 1,trNum = 1;
	double tsMoney =tShit * tsNum, tShoseMoney = tennisShoes * tShose,trMoney = tennisRacket * trNum;
	System.out.println("*********消费单*********");
	System.out.println("购买物品\t单价\t个数\t金额");
	System.out.println("T血"+"\t"+"￥"+tShit+"\t"+tsNum+"\t"+"￥"+tsMoney);
	System.out.println("网球鞋"+"\t"+"￥"+tennisShoes+"\t"+tShose+"\t"+"￥"+tShoseMoney);
	System.out.println("网球拍"+"\t"+"￥"+tennisRacket+"\t"+trNum+"\t"+"￥"+trMoney);
	System.out.print("请输入折扣：");
	double discount = input.nextDouble();
	System.out.println("消费总金额为：" + (tsMoney + tShoseMoney + trMoney) * discount);
	System.out.print("实际交费：");
	double realMoney = input.nextDouble();
	System.out.print("找钱："+ (realMoney - (tsMoney + tShoseMoney + trMoney )* discount));
	System.out.print("本次购物积分是：33");

	
}
}
