package builder.mode;

/**
 * 建造者接口
 * 
 * @author y
 *
 */
public interface HouseBuilder {
	void builderBase();// 建地基的方法

	void builderWall();// 建墙的方法

	void builderRoof();// 建屋顶的方法
	
	House creatHouse();//创建返回的对象 房子
}
