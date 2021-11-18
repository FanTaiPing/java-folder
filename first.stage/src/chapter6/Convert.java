package chapter6;
/**
 * 强制转换和自动转换
 */
public class Convert {
	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 2;
		//5/2取余
		int a = num1 % num2;
		//5/2=2 (int类型，强制去掉小数点后面的位数，像下取整，不会四舍五入)
		int b = num1 / num2;
		System.out.println(num1 + "%" + num2 + "=" + a);
		System.out.println(num1 + "/" + num2 + "=" + b);
		//给num1自身加1
		num1++;
		//给num2自身减1
		num2--;
		//把num1++之后的值再赋给num1
		System.out.println("num1=" + num1);
		//把num2--之后的值再赋给num2
		System.out.println("num2=" + num2);
	}
}
