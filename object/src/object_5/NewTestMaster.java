package object_5;

/**
 * 测试类
 * 
 * @author HXZY
 *
 */
public class NewTestMaster {
	public static void main(String[] args) {
		NewMaster nema = new NewMaster();
		// 向上转型
		NewPet dog = new NewDog();
		NewPet penguin = new NewPenguin();

		nema.play(dog);
		nema.play(penguin);
	}
}
