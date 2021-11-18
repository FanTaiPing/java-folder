package object_2;

import java.util.Scanner;

public class Account {
	Scanner input = new Scanner(System.in);
	double balance = 0;//给余额一个初始值
	double deposit;//存款
	double reduceMoney;//取款

	/**
	 * 存款方法
	 */
	public double deposit(double dep) {
		if(dep <= 0){ //输入的存款金额不能为负或0，不可存款（input接收的实参deposit传给形参dep）
			System.out.println("存款金额不能为负或0，请输入正确的存款金额");
			showAccount();
//			dep = input.nextDouble();
		}
			balance += dep;
			System.out.println("存款成功！");
			System.out.println("当前余额为：" + balance);
		return balance;
	}

	/**
	 * 取款方法 
	 */
	public double reduceMoney(double reMoney) {
		if (reMoney > balance) {   //input接收的取款金额大于余额，不可取款（输入的实参reduceMoney传给形参reMoney）
			System.out.println("您的余额不足！请重新输入");
			showAccount();
//			reMoney = input.nextDouble();
		}
		balance -= reMoney;
		System.out.println("取款成功！");
		System.out.println("当前余额为：" + balance);
		return balance;
	}

	/**
	 * 显示存取款菜单业务
	 */
	public void showAccount() {
		//利用while循环实现重复存取款
		while (true) {
			System.out.println("1.存款" + "\t" + "2.取款" + "\t" + "0.退出");
			System.out.print("请选择你需要办理的业务：");
			int num = input.nextInt();
			switch (num) {
			case 1:
				System.out.print("请输入存款金额：");
				double deposit = input.nextDouble();
				//调用存款方法
				deposit(deposit);
				break;
			case 2:
				System.out.print("请输入取款金额：");
				double reduceMoney = input.nextDouble();
				//调用取款方法
				reduceMoney(reduceMoney);
				break;
			case 0:
				System.out.print("谢谢使用！");
				System.exit(0);
				break;
			default:
				break;
			}
		}

	}
}
