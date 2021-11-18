package chapter4;

import java.util.Scanner;
/**
 * 拨号
 */
public class Call {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("按1：拨爸爸的号");
		System.out.println("按2：拨妈妈的号");
		System.out.println("按3：拨爷爷的号");
		System.out.println("按4：拨奶奶的号");
		System.out.println("**************************");
		System.out.println("");
		int i = 0;
		while (i < 5) {
			System.out.print("请输入你要拨打的号码:");
			int call = input.nextInt();
			switch (call) {
			case 1:
				System.out.println("正在给爸爸拨号....");
				break;
			case 2:
				System.out.println("正在给妈妈拨号....");
				break;
			case 3:
				System.out.println("正在给爷爷拨号....");
				break;
			case 4:
				System.out.println("正在给奶奶拨号....");
				break;

			default:
				System.out.println("你输入的号码不在服务范围内....");
			}
			i++;
		}
	}

}
