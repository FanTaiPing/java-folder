package mobile.hall;

/**
 * 超人套餐
 * 
 * @author y
 *
 */
public class SuperPackage extends ServicePackage implements CallService, SendService, NetService {
	int talkTime;
	int flow;
	int smsCount;
	/**
	 * 带参构造方法
	 * 
	 * @param talkTime
	 * @param flow
	 * @param smsCount
	 */
	public SuperPackage(int talkTime, int flow, int smsCount) {
		super();
		this.talkTime = talkTime;
		this.flow = flow;
		this.smsCount = smsCount;
	}

	/**
	 * 无参构造方法 给超人套餐属性一个初始值
	 */
	public SuperPackage() {
		this.talkTime = 200;
		this.flow = 1024;
		this.smsCount = 50;
		super.price = 78;
	}

	/**
	 * 父类显示套餐信息方法重写
	 */
	public void showInfo() {
		System.out.println("超人套餐：通话时间是：" + this.talkTime + "分钟/月，上网流量为：" + this.flow + "MB/月，短信条数为：" + this.smsCount + "月/条，资费为:"
				+ super.price + "元/月");
	}
/**
 * 上网流量
 */
	@Override
	public int netPlay(int flow, MobileCard card) throws Exception{
		int temp = flow;
		for (int i = 0; i < flow; i++) {
			// 每月固定流量 - 实际用的流量 >= 1，还可以使用1MB流量
			if (this.flow - card.getRealFlow() >= 1) {
				// 每使用1MB流量之后，实际使用流量数 + 1
				card.setRealFlow(card.getRealFlow() + 1);
				// 账户余额 >= 0.1元，还可以使用0.1元的流量 1MB
			} else if (card.getMoney() >= 0.1) {
				// 每使用1MB流量之后，实际使用流量数 + 1
				card.setRealFlow(card.getRealFlow() + 1);
				// 每使用1MB流量之后，账户余额减少0.1元
				card.setMoney(card.getMoney() - 0.1);
				// 每使用1MB流量之后，消费金额增加0.1元
				card.setConsumAmount(card.getConsumAmount() + 0.1);
			} else {
				temp = i;
				throw new Exception("已使用流量" + i + "MB，您的余额不足，请充值后再使用！");
			}
		}
		return temp;
	}
/**
 * 发送短信
 */
	@Override
	public int sendMessage(int count, MobileCard card) throws Exception{
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
	public int call(int minCount, MobileCard card) throws Exception{
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
