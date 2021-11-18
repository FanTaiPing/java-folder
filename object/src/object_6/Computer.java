package object_6;

public class Computer implements Cpu,Ems,HardDisk{

	@Override
	public String hardDish() {
		// TODO Auto-generated method stub
		return "CPU的品牌是：intel,主频是：3.8GHz";
	}

	@Override
	public String ems() {
		// TODO Auto-generated method stub
		return "硬盘容量是：3000GB";
	}

	@Override
	public String cpu() {
		// TODO Auto-generated method stub
		return "内存容量是：4GB";
	}

}
