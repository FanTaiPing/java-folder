package object_1;
/**
 * 学校测试类
 * @author HXZY
 *
 */

public class TestSchool {

	public static void main(String[] args) {
		/*
		 *创建对象语法 
		 *类名 对象名 = new 类名()
		 */
		School school = new School();
		/*
		 * 调用类里面的方法
		 * 对象名.方法名()
		 */
		//属性未赋值前调用
		school.showCenter();
		
		
		//属性赋值后调用
		/**
		 * 给类里的属性赋值
		 * 对象名.属性名 = 值；
		 */
		school.name = "昆明华信智原";
		school.classroom = 12;
		school.address = "昆明市官渡区吴井路193号";
		
		//再次调用显示方法
		school.showCenter();
	}
}
