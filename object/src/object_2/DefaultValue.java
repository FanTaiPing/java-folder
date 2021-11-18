package object_2;

public class DefaultValue {

	//属性
	byte one;
	char two; //等同于char two = '\u0000' 
	short three;
	int four;
	long five;
	float six;
	double seven;
	boolean eight; 
	
	
	public static void main(String[] args) {
		DefaultValue dv= new DefaultValue();
		System.out.println("byte的初始值是：" + dv.one);
		System.out.println("two的初始值是：" + dv.two);
		System.out.println("three的初始值是：" + dv.three);
		System.out.println("four的初始值是：" + dv.four);
		System.out.println("five的初始值是：" + dv.five);
		System.out.println("six的初始值是：" + dv.six);
		System.out.println("seven的初始值是：" + dv.seven);
		System.out.println("eight的初始值是：" + dv.eight);


		
	}
}
