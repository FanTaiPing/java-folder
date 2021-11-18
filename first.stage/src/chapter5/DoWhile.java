package chapter5;

import java.util.Scanner;

public class DoWhile {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String judge; 
		do {
			System.out.println("上机编写程序");
			System.out.print("是否合格？y/n:");
			judge = input.next(); 
			
		}while(!"y".equals(judge));
		System.out.print("已合格，程序结束！");
		
	}

}
