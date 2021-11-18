package object_5;

import java.util.Scanner;

public class TestMaster {
	public static void main(String[] args) {
		Master master = new Master();
		// 向上转型
		Pet dog = new Dog();
		Pet penguin = new Penguin();
		Pet cat = new Cat();

		master.feed(dog);
		master.feed(penguin);
		master.feed(cat);

		Scanner input = new Scanner(System.in);
		System.out.println("你需要喂狗还是企鹅或者是猫？");
		String typeId = input.next();
		Pet returnValue = master.feed(typeId);
		master.feed(returnValue);

		master.play(dog);
		master.play(penguin);
		master.play(cat);

//		master.feedDog();
//		master.feedPenguin();
	}

}
