package object7;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class TestFour {
	// 通过反射创建Log4j对象并设置成静态属性
	private static Logger logger = Logger.getLogger(TestFour.class);

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("请输入被除数：");
			int numOne = input.nextInt();
			logger.debug("输入被除数：" + numOne);
			System.out.print("请输入除数：");
			int numTwo = input.nextInt();
			logger.debug("输入除数：" + numTwo);
			System.out.print(String.format("%d / %d = %d", numOne, numTwo, numOne / numTwo));
			logger.debug("输出运算结果：" + numOne + "/" + numTwo + "/" + numOne / numTwo);
			System.out.print("感谢使用本程序！");
			//输入不为整数
		} catch (InputMismatchException e) {
			System.err.print("出现错误:被除数和除数必须是整数，除数不能为零！");
			logger.error("出现错误:被除数和除数必须是整数，除数不能为零！");
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.err.print("出现错误:被除数和除数必须是整数，除数不能为零！");
			logger.warn("出现错误:被除数和除数必须是整数，除数不能为零！");
			e.printStackTrace();
		}
	}

}
