package arrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestIteratorPenguin {
public static void main(String[] args) {
	NewPenguin penOne = new NewPenguin("欧欧","Q仔");
	NewPenguin penTwo = new NewPenguin("亚亚","Q妹");
	NewPenguin penThree = new NewPenguin("美美","Q妹");
	NewPenguin penFour = new NewPenguin("菲菲","Q妹");
	
	

	//方法一：利用List泛型集合 
	System.out.println("这是List泛型集合");
	List<NewPenguin> list = new ArrayList<NewPenguin>();
	list.add(penOne);
	list.add(penTwo);
	list.add(penThree);
	list.add(penFour);
	
	//方法一：foreach遍历NewPenguin对象
	for(Object pen : list) {
		System.out.print(pen);
	}
	
	System.out.println(" ");
	//方法二：for循环遍历NewPenguin对象
	for(int i =0;i<list.size();i++) {
		System.out.print(list.get(i));
	}
	System.out.println(" ");
	
	
	
	
	//方法二：利用Map泛型集合
	System.out.println("这是Map泛型集合");
	Map<String ,NewPenguin> map = new HashMap<String,NewPenguin>();
	map.put(penOne.getName(), penOne);
	map.put(penTwo.getName(), penTwo);
	map.put(penThree.getName(), penThree);
	map.put(penFour.getName(), penFour);
	//使用Iterator遍历
	Set keyMap = map.keySet();
	Iterator it = keyMap.iterator();
	
	while(it.hasNext()) {
		String key = (String) it.next();
		NewPenguin pen = map.get(key);
		System.out.println(key + "\t" + pen.getSex());
	}
	
}
}
