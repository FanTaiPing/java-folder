package arrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestIterator {
	public static void main(String[] args) {
		// 添加狗狗对象到Map集合里
		Map map = new HashMap();

		Dog dogOne = new Dog("欧欧", "二哈");
		Dog dogTwo = new Dog("亚亚", "金毛");
		Dog dogThree = new Dog("菲菲", "泰迪");
		Dog dogFour = new Dog("美美", "中华田园犬");

		map.put(dogOne.getName(), dogOne);
		map.put(dogTwo.getName(), dogTwo);
		map.put(dogThree.getName(), dogThree);
		map.put(dogFour.getName(), dogFour);

		// 1.Iterator迭代器迭代
		Set keyMap = map.keySet();
		Iterator it = keyMap.iterator();

		
		System.out.println("Iterator迭代");
		//两种打印输出方式
		//方法一： 1.hasNext()是否包含下一条元素
		while (it.hasNext()) {
			String key = (String) it.next();
			Dog dog = (Dog) map.get(key);
			System.out.println(key + "\t" + dog.getStrain());
		}
		//方法二： 2.foreach增强型循环
		System.out.println("\nforeach迭代");
		for (Object ob : map.keySet()) {
			String key = (String) ob;
			Dog dog = (Dog) map.get(key);
			System.out.println(key + "\t" + dog.getStrain());
		}
	}
}
