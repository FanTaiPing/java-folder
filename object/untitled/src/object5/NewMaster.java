package object5;

/**
 * 主人类
 * 
 * @author HXZY
 *
 */
public class NewMaster {
	public void play(NewPet pet) {
		// 判断是否是狗狗类对象
		if (pet instanceof NewDog) {
			// 向上转型，子类转父类，自动转型
			NewDog dog = new NewDog();
			dog.catchingFlyDish(100, 50);
		} else if (pet instanceof NewPenguin) {
			// 向下转型，父类转子类，强制转型
			NewPenguin penguin = (NewPenguin) pet;
			penguin.swimming(90, 60);
		}

	}
}
