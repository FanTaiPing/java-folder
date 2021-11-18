package object_4;

public class Pig extends Pet {
	private String color;

	public Pig() {
		System.out.println("我是Pig的无参构造方法");
	}
	
/***
 * 方法重写：重写Object类的toString()方法
 */
	
	public String toString() {
		return "我是一头白毛猪";
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void showInfo() {
		System.out.println("我的名字叫：" + getName() + ",我的年龄是：" + getAge() + ",我的颜色是：" + getColor());

	}

}
