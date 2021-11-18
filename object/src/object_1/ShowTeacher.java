package object_1;

public class ShowTeacher {
public static void main(String[] args) {
	/*
	 * 创建一个teacher对象
	 */
	Teacher teacher = new Teacher();
	//调用老师信息显示方法
	teacher.showInfo();
	 
	//给对象属性赋值并调用
	teacher.name = "王老师";
	teacher.major = "计算机";
	teacher.teach = "java编程";
	teacher.teachAge = "10年";
	teacher.showInfo();
}

}
