package object_2;

public class TestCell {
	public static void main(String[] args) {
		Cell cell = new Cell();
		cell.brand = "南孚";
//		cell.electricity = "20000mA";
		cell.showCell();
		String info = cell.getElectricity();
		System.out.println("可以蓄" + cell.powerStorage());
		System.out.println(info);
		
	}

}
