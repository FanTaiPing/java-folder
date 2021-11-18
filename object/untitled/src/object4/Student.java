package object4;

/**
 * 学生类
 * 
 * @author HXZY
 *
 */
public class Student {
	private String name;
	private String id;
	private int age;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	/**
	 * 重写toString()
	 */
	public String toString() {
		return id + " \t" + name + "\t" + age;
	}

	public boolean equals(Object obj) {
		// 1.判断参数是否为空
		if (obj == null) {
			return false;
		}
		// 2.判断当前对象内存地址是否和参数相等
		if (this == obj) {
			return true;
		}
		/**
		 * 3.instanceof是否是同一个对象 做一个强转，再判断对象里的属性值是否相等
		 */
		if (obj instanceof Student) {
			Student stu = (Student) obj;
			if (stu.id == null || "".equals(stu.id)) {
				return false;
			}
			if (stu.name == null || "".equals(stu.name)) {
				return false;
			}
			// 判断对象里的属性值不为空并且当前对象属性值等于参数属性值
			if (stu.id.equals(this.id) && (stu.name.equals(this.name))) {		
			return true;
			}
		}
		return false;
	}
	
	/**
	 * 重写hashCode()方法
	 */
	public int hashCode() {
		int result = 17;
		result = 31*result + (id == null ? 0:id.hashCode());
		result = 31*result + (name == null ? 0: name.hashCode());
		return result;
	}

}
