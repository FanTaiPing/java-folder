package object5;
/**
 * 抽象机车类（父类）
 * @author HXZY
 *
 */
public abstract class MotoVehicle {
private String no;
private String type;
private String brind;

	
public void setNo(String no) {
	this.no = no;
}
public String getNo() {
	return no;
}
public void setType(String type) {
	this.type = type;
}
public String getType() {
	return type;
}
public void setBrind(String brind) {
	this.brind = brind;
}
public String getBrind() {
	return brind;
}
	
	/**
	 * 抽象方法
	 */
public abstract int calcRent(int days);
}
