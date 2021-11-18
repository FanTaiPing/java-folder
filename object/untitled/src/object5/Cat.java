package object5;
/**
 * 猫类
 * @author HXZY
 *
 */
public class Cat extends Pet {
	public String eat() {
		return "猫正在吃饭";
	}
	/**
	 * 猫捉老鼠
	 */
	public void catchingMice() {
		System.out.println("猫正在捉老鼠");
	}

}
