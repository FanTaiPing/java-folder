package object4;

/**
 * 员工类
 * 
 * @author HXZY
 *
 */
public class Staff {
	private String name;
	private String empleno;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmpleno(String empleno) {
		this.empleno = empleno;
	}

	public String getEmpleno() {
		return empleno;
	}

	/**
	 * 重写toString()方法
	 */
	public String toString() {
		return name + "\t" + empleno;
	}

	/**
	 * 重写equals（）方法
	 */
	public boolean equals(Object obj) {
		// 判断参数是否为空
		if (obj == null) {
			return false;
		}
//判断当前对象内存地址是否和参数相等
		if (this == obj) {
			return true;
		}
//用instanceof判断是否是同一个对象，做一个强制转换，在判断他们的属性值是否相等
		if (obj instanceof Staff) {
			Staff staff = (Staff) obj;
			// 判断对象里的属性值不为空并且当前对象属性值等于参数属性值
			if (staff.name == null || "".equals(staff.name)) {
				return false;
			}
			if (staff.empleno == null || "".equals(staff.empleno)) {
				return false;
			}

			if (staff.name.equals(this.name) && staff.empleno.equals(this.empleno)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * 重写hasCode()方法
	 */
	public int hashCode() {
		int result = 17;
		result = 31 * result + (name == null ? 0 : hashCode());
		result = 31 * result + (empleno == null ? 0 : hashCode());
		return result;

	}

}
