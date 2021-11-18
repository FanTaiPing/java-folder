package mobile.hall;

/**
 * 话痨套餐
 * 
 * @author y
 *
 */
public class TalkPackage extends ServicePackage implements CallService, SendService {
	int talkTime;
	int smsCount;

	public TalkPackage(int talkTime, int smsCount) {
		super();
		this.talkTime = talkTime;
		this.smsCount = smsCount;
	}

	/**
	 * 给话痨套餐属性一个初始值
	 */
	public TalkPackage() {
		this.talkTime = 500;
		this.smsCount = 30;
		super.price = 58.0;
	}

	/**
	 * 父类的显示套餐信息方法重写
	 */
	public void showInfo() {
		System.out.println("话痨套餐：通话时长为：" + this.talkTime + "分钟/月，短信条数为：" + this.smsCount + "条/月，资费为:" + this.price + "/月");
	}

	/**
	 * 发送短信
	 */
	@Override
	public int sendMessage(int count, MobileCard card) throws Exception {
		int temp = count;
		for (int i = 0; i < count; i++) {
			// 每月固定短信条数-实际消费短信条数>=1
			if (this.smsCount - card.getRealSMSCount() >= 1) {
//		实际消费短信条数加一
				card.setRealSMSCount(card.getRealSMSCount() + 1);
				// 账户余额>=0.1,还能够付一条短信的费用
			} else if (card.getMoney() >= 0.1) {
				// 实际消费短信条数加一
				card.setRealSMSCount(card.getRealSMSCount() + 1);
				// 循环一次，账户余额减0.1(一条短信的钱)
				card.setMoney(card.getMoney() - 0.1);
				// 循环一次，消费金额加0.1
				card.setConsumAmount(card.getConsumAmount() + 0.1);
			} else {
				temp = i;
				throw new Exception("已发送短信" + i + "条，您的余额不足，请充值后再使用！");
			}
		}
		return temp;
	}

	/**
	 * 打电话
	 */
	@Override
	public int call(int minCount, MobileCard card) throws Exception {
		int temp = minCount;
		for (int i = 0; i < minCount; i++) {
			// 每月固定通话时间-实际通话时间>=1
			if (this.talkTime - card.getRealTalkTime() >= 1) {
				// 实际通话时间加一
				card.setRealTalkTime(card.getRealTalkTime() + 1);

				// 账户余额>=0.2,还能够付一分钟的通话费用
			} else if (card.getMoney() >= 0.2) {
				// 实际通话时间加一
				card.setRealTalkTime(card.getRealTalkTime() + 1);

				// 循环一次，账户余额减0.2(一分总通话的钱)
				card.setMoney(card.getMoney() - 0.2);
				// 循环一次，消费金额加0.2
				card.setConsumAmount(card.getConsumAmount() + 0.2);
			} else {
				temp = i;
				throw new Exception("已通话" + i + "分钟，您的余额不足，请充值后再使用！");
			}
		}
		return temp;
	}
}
