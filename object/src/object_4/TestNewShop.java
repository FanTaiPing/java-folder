package object_4;

import java.util.Scanner;

/**
 * 测试商店
 * 
 * @author HXZY
 *
 */
public class TestNewShop {
	public void initShop() {
		Scanner input = new Scanner(System.in);
		System.out.println("*******欢迎来到宠物商店*******");
		System.out.print("请输入要领养的宠物名字：");
		String name = input.next();	
		System.out.print("请选择要领养的宠物的类型：1.狗狗 2.企鹅");
			int num = input.nextInt();
		switch(num) {
		case 1:
			NewDog dog = new NewDog();
			dog.setName(name);
			System.out.print("请选择狗狗的品种：1.可爱的二哈 2.可爱的金毛");
			num = input.nextInt();
			switch(num) {
			case 1:
				dog.setStrain("二哈");
			break;
			case 2:
				dog.setStrain("金毛");
			break;
			default :
				System.out.print("请输入正确的数字：");
			break;
			}
			dog.print();
			break;
		case 2:
			NewPenguin penguin = new NewPenguin();
			penguin.setName(name);
			System.out.print("请选择企鹅的性别：1.Q仔 2.Q妹");
			num = input.nextInt();
			switch (num) {
			case 1:
				penguin.setSex("雄");
			break;
			case 2:
				penguin.setSex("雌");
			break;
			default :
				System.out.print("请输入正确的数字：");
			break;
			}
			penguin.print();
			break;
			default :
				System.out.print("请输入正确的数字：");
			break;
			
		}
	}
	public static void main(String[] args) {
	new TestNewShop().initShop();
}
}
