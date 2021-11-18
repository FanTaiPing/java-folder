package object7;

/**
 * 动物父类
 * 
 * @author y
 *
 */
public abstract class Animal {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

//叫的方法
	public abstract void shout();
}
