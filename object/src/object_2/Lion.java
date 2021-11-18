package object_2;

public class Lion {
	/*
	 * 定义类的属性
	 */
String name;
String color;

/*
 * 奔跑 方法
 */
public void run() {
	System.out.print(name +"小狮子正在以0.1米每秒的速度向前奔跑");
}
	/*
	 * 获得颜色 方法
	 */
public String getColor() {
	return color;
}
/*
 * 抢球
 */
public String grabBall() {
	String ball = "球";
	return ball;
}
/*
 * 显示信息 方法
 */
public String showLion() {
	return "这是一个" + getColor() +"的小狮子";
}




}
