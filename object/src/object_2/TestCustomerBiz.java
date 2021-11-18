package object_2;

import java.util.Scanner;

/**
 * 客户姓名添加和显示
 * 
 * @author HXZY
 *
 */
public class TestCustomerBiz {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CustomerBiz customerBiz = new CustomerBiz();
		String judge = "y";
		while ("y".equals(judge)) {
				System.out.print("请输入学生的姓名：");
				String name = input.next();
				customerBiz.addNames(name);
				System.out.print("继续输入吗？（y/n）:");
				judge = input.next();
			
		}
		customerBiz.showNames();
	}
}
