package enumpackage;

/**
 * Integer 128
 * 
 * @author y
 *
 */
public class TestInteger {
	public static void main(String[] args) {
		// 1.127--127范围内正确
		Integer one = 127;
		Integer two = 127;
		System.out.print(one == two);

		// 2.128---128范围内
		Integer three = 128;
		Integer four = 128;
		System.out.print(three == four);
		// 拆箱xxx.intValue()
		System.out.print(three.intValue() == four.intValue());
	}
}
