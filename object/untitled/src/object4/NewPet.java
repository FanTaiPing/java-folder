package object4;
/**
	 * 宠物类 （父类）抽象类
	 * @author HXZY
	 *
	 */
public abstract class NewPet {

	private String name;
	private int health =88;
	private int love = 90;

	public NewPet() {
		System.out.println("我是Pet类的无参构造方法");
	}

	/**
	 * setName (设置姓名)
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getName(获得姓名)
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setAge(设置健康值)
	 * @param age
	 */
	public void setHealth(int health) {
		this.health = health;
	}


	/**
	 * getAge (获得健康值)
	 * @return
	 */
	public int getHealth() {
		return health;
	}
		
	/**
	 * setAge(设置健康值)
	 * @param age
	 */
	public void setLove(int love) {
		this.love = love;
	}


	/**
	 * getAge (获得健康值)
	 * @return
	 */
	public int getLove() {
		return love;
	}
		
	/**
	 * 抽象方法
	 */
	 public abstract void print();

}
