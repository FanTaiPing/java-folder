package object_7;

public class Person {
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) throws Exception {
		if ("男".equals(sex) || "女".equals(sex)) {
			this.sex = sex;
		} else {
			throw new Exception("性别必须是男或者女！");
		}

	}
}
