package str;

import java.util.Scanner;

public class TestStrCount {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入一个字符串：");
		String str = input.next();
		String strs = str;
		System.out.print("请输入要查找的字符：");
		String findStr = input.next();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.indexOf(findStr) != -1) {
				count++;
			}
			str = str.substring(str.indexOf(findStr) + 1);
		}
		System.out.println(strs + "中包含" + count + "个" + findStr);
	}

}
