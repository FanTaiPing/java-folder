package object_4;

public final class Car extends MotoVehicle{
private String type;
private String carNo;//车牌号
//private int carRent;//租金
/**
 * car构造方法
 * @param type
 */
//public Car(String carNo,String type) {
//	this.carNo = carNo;
//	this.type = type;
//	
//}



public void setType(String type) {
	this.type = type;
}
public String getType() {
	return type;
}
public void setCarNo(String carNo) {
	 this.carNo = carNo;
}
public String getCarNo() {
	return carNo;
}

/**
 * print()方法重写
 */
public void rent() {

}
}
