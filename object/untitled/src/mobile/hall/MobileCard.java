package mobile.hall;
/**
 * 嗖嗖移动卡类
 * @author y
 *
 */
public class MobileCard {
private String cardNumber;//卡号
private String userName;//用户名
private String passWard;//密码
private ServicePackage setPackage;//选择的套餐
private double consumAmount ;//消费金额
private double money;//当前余额
private int realTalkTime;//实际月通话时间
private int realSMSCount;//实际月短信条数
private int realFlow;//实际月流量
	
/**
 * 带参构造方法
 * @return
 */
public MobileCard(String cardNumber,String userName,String passWard,ServicePackage setPackage,double money,
		int realTalkTime,int realSMSCont,int realFlow) {
	this.cardNumber = cardNumber;
	this.userName = userName;
	this.passWard = passWard;
	this.setPackage = setPackage;
	//调用每个套餐里面的月资费
	this.consumAmount = setPackage.getPrice();
	this.money = money;
	this.realTalkTime = realTalkTime;
	this.realSMSCount = realSMSCount;
	this.realFlow = realFlow;
}

/**
 * 无参构造方法
 * @return
 */
public MobileCard() {
	
}

/**
 * 获得卡号
 * @return
 */
public String getCardNumber() {
	return cardNumber;
}
/**
 * 设置卡号
 * @return
 */
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}

/**
 * 获得用户名
 * @return
 */
public String getUserName() {
	return userName;
}

/**
 * 设置用户名
 * @param userName
 */
public void setUserName(String userName) {
	this.userName = userName;
}

/**
 * 获得密码
 * @return
 */
public String getPassWard() {
	return passWard;
}

/**
 * 设置密码
 * @param passWard
 */
public void setPassWard(String passWard) {
	this.passWard = passWard;
}

/**
 * 获得套餐服务包
 * @return
 */
public ServicePackage getSetPackage() {
	return setPackage;
}

/**
 * 设置套餐服务包
 * @param setPackage
 */
public void setSetPackage(ServicePackage setPackage) {
	this.setPackage = setPackage;
}

/**
 * 货得消费金额
 * @return
 */
public double getConsumAmount() {
	return consumAmount;
}

/**
 * 设置消费金额
 * @param consumAmount
 */
public void setConsumAmount(double consumAmount) {
	this.consumAmount = consumAmount;
}

/**
 * 获得当前余额
 * @return
 */
public double getMoney() {
	return money;
}

/**
 * 设置当前余额
 * @param money
 */
public void setMoney(double money) {
	this.money = money;
}

/**
 * 获得通话时间
 * @return
 */
public int getRealTalkTime() {
	return realTalkTime;
}

/**
 * 设置通话时间
 * @param realTalkTime
 */
public void setRealTalkTime(int realTalkTime) {
	this.realTalkTime = realTalkTime;
}

/**
 * 获得短信条数
 * @return
 */
public int getRealSMSCount() {
	return realSMSCount;
}

/**
 * 设置短信条数
 * @param realSMSCount
 */
public void setRealSMSCount(int realSMSCount) {
	this.realSMSCount = realSMSCount;
}

/**
 * 获得流量
 * @return
 */
public int getRealFlow() {
	return realFlow;
}

/**
 * 设置流量
 * @param realFlow
 */
public void setRealFlow(int realFlow) {
	this.realFlow = realFlow;
}

/**
 * 显示卡信息
 */ 
public void showMsg() {
	System.out.println("卡号：" + getCardNumber() + "用户名：" + getUserName() + "当前余额：" + getMoney());
}
}
