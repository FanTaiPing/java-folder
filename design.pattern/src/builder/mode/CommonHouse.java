package builder.mode;
/**
 * 建造普通的房子
 * @author y
 *
 */
public class CommonHouse extends House implements HouseBuilder{
	House house = new House();
	@Override
	public void builderBase() {
	System.out.println("普通的房子打地基");	
	}

	@Override
	public void builderWall() {
		System.out.println("普通的房子砌墙");			
	}

	@Override
	public void builderRoof() {
		System.out.println("普通的房子盖房顶");	
	}

	@Override
	public House creatHouse() {

		return house;
	}

}

