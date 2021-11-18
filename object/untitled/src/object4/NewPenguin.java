package object4;

public class NewPenguin extends NewPet{
	private String sex;
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}

	/**
	 * print()方法重写
	 */
	public void print() {
		System.out.println("宠物的自白：\n你的名字叫：" + getName() + "，健康值是：" + getHealth() + "，和主人的亲密度是：" + getLove() + "，我的性别是：" + getSex());
	}
}
