package object_7;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * try-catch处理
 * 
 * @author y
 *
 */
public class TestTwo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// try可能发生异常的代码放到try这个代码块里
		try {
			// 运行时异常
//		throw new RuntimeException(new NullPointerException());

//		System.out.println("请输入被除数：");
//		int numOne = input.nextInt();
//		System.out.print("请输入除数：");
//		int numTwo = input.nextInt();
//		System.out.print(String.format("%d / %d = %d",numOne,numTwo,numOne / numTwo));
//		System.out.print("感谢使用本程序！");
			// 异常处理的catch块，发生异常时进入匹配的catch块
			// 算术异常处理（除数不能为零）
		} catch (ArithmeticException e) {
//		e.printStackTrace();
			System.err.print("除数不能为零....");
			// 输入不匹配异常
		} catch (InputMismatchException e) {
			System.err.print("输入的必须是数字....");
		} catch (Exception e) {
			System.err.print("我到这了....");
		}

		/**
		 * 写多重catch块，顺序一定是子类在最前（按子类到父类顺序，从小到大写）
		 */
	}
}
