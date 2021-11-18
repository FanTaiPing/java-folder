package Prototyp.mode;

/**
 * 创建正方形的实体类
 * 
 * @author y
 *
 */
public class Square extends Shape {

	public Square() {
		type = "Square";
	}

	@Override
	public void draw() {
		System.out.println("Square");
	}

}
