package builder.mode;

/**
 * 创建一个指挥者指定流程，返回产品
 * 
 * @author y
 *
 */
public class HouseDirector {
	private HouseBuilder houseBuilder;

	/**
	 * 方法一：通过构造方法传入houseBuilder参数
	 * 
	 * @param houseBuilder
	 */
	public HouseDirector(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	/**
	 * 方法二：通过setter方法传入houseBuilder参数
	 * 
	 * @param houseBuilder
	 */
	public void setHouseBuilder(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	public House construHouse() {
		houseBuilder.builderBase();
		houseBuilder.builderWall();
		houseBuilder.builderRoof();
		return houseBuilder.creatHouse();
	}
}
