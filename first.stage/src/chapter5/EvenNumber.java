package chapter5;

/**
 * 计算100以内的偶数之和
 * 
 * @author HXZY
 *
 */
//evennumber  偶数
public class EvenNumber {
	
	//方法一
//	public static void main(String[] args) {
//		int sum = 0;
//		int i = 1;
//		while (i <= 100) {
//			if (i%2 == 0) {
//				sum += i;	
//			}
//			i++;
//		}
//		System.out.print("100以内（包括100）的偶数之和为：" + sum);
//	}

	
	//方法二
	public static void main(String[] args) {
		int i = 0,
		sum = 0;
		while(i <= 100) {
			sum += i;
			i += 2;
		}
		
		System.out.print("100以内（包括100）的偶数之和为：" + sum);
	} 
	
	
}
