package object3;

import java.util.Scanner;

public class TestShop {
	public static void menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("欢迎光临宠物店！");
		System.out.print("请输入要领养的宠物的名字：");
		String name = input.next();
		System.out.print("请输选择要领养的宠物的类型：（1.狗狗 2.企鹅）");
		int type = input.nextInt();
		switch (type) {
		case 1:
			System.out.print("请输入狗狗的年龄：");
			int age = input.nextInt();
			System.out.print("请输入狗狗的健康值：");
			int health = input.nextInt();
			System.out.print("请输入狗狗的亲密度：");
			int love = input.nextInt();
			Dog dog = new Dog();
			dog.setName(name);
			dog.setAge(age);
			dog.setHealth(health);
			dog.setLove(love);
			dog.showInfoDog();
			break;
		case 2:
			System.out.print("请输入企鹅的性别：");
			String sex = input.next();
			System.out.print("请输入企鹅的爱好：");
			String hobby = input.next();
			System.out.print("请输入企鹅的亲密度：");
			love = input.nextInt();
			Penguin penguin = new Penguin();
			penguin.getName();
			penguin.setSex(sex);
			penguin.setHobby(hobby);
			penguin.setLove(love);
			penguin.showInfoPenguin();
			break;

		}
	}

	public static void main(String[] args) {
		TestShop.menu();
	}

}
