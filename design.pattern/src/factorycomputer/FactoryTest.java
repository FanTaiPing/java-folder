package factorycomputer;
/**
 * 简单工厂测试类
 * @author y
 *
 */
public class FactoryTest {
	public static void main(String[] args) {
		SimpleFactory.create("hp").start();
	}
}
