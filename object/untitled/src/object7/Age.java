package object7;

public class Age {
	private int age;

	/**
	 * 设置年龄
	 * 
	 * @return
	 */
	public void setAge(int age) throws AbnormalAgeException {
		if (age > 0 && age < 100) {
			this.age = age;
		} else {
			throw new AbnormalAgeException("年龄必须要在1-100之间！");
		}

	}

	/**
	 * 获得年龄
	 * 
	 * @return
	 */
	public int getAge() {
		return age;
	}

}
