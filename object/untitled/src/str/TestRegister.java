package str;
/**
 * 需求说明
 * 实现会员注册，要求
 * 用户名长度不小于3
 * 密码长度不小于6
 * 注册时两次输入密码必须相同 
 */
import java.util.Scanner;

public class TestRegister {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("***欢迎进入注册系统***");
		while (true) {
			System.out.print("请输入用户名：");
			String root = input.next();
			System.out.print("请输入密码：");
			String passward = input.next();
			if (root.length() < 3 || passward.length() < 6) {
				System.out.println("用户名长度不能小于3，密码长度不能小于6！");
			} else {
				System.out.print("请再次输入密码：");
				String newPassward = input.next();
				if(newPassward.length() < 6) {
					System.out.println("密码长度不能小于6！");
				}
				if (!newPassward.equalsIgnoreCase(passward)) {
					System.out.println("两次输入的密码不相同！");
				} else {
					System.out.println("注册成功！请牢记用户名和密码");
					break;
				}
			}
		}
	}
}
