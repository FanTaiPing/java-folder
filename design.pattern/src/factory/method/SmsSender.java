package factory.method;

/**
 * 发送短信实现类
 * 
 * @author y
 *
 */
public class SmsSender implements Sender {

	@Override
	public void Send() {
		System.out.println("this is smssender!");
	}

}
