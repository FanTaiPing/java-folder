package chapter7;

import java.util.Arrays;

public class CharacterSort {
	public static void main(String[] args) {
		String arrayString[] = {"a","c","u","b","e","p","f","z"};
		System.out.print("原字符序列：");
		for(int i =0;i<arrayString.length;i++) {
			System.out.print(arrayString[i]);
		}
		Arrays.sort(arrayString);
		System.out.println(" ");
		System.out.print("升序排序后：");
		for(int i =0;i<arrayString.length;i++) {
			System.out.print(arrayString[i]);
		}
		System.out.println(" ");
		System.out.print("逆序输出：");
		for(int i =arrayString.length-1;i>0;i--) {
			System.out.print(arrayString[i]);
		}
	}

}
