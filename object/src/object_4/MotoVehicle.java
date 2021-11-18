package object_4;
/**
 * 机动车抽象类
 * @author HXZY
 *
 */
public abstract class MotoVehicle {	
	private String brond;//品牌
	private String color;
	private double mileage; //里程
	private int days;
	private int rent;//租金
	private double rentPrice;//租金总价
	
	
	public void setBrond(String brond) {
		this.brond = brond;
	}
	public String getBrond() {
		return brond;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public double getMileage() {
		return mileage;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getDays() {
		return days;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getRent() {
		return rent;
	}
	/**
	 * 租赁方法
	 */
	public void calcRent() {
		rentPrice = getRent() * getDays();
		System.out.println("顾客您好！你需要支付的租赁费用是" + rentPrice + "元"); 
	}
	/**
	 * 抽象方法
	 */
	public abstract void rent();

}
