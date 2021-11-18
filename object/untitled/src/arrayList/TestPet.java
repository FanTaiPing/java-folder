package arrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestPet {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.print("请输入宠物的名字：");
	String name = input.next();
	
	Map pet = new HashMap();
	
	pet.put("欧欧", "雪纳瑞");
	pet.put("奇奇", "阿拉斯加");
	pet.put("菲菲", "二哈");
	pet.put("美美", "泰迪");
	
	if(pet.containsKey(name)) {
		System.out.println("Map中存在指定对象，对象信息如下：\n" + name  + "\t" + pet.get(name));	
	}else {
		System.out.println("Map中不存在指定对象！");
	}
	
	
	
	
} 
}
