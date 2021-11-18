package builder.mode;

public class TestHouseBuild {
	public static void main(String args[]) {
		// 建普通的房子
		CommonHouse commonHouse = new CommonHouse();
		// 建高楼
		HighHouse highHouse = new HighHouse();
		// 创建房子指挥者
		// 方法一:通过setter方法赋值传参
        //	HouseDirector houseDirector = new HouseDirector();
		//	houseDirector.setHouseBuilder(highHouse);
		// 方法二：通过构造方法赋值传参
		HouseDirector houseDirector = new HouseDirector(commonHouse);
		// 完成盖房子，返回产品（房子）
		houseDirector.construHouse();
	}
}
