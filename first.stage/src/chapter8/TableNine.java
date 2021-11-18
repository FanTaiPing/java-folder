package chapter8;
/**
 * 九九乘法表 打印
 */
public class TableNine {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <=i; j++) {
				System.out.print(j + "*" + i + "=" + (i*j));
				System.out.print("\t");
			}
			for (int a = 1; a <=i; a++) {
				System.out.print("   ");
			}
			System.out.println();
		}	
	}
}
