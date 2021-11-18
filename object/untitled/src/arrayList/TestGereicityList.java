package arrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestGereicityList {
	public static void main(String[] args) {
		Dog dogOne = new Dog("欧欧", "二哈");
		Dog dogTwo = new Dog("亚亚", "金毛");
		Dog dogThree = new Dog("菲菲", "中华田园犬");
		Dog dogFour = new Dog("美美", "泰迪");

		//方法一： 创建List泛型集合（<>里面的内容指定数据类型）
		List<Dog> list = new ArrayList<Dog>();
		list.add(dogOne);
		list.add(dogTwo);
		list.add(dogThree);
		list.add(dogFour);
		System.out.println("这是List泛型集合");
		// 方法一：使用foreach遍历dogs对象
		for (Dog dog : list) {
			System.out.println(dog);
		}
//		 //方法二：使用for循环遍历dogs对象
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		System.out.println(" ");
		
		
		// 方法二：创建Map泛型集合
		Map<String, Dog> map = new HashMap<String, Dog>();
		map.put(dogOne.getName(), dogOne);
		map.put(dogTwo.getName(), dogTwo);
		map.put(dogThree.getName(), dogThree);
		map.put(dogFour.getName(), dogFour);

		Set keySet = map.keySet();
		Iterator it = keySet.iterator();
		System.out.println("这是Map泛型集合");
		// hasNext()是否包含下一条元素
		while (it.hasNext()) {
			String key = (String) it.next();
			Dog dog = map.get(key);
			System.out.println(key + "\t" + dog.getStrain());
		}
	}
}
