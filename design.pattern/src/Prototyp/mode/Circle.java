package Prototyp.mode;

/**
 * 创建圆的实体类
 * 
 * @author y
 *
 */
public class Circle extends Shape {
	public Circle() {
		type = "Circle";
	}

	@Override
	public void draw() {
		System.out.println("Circle");
	}
}
