package arrayList;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
	public static void main(String[] args) {
		//创建狗狗类对象
		Dog dogOne = new Dog("欧欧","二哈");
		Dog dogThree = new  Dog("菲菲","拉布拉多");
		//创建ArrayList集合对象
		List dogList = new ArrayList();
		//添加到集合里
		dogList.add(dogOne);
		dogList.add(new Dog("亚亚","金毛"));
		dogList.add(dogThree);
		dogList.add(new Dog("美美","泰迪"));
		//输出集合大小
		System.out.println("共计有" + dogList.size() + "条狗狗");
		System.out.println("分别是：");
		//通过循环输出集合里的元素(对象)
		for(int i = 0;i<dogList.size();i++) {
			if(dogList.get(i) instanceof Dog) {
				//获得集合里每条狗狗对象并向下转型和打印toString信息
				Dog dog =(Dog)dogList.get(i);
				System.out.println(dog);
			}
		}
		
		System.out.println("删除之前共计有" + dogList.size() + "条狗狗");
		//根据索引删除元素
		dogList.remove(0);
		//根据对象名删除元素
		dogList.remove(dogThree);
		System.out.println("\n删除之后还有" + dogList.size() + "条狗狗");
		System.out.println("分别是：");
		//foreach增强型循环
		for(Object ob : dogList) {
			if(ob instanceof Dog) {
				//调用子类Dog重写toString()方法
				System.out.println(ob);//ob.toString()调用toString()方法
			}
		}
		//集合里是否包含美美的对象信息
		if(dogList.contains(dogList.get(1))){
			System.out.print("集合中包含美美的信息");
		}else {
			System.out.print("集合中没有美美的信息");
		}
	}
}
