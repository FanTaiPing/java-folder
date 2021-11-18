package arrayList;

import java.util.LinkedList;

public class TestLinkedList {
	public static void main(String[] args) {
		Dog dogOne = new Dog("欧欧", "二哈");
		Dog dogTwo = new Dog("亚亚", "拉布拉多");
		Dog dogThree = new Dog("菲菲", "金毛");
		Dog dogFour = new Dog("美美", "泰迪");

		// 使用LinkedList添加狗狗
		LinkedList dogList = new LinkedList();

		dogList.addFirst(dogOne);
		dogList.add(1, dogTwo);
		dogList.add(dogThree);
		dogList.addLast(dogFour);

		System.out.println("第一条狗狗的昵称是：" + ((Dog) dogList.getFirst()).getName());
		System.out.println("最后一条狗狗的昵称是：" + ((Dog) dogList.getLast()).getName());

		// 删除两条狗狗
		dogList.removeFirst();
		dogList.remove(dogThree);
		System.out.print("\n删除部分狗狗狗还有" + dogList.size() + "条狗狗。\n分别是：\n");
		for (Object ob : dogList) {
			if (ob instanceof Dog) {
				System.out.println(ob);
			}
		}
	}
}
