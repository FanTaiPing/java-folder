package chapter5;

public class Reverse { 
	public static void main(String[] args) {
		int val = 123456;
		 int reverse;
		 System.out.print("反转后的整数是：");
		do {
			reverse = val%10;
			System.out.print(reverse);
			val = val/10;
		}while(val != 0);
		
	} 

}
