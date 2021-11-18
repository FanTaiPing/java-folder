package chapter8;
/**
 * 多家店购买多件衣服
 */
import java.util.Scanner;

public class ForDoubleShoppingBreak {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println("欢迎光临第" + (i + 1) + "家专卖店");

			for (;;) {

				System.out.print("要离开吗？(y/n)?");
				String judge = input.next();

				if (!"y".equals(judge)) {
					System.out.println("买了一件衣服");
					count++;
					if (count >= 3) {
						System.out.println("您购买的衣服衣服已超过上限!");
						break;
					}
				} else {
					break;
				}
			}

			System.out.println("离店结账！");
			if (count >= 3) {

				break;
			}
		}
		System.out.println(" ");
		System.out.print("总共买了" + count + "件衣服");
	}

}
