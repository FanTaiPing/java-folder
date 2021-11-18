package object7;

/***
 * 员工类
 * 
 * @author y
 *
 */
public class Employee {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws AbnormalAgeException {
		if (age < 0 || age >= 100) {
			// 抛出异常
			throw new AbnormalAgeException("年龄不正常，请联系管理员！");
		} else {
			this.age = age;
		}

	}

}
