/**
 * 宠物乐园测试类
 */
package object7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestAnimalMenu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// 创建一个对象数组用于存储动物的属性
		Animal[] animal = new Animal[3];
		animal[0] = new Cat("加菲猫", 0);
		animal[1] = new Duck("唐小鸭", 0);
		animal[2] = new Dolphin("海豚奇奇", 0);

		while (true) {
			try {
				
				System.out.println("动物名字" + "\t" + "腿的条数" + "\t" + "动物叫");
				for (int i = 0; i < animal.length; i++) {
					String name = animal[i].getName();
					int legNum = ((legNum) animal[i]).getlegNum();
					System.out.print(name + "\t" + legNum + "\t");
					animal[i].shout();
				}

				System.out.print("是否要继续修改数据：按0进行修改操作，其它任意数字键退出:");
				String any = input.next();
				if ("0".equals(any)) {
					System.out.print("请输入要修改的动物的名称：");
					String name = input.next();
					for (int i = 0; i < animal.length; i++) {
						// 判断数组里面是否存在输入的名字
						if (name.equals((animal[i]).getName())) {
							// 判断数组里面是否存在猫类
							if (animal[i] instanceof Cat) {
								System.out.print("请重新输入修改后的" + name + "的名称：");
								String name1 = input.next();
								((Cat) animal[i]).setName(name1);
								System.out.print("请输入修改后" + name + "腿的条数：");
								int legNum = input.nextInt();
								// 将数组强转为猫类，然后再个猫类重新赋值
								((Cat) animal[i]).setLegNum(legNum);
								break;
								// 判断数组里面是否存在鸭子类
							} else if (animal[i] instanceof Duck) {
								System.out.print("请重新输入修改后的" + name + "的名称：");
								String name1 = input.next();
								((Cat) animal[i]).setName(name1);
								System.out.print("请输入修改后" + name + "腿的条数：");
								int legNum = input.nextInt();
								((Duck) animal[i]).setLegNum(legNum);
								break;
							} else {
								System.out.println("海豚没有腿！！");
								break;
							}
						} else {
							System.err.println("对不起，无法找到您要修改的动物的名称！");
							break;
						}
					}
				} else {
					System.out.print("你已退出程序！");
					System.exit(1);
				}

			} catch (InputMismatchException e) {
				System.err.println("输入的必须是数字....");
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}

	}
}
