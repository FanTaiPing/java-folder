package builder.mode;

/**
 * 建高楼
 * 
 * @author y
 *
 */
public class HighHouse extends House implements HouseBuilder {
	House house = new House();

	@Override
	public void builderBase() {
		System.out.println("高楼打地基");
	}

	@Override
	public void builderWall() {
		System.out.println("高楼砌墙");
	}

	@Override
	public void builderRoof() {
		System.out.println("高楼盖房顶");
	}

	@Override
	public House creatHouse() {

		return house;
	}
}
