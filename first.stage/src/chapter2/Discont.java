package chapter2;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * 折扣
 * @author HXZY
 *
 */

public class Discont {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入您消费的总金额为：");
		double money = input.nextDouble();
		//保留小数点后两位
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("最终的消费金额为："+ df.format(money * 0.8));
	}
}
