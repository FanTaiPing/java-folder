package object3;

public class Penguin {
	private String name;
	private String sex;
	private String hobby;
	private int age;
	private int love;

	// 静态属性（类属性） static
	static final String SEX_MALE = "雄";
	static final String SEX_FAMALE = "雌";

	// 静态代码块
//	static {
//		System.out.println("我是静态代码块！ 我只会调用一次，在构造方法之前调用");
//	}

	/**
	 * 无参构造方法（构造器） 语法 访问修饰符 类名（）{
	 * 
	 * }
	 */

//	public Penguin() {
//		name = "喵喵";
//		sex = "Q妹";
//		love = 88;
//	}

	/**
	 * 带参构造方法（构造器）
	 * 
	 * @param name
	 * @param sex
	 * @param love
	 */

//	public Penguin(String name, String sex, int love) {
//		this.name = name;// this 代表当前对象的属性，局部变量
//		this.sex = sex;
//		this.love = love;
//	}
	/**
	 * setName（设置姓名）
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getName(获得姓名)
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setAge(设置年龄)
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		if (age <= 0 || age > 100) {
			this.age = 20;
		} else {
			this.age = age;
		}

	}

	/**
	 * getAge(获得年龄)
	 * 
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * setSex(设置性别)
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * getSex(获得性别)
	 * 
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * setLove(设置亲密度)
	 * 
	 * @param love
	 */
	public void setLove(int love) {
		if (love <= 0 || love > 100) {
			this.love = 20;
		} else {
			this.love = love;
		}

	}

	/**
	 * gsetLove(获得亲密度)
	 * 
	 * @param love
	 */
	public int getLove() {
		return love;
	}

	/**
	 * setHobby(设置爱好)
	 * 
	 * @param hobby
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	/**
	 * getHobby(设置爱好)
	 * 
	 * @param hobby
	 */
	public String getHobby() {
		return hobby;
	}

	/**
	 * 显示企鹅信息
	 */
	public void showInfoPenguin() {
		System.out.print("宠物的自白：\n你的名字叫" + getName()+ "，健康值是：" + getHobby() + "，你的年龄是：" + getAge()
				+ "，和主人的亲密度是：" + getLove() + "，爱好是：" + getHobby());
	}

}
