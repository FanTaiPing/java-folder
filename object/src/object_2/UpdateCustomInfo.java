package object_2;

/**
 * 客户对象类
 * 
 * @author HXZY
 *
 */
public class UpdateCustomInfo {
	String name;
	int age;
	boolean idCard;

	/**
	 * 显示客户信息
	 */
	public void showCustomInfo() {
		System.out.println(name + "\t" + age + "\t" + idCard);
	}
}
