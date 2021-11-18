package str;

/**
 * 注册用户，密码长度不小于6 String.length()
 */
import java.util.Scanner;

public class TestStr {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入用户名：");
		String root = input.next();
		System.out.print("请输入密码：");
		String passward = input.next();
		// 字符串长度方法
		if (passward.length() < 6) {
			System.out.print("密码长度不能小于6位");
		} else {
			System.out.print("注册成功！");
		}
	}
}
