package object2;

public class TestLion {
public static void main(String[] args) {
	/*
	 * 创建对象
	 */
	Lion lion = new Lion();
	//给类类里面的属性赋值并调用
	lion.name = "zhangjing";
	lion.color = "yellow";
	String info =lion.showLion();
	System.out.println(info);
	lion.run();
	System.out.println("抢到一个" + lion.grabBall());
}
	
}
