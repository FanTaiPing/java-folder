package object2;

import java.util.Scanner;

/**
 *  测试对象数组
 * @author HXZY
 *
 */

public class TestStuObject {
public static void main(String[] args) {
//	Scanner input = new Scanner(System.in);
	//创建两个学生类对象
	StudentScore zhangStu = new StudentScore();
	zhangStu.id = 11;
	zhangStu.name = "张璟";
	zhangStu.age = 20;
	zhangStu.score = 88;
	
	StudentScore fanStu = new StudentScore();
	fanStu.id = 12;
	fanStu.name = "范太平";
	fanStu.age = 20;
	fanStu.score = 90;
	
	/**
	 * 可直接调用showInfo显示方法
	 */
//	zhangStu.showInfo();
//	fanStu.showInfo();

	//创建学生业务类对象
	StudentBiz sb = new StudentBiz();
	
	//接收语句,给每一个学生类对象属性赋值并调用业务类方法存入对象数组
	sb.addStu(zhangStu);
	sb.addStu(fanStu);
	
	//调用对象数组里每一个学生类对象的显示信息方法
	System.out.println("本班学生列表：");
	sb.stus[0].showInfo();
	sb.stus[1].showInfo();

}
}
