package factorycomputer;

/**
 * 简单工厂类
 * 
 * @author y
 *
 */
public class SimpleFactory {
	public static Computer create(String type) {
		Computer computer = null;
		switch (type) {
		case "lenove":
			computer = new Lenove();
			break;
		case "hp":
			computer = new Hp();
			break;
		case "asus":
			computer = new Asus();
		}

		return computer;
	}
}
