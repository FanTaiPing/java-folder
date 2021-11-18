package object7;

/**
 * 子类 鸭子
 * 
 * @author y
 *
 */
public class Duck extends Animal implements legNum {
	private int legNum;

	public Duck(String name, int legNum) {
		setName(name);
		this.legNum = legNum;

	}

	public void setLegNum(int legNum) throws Exception {
		if (legNum == 2) {
			this.legNum = legNum;
		} else {
			throw new Exception("输入错误！鸭子只有两条腿！");
		}
	}

	public int getLegNum() {
		return legNum;
	}

	/**
	 * 重写叫的方法
	 */
	public void shout() {
		System.out.println("嘎嘎嘎....");
	}

	@Override
	public int getlegNum() {
		return legNum;
	}

}
