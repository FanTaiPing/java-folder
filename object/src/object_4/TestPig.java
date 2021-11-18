package object_4;

public class TestPig {
	public static void main(String[] args) {
//		Pig pig = new Pig();
//		pig.setName("佩奇");
//		pig.setAge(14);
//		pig.setColor("粉色");
//		pig.showInfo();

		whitePig wp = new whitePig();// 这里输出的结果不是继承过来的，构造方法不能被继承，是创建的对象自动调用构造方法里面的输出语句
		System.out.println(wp.toString());
		whitePig wpTwo = new whitePig();
		System.out.println(wp == wpTwo);
		System.out.println(wp.equals(wpTwo));
		
	}
}
