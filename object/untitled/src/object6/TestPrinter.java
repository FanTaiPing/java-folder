package object6;

/**
 * 打印机测试类
 * 
 * @author y
 *
 */
public class TestPrinter {
	public static void main(String[] args) {
		Printer pt = new Printer();
		System.out.println("使用" + pt.blackAndWhie() + "在" + pt.B5Paper() + "上打印");
		System.out.println("使用" + pt.colour() + "在" + pt.B5Paper() + "上打印");
		System.out.println("使用" + pt.blackAndWhie() + "在" + pt.A4Paper() + "上打印");
		System.out.println("使用" + pt.colour() + "在" + pt.A4Paper() + "上打印");
	}
}
