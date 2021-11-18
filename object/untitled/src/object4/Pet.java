package object4;

/**
 * 宠物类 （父类）
 * @author HXZY
 *
 */
public class Pet {
private String name;
private int age;

public Pet() {
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
 * setAge(设置年龄)
 * @param age
 */
public void setAge(int age) {
	this.age = age;
}


/**
 * getAge (获得年龄)
 * @return
 */
public int getAge() {
	return age;
}
	
	
}
