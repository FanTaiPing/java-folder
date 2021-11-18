package object_3;

public class Dog {
	private String name;
	private int age;
	private int health;
	private int hobby;
	private int love;
	/**
	 * 封装步骤 1.私有属性 2.公有方法(getter/setter方法)
	 */
	/**
	 * setName(设置姓名)
	 * 
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getName(获得姓名)
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setAge()方法，设置年龄
	 * 
	 * @return
	 */
	public void setAge(int age) {
		// 加入年龄小于0或者年龄大于20岁
		if (age <= 0 || age > 20) {
			this.age = 1;
		} else {
			this.age = age;
		}

	}

	/**
	 * getAge()方法，获得年龄
	 * 
	 * @return
	 */

	public int getAge() {
		return age;
	}

	public void setHealth(int health) {
		if (health <= 0 || health > 100) {
			this.health = 60;
		} else {
			this.health = health;
		}

	}

	public int getHealth() {
		return health;
	}

	public void setHobby(int hobby) {
		if (hobby <= 0 || hobby > 100) {
			this.hobby = 80;
		} else {
			this.hobby = hobby;
		}
	}

	public int getHobby() {
		return hobby;
	}
	
	public void setLove(int love) {
		if (love <= 0 || love > 100) {
			this.love = 80;
		} else {
			this.love = love;
		}
	}

	public int getLove() {
		return love;
	}

	public void showInfoDog() {
		System.out.println("宠物的自白：\n你的名字叫：" + getName() + "，健康值是：" + getHealth() + "，你的年龄是：" + getAge() + "，和主人的亲密度是：" + getLove());
	}

}
