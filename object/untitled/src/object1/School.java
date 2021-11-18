package object1;

public class School {
//定义类的属性
	/**
	 * 学校名称
	 */
	String name;
	/**
	 * 教室数目
	 */
	int classroom;
	/**
	 * 学校地址
	 */
	String address;
	
	
	//定义类的方法
	/**
	 * 显示打印学校信息
	 */
	
	public void showCenter() {
		System.out.println("学校是：" + name + "教室有："+ classroom +"间，"+ "地址是："+address);
	}
}
