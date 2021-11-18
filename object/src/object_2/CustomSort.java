package object_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 定义一个客户姓名排序类
 * 
 * @author HXZY
 *
 */
public class CustomSort {
	Scanner input = new Scanner(System.in);
	String[] names = { "Tom", "Jack", "Merry", "Smith", "Sunny" };

	/**
	 * 定义客户姓名排序方法
	 * 
	 * @param name 姓名
	 */
	public void sortNames(String[] name) {
		Arrays.sort(name);
		showCustomSort();
	}

	/**
	 * 打印数组中的客户姓名
	 */
	public void showCustomSort() {
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + "\t");
		}

	}

}
