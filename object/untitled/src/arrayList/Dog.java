package arrayList;

/**
 * 狗狗类
 * 
 * @author y
 *
 */
public class Dog {
	private String name;
	private String strain;

	/**
	 * 带参构造方法
	 * 
	 * @param name
	 * @param strain
	 */
	public Dog(String name, String strain) {
		this.name = name;
		this.strain = strain;
	}

	/**
	 * 无参构造方法
	 */
	public Dog() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}

	@Override
	public String toString() {
		return getName() + "\t" + getStrain();
	}
}
