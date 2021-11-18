package factory.method;

/**
 * 工厂测试类
 * 
 * @author y
 *
 */
public class FactoryTest {
	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce("email");
		sender.Send();
	}
}
