package chapter6;
/**
 * threeDivide  100以内被3整除
 * @author HXZY
 *
 */
public class threeDivide {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1;i<=100;i++) {
			if(i % 3 != 0) {
				sum += i;
			}
			
		}
		System.out.println("1-100之间不能被3整除的数之和是：" + sum);
	}

}
