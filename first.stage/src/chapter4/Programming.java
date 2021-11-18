package chapter4;

import java.util.Scanner;

public class Programming {
//	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
//		System.out.print("请输入名次：");
//		int ranking = input.nextInt();
//		if(ranking == 1) {
//			System.out.println("参加麻省理工大学组织的1个月夏令营");
//		}else if(ranking == 2) {
//			System.out.println("奖励惠普笔记本一部");
//		}else if(ranking == 3) {
//			System.out.println("奖励移动硬盘一个");
//		}else if(ranking > 3) {
//			System.out.println("没有任何奖励");
//		}
//		
//		
//	}
//

	/**
	 * switch做法
	 **/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入名次：");
		int ranking = input.nextInt();
		switch(ranking) {
		case 1:
			System.out.print("参加麻省理工大学组织的1个月夏令营");
			break;
		case 2:
			System.out.print("奖励惠普笔记本一部");
			break;
		case 3:
			System.out.print("奖励移动硬盘一个");
			break;
		case 4:
			System.out.print("没有任何奖励");
			break;
		default:
			System.out.print("滚");
			break;
		}

	}
}