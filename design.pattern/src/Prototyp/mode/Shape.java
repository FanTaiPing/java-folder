package Prototyp.mode;

/**
 * 创建一个实现了Cloneable接口的抽象类
 * 
 * @author y shape 形状
 */
public abstract class Shape implements Cloneable {
	private String id;
	String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//绘画 的抽象方法
	public abstract void draw();

	/**
	 * 重写clone()方法为public类型，并调用Object类的本地clone()方法。
	 */
	public Shape clone() throws CloneNotSupportedException {
		Shape clone = null;
		try {
			// 将父类的clone()方法转为子类clone()方法 强制转型
			clone = (Shape) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
