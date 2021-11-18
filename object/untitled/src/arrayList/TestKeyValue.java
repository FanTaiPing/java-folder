package arrayList;

import java.util.HashMap;
import java.util.Map;

public class TestKeyValue {
	public static void main(String[] args) {
		// 创建Map集合对象
		Map countries = new HashMap();
		// 添加国家
		countries.put("CN", "中华人民共和国");
		countries.put("US", "美利坚和众国");
		countries.put("JA", "日本");
		countries.put("RU", "俄罗斯联邦");

		// 获得key是CN国家、
		System.out.println("CN对应的国家是：" + countries.get("CN"));

		// map里的元素个数
		System.out.println("Map中共有" + countries.size() + "组数据");

		//移除JA这个键的值
		countries.remove("JA");
		
		// map里包含JA的key吗？
		System.out.println("Map中包含JA的key吗？" + countries.containsKey("JA"));

		// Map里key的集合
		System.out.println(countries.keySet());

		// Map里value的集合
		System.out.println(countries.values());

		// Map里的key-value 集合
		System.out.println(countries);

		// 删除map里所有元素
		countries.clear();

//		System.out.println("已清空map中的数据！");
		System.out.println(countries);
	}
}
