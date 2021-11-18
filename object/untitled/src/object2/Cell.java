package object2;

/**
 * 编写电池类（Cell）：具有品牌属性，可以续电,编写测试类（TestCell）
 * 
 * @author HXZY
 *
 */
public class Cell {
	String brand;// 品牌
	

	public String powerStorage() {
		String electric = "电";// 电
		return electric;
	}

	public String getElectricity() {
		String electricity = "20000mA";// 电量
		return "可续电量为：" + electricity;
	}

	public void showCell() {
		System.out.println("这是一节" + brand + "电池");
	}

}
