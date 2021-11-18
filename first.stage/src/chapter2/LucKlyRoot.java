package chapter2;

import java.util.Scanner;
/**
 * 幸运用户
 * @author HXZY
 *
 */
public class LucKlyRoot {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入四位会员卡号：");
		int card = input.nextInt();
		int sum = (card / 1000) + (card / 100) % 10 + (card / 10) % 10 + card % 10;
		System.out.println("会员卡号" + card + "各位之和" + sum);

		System.out.println("是幸运用户吗？" + (sum >= 35));
	}
}
