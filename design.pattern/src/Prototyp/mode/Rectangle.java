package Prototyp.mode;

/**
 * 创建矩形的实体类
 * 
 * @author y
 *
 */
public class Rectangle extends Shape {
	public Rectangle() {
		type = "Rectangle";
	}

	/**
	 * 重写父类绘画的抽象方法
	 */
	@Override
	public void draw() {
		System.out.println("Rectangle");
	}
}
