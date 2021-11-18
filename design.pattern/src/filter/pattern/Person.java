package filter.pattern;

/**
 * 人 类
 * 
 * @author y
 *
 */
public class Person {
	private String name;
	private String gender;// 性别
	private String maritalStatus;// 婚姻状况

	public Person(String name, String gender, String maritalStatus) {
		this.name = name;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
	}

	public Person() {

	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}
}
