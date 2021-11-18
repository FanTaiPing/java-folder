package object_5;

/**
 * 主人类
 * 
 * @author HXZY
 *
 */
public class Master {

	/**
	 * 父类作为方法参数实现多态
	 * 
	 * @param pet 父类对象
	 */
	public void feed(Pet pet) {
		System.out.println("主人正在喂食：" + pet.eat());
	}

	/**
	 * 父类作为返回值实现多态
	 * 
	 * @param typeId
	 * @return
	 */
	public Pet feed(String typeId) {
		Pet pet = null;
		switch (typeId) {
		case "狗":
			pet = new Dog();
			break;
		case "企鹅":
			pet = new Penguin();
			break;
		case "猫":
			pet = new Cat();
			break;
		}
		return pet;
	}

	/**
	 * 父类作为方法参数实现多态
	 * 
	 * @param pet 父类对象
	 */
	public void play(Pet pet) {
		// 判断是否是狗狗类对象
		if (pet instanceof Dog) {
			//向下转型
			Dog dog  = (Dog)pet;
			dog.catchingFyDisc();
			// 判断是否是企鹅类对象
		} else if (pet instanceof Penguin) {
			//向上转型
			Penguin penguin = new Penguin();
			penguin.swimming();
//			// 向下转型
//			Penguin penguin1 = (Penguin) pet;
//			penguin1.swimming();
			// 判断是否是 猫类对象
		} else if (pet instanceof Cat) {
			// 向下转型
			Cat cat = (Cat)pet;
			cat.catchingMice();
		}
	}
//	Dog dog = new Dog();
//	Penguin penguin = new Penguin();
//	/**
//	 * 喂狗
//	 */
//	public void feedDog() {
//		System.out.println("主人正在给狗狗喂食：" + dog.eat());
//	}
//
//	/**
//	 * 喂企鹅
//	 */
//	public void feedPenguin() {
//		System.out.println("主人正在给企鹅喂食：" + penguin.eat());
//	}
}
