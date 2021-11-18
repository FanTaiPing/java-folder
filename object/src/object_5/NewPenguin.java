package object_5;
/**
 * 企鹅类
 * @author HXZY
 *
 */
public class NewPenguin extends NewPet{
/**
 * 企鹅游泳
 * @param health
 * @param love
 */
public void swimming(int health,int love) {
	System.out.println("主人正在和企鹅玩游泳游戏");
	health = health -10;
	System.out.println("企鹅的健康值为：" + health);
	love = love +5;
	System.out.println("企鹅与主人的亲密度为：" + love);
}
	
	/**
	 * 方法重写
	 */
	public void play(int health,int love) {
		swimming(health,love);
	}
}
