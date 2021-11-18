package factory.method;

/**
 * 创建工厂类
 * @author y
 *
 */
public class SendFactory {
	public Sender produce(String type) {
//		if("email".equals(type)) {
//			return new EmailSender();
//		}else if ("sms".equals(type)) {
//			return new SmsSender();
//		}else {
//			System.out.println("请输入正确的类型！");
//		return null;
//		}
		Sender sender = null;
		switch(type){
		case "email":
			sender = new EmailSender();
			break;
		case "sms":
			sender = new SmsSender();
			break;
		default:
			System.out.println("请输入正确的类型！");
			break;
		}
		return sender;
	}
}
