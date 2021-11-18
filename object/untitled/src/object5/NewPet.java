package object5;
/**
 * 父类   抽象宠物类
 * @author HXZY
 *
 */
public abstract class NewPet {
	private String name;
	private int health;
	private int love;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHealth() {
		return health;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public int getLove() {
		return love;
	}
	
	
	/**
	 * 玩耍  抽象方法
	 */
public abstract void play(int health,int love);
	
}
