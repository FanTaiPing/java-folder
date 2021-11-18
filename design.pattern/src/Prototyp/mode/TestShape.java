package Prototyp.mode;
/**
 * 原型模式测试类
 * @author y
 *
 */
public class TestShape {
	public static void main(String[] args) throws CloneNotSupportedException {
		ShapeCache.loadCache();

		Shape clonedShape = ShapeCache.getShape("1");
		System.out.println("Shape:" + clonedShape.type);

		Shape clonedShape1 = ShapeCache.getShape("2");
		System.out.println("Shape:" + clonedShape1.type);

		Shape clonedShape2 = ShapeCache.getShape("3");
		System.out.println("Shape:" + clonedShape2.type);
	}
}
