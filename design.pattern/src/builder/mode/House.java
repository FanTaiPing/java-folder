package builder.mode;

/**
 * 公共的父类 建房子提取出来的属性
 * 
 * @author y
 *
 */
public class House {
	private String base;// 地基
	private String wall;// 墙
	private String roof;// 屋顶

	public void setBsae(String base) {
		this.base = base;
	}

	public String getBase() {
		return base;
	}

	public void setWall(String wall) {
		this.wall = wall;
	}

	public String getWall() {
		return wall;
	}

	public void setRoof(String roof) {
		this.roof = roof;
	}

	public String getRoof() {
		return roof;
	}
}
