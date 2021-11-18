package object7;

/**
 * 子类 海豚
 * 
 * @author y
 *
 */
public class Dolphin extends Animal implements legNum {
	private int legNum;
	
	public Dolphin(String name,int legNum) {
		setName(name);
		this.legNum = legNum;
	}
	public Dolphin() {
		
	}
	public int getLegNum() {
		return legNum;
	}

	public void setLegNum(int legNum) throws Exception {
		if (legNum == 2) {
			this.legNum = legNum;
		} else {
			throw new Exception("输入错误！海豚没有腿！");
		}
	}



	/**
	 * 重写叫的方法
	 */
	public void shout() {
		System.out.println("海豚音....");
	}

	@Override
	public int getlegNum() {
		return legNum;
	}

}
