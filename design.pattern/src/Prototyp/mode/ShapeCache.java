package Prototyp.mode;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建一个ShapeCache类，并将实体类存入Map集合中
 * 
 * @author y
 *
 */
public class ShapeCache {
	static Map<String, Shape> map = new HashMap<String, Shape>();
/**
 * 通过shapId获得形状方法
 * @param shapeId
 * @return
 * @throws CloneNotSupportedException
 */
	static Shape getShape(String shapeId) throws CloneNotSupportedException {
		Shape cachedShape = map.get(shapeId);
		return cachedShape.clone();
	}

	static void loadCache() {
		// 对每种形状都在map集合中查询，并创建该形状将其添加到map集合中
		// shapeMap.put(shapeKey, shape);
		// 例如，我们要添加三种形状
		Rectangle rectangle = new Rectangle();
		//设置形状的id
		rectangle.setId("1");
		//通过键值对应将设置的形状加入map集合中
		map.put(rectangle.getId(), rectangle);

		Square square = new Square();
		square.setId("2");
		map.put(square.getId(), square);

		Circle circle = new Circle();
		circle.setId("3");
		map.put(circle.getId(), circle);
	}
}
