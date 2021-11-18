package object_5;

public class NewDog extends NewPet {
	private String strain;

	public void setStrain(String strain) {
		this.strain = strain;// 品种
	}

	public String getStrain() {
		return strain;
	}

	/**
	 * 狗玩飞盘
	 * 
	 * @param health
	 * @param love
	 */
	public void catchingFlyDish(int health, int love) {
		System.out.println("主人正在和狗狗玩接飞盘游戏");
		health = health - 10;
		System.out.println("狗狗的健康值为：" + health);
		love = love + 5;
		System.out.println("狗狗与主人的亲密度为：" + love);
	}

	/**
	 * 玩耍方法重写
	 */
	public void play(int health, int love) {
		catchingFlyDish(health, love);
	}
}
