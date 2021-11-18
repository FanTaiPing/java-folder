package object_1;

public class Show {
	public static void main(String[] args) {
		Student student = new Student();
		student.showInfo();
		
		
		student.name = "张浩";
		student.age = 20;
		student.team = "java1班";
		student.love = "打游戏";
		student.showInfo();
	}
}