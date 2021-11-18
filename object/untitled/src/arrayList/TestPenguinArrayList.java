package arrayList;

import java.util.ArrayList;
import java.util.List;

public class TestPenguinArrayList {
	public static void main(String[] args) {
		NewPenguin penOne = new NewPenguin("欧欧", "Q仔");
		NewPenguin penTwo = new NewPenguin("亚亚", "Q妹");
		NewPenguin penThree = new NewPenguin("菲菲", "Q妹");
		NewPenguin penFour = new NewPenguin("美美", "Q妹");
		// 创建ArrayList集合对象
		List penguinList = new ArrayList();
		// 添加企鹅信息到ArrayList集合中
		penguinList.add(penOne);
		penguinList.add(penTwo);
		penguinList.add(penThree);
		penguinList.add(penFour);

		// 查看企鹅的数量和企鹅信息
		System.out.println("共有" + penguinList.size() + "只企鹅\n她们分别是：");
		// 通过循环输出集合里面企鹅的信息
		for (int i = 0; i < penguinList.size(); i++) {
			if (penguinList.get(i) instanceof NewPenguin) {
				// 获得集合里面的每条企鹅对象并向下转型和打印toString()信息
				NewPenguin newP = (NewPenguin) penguinList.get(i);
				System.out.println(newP);
			}
		}

		// 使用remove删除集合中部分企鹅的元素
		penguinList.remove(penThree);
		penguinList.remove(penFour);
		System.out.println("删除之后还有" + penguinList.size() + "只企鹅,\n分别是：");
		// foreach增强型循环
		for (Object ob : penguinList) {
			if (ob instanceof NewPenguin) {
				System.out.println(ob);
			}
		}
		//判断集合中是否包含指定企鹅
		if(penguinList.contains(penFour)) {
			System.out.print("集合中包含美美的信息");
		}else {
			System.out.print("集合中不包含美美的信息");
		}
	}
}
