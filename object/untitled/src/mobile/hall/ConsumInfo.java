package mobile.hall;

/**
 * 消费记录
 * 
 * @author y
 *
 */
public class ConsumInfo {
	MobileCard card = new MobileCard();
	String cardNumber;//手机号码

	String type;// 消费类型
	double consumData;// 消费数据（流量/短信）

	public ConsumInfo() {

	}

	public ConsumInfo(String cardNumber, String type, double consumData) {
		this.cardNumber = cardNumber;
		this.type = type;
		this.consumData = consumData;
	}
}
