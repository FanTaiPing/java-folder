package object7;

/**
 * 子类 猫类
 * 
 * @author y
 *
 */
public class Cat extends Animal implements legNum {
	private int legNum;

	public Cat(String name, int legNum) {
		setName(name);
		this.legNum = legNum;

	}

	public Cat() {

	}

	public void setLegNum(int legNum) throws Exception {
		if (legNum == 4) {
			this.legNum = legNum;
		} else {
			throw new Exception("输入错误！猫有四条腿！");
		}

	}

	public int getLegNum() {
		return legNum;
	}

	/**
	 * 重写叫的方法
	 */
	public void shout() {
		System.out.println("喵喵喵....");
	}

	@Override
	public int getlegNum() {
		return legNum;

	}

}
