package mobile.hall;

/**
 * 网虫套餐
 * 
 * @author y
 *
 */
public class NetPackage extends ServicePackage implements NetService {
	int flow;

	/**
	 * 带参构造方法
	 * 
	 * @param flow
	 */
	public NetPackage(int flow) {
		super();
		this.flow = flow;
	}

	/**
	 * 无参构造方法,给网虫套餐一个初始值
	 */
	public NetPackage() {
		this.flow = 1024 * 3;
		super.price = 68;
	}

	/**
	 * 父类显示套餐信息方法重写
	 */
	public void showInfo() {
		System.out.println("网虫套餐：上网流量为：" + this.flow + "MB/月,资费为：" + super.price + "/月");
	}
/**
 * 上网
 */
	@Override
	public int netPlay(int flow, MobileCard card) throws Exception {
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

}
