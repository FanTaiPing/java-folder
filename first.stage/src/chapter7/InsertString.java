package chapter7;

import java.util.Arrays;
import java.util.Scanner;

public class InsertString {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String list[] = { "a", "b", "c", "e", "f", "p", "u", "z", ""};
		System.out.print("原字符序列：");
		for (int j = 0; j < list.length; j++) {
			System.out.print(list[j] + "\t" );
		}
		System.out.println(" ");
		System.out.print("请输入新增字符：");
		String insertString = input.next();
		list[list.length-1] = insertString;
		Arrays.sort(list);
		for (int i = 0; i < list.length; i++) {
			if (insertString.equals(list[i])) {
				System.out.println("插入字符的下标是：" + (i+1));
			}
		}
		System.out.print("插入后字符是：");
		for (int j = 0; j < list.length; j++) {
			System.out.print("\t" + list[j]);
		}
	

	}
}
