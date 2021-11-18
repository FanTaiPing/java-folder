package mobile.hall;//移动业务
/**
 * 移动大厅 父类
 * @author y
 *
 */
public abstract class ServicePackage {
	 double price;//月资费
	
//	/**
//	 * 带参构造方法
//	 * @param price
//	 */
//	public ServicePackage(double price) {
//		this.price = price;
//	}
//	/**
//	 * 无参构造方法
//	 */
//	public ServicePackage() {
//		
//	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 抽象方法 显示套餐信息
	 */
	public abstract void showInfo();
		
}
