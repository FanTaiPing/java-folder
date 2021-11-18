package object_4;

public class NewDog extends NewPet{
private String strain;

public void setStrain(String strain) {
	this.strain = strain;
}
public String getStrain() {
	return strain;
}

/**
 * print()方法重写
 */
public void print() {
	System.out.println("宠物的自白：\n你的名字叫：" + getName() + "，健康值是：" + getHealth() + "，和主人的亲密度是：" + getLove() + "品种是：" + getStrain());
}
}
