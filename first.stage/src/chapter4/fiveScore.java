package chapter4;

import java.util.Scanner;

public class fiveScore {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		 System.out.print("请输入学生姓名:");
		 String name = input.next();
		 boolean flag = false;
		 double sum = 0;
		 double average;
		 for(int i = 1;i<=5;i++) {
			 System.out.print("请输入第"+ i + "门课程的成绩：");
			 Double score = input.nextDouble();
			 
			 if(score<0) {
				 System.out.println("分数录入错误，请重新进行录入");
//				错误时不进入if里面执行 的标识
				 flag = true;
				 break;
//				 System.exit(0);//强制退出
			 }
			 sum += score;
			
		 }
		 //错误时不进入if里面执行
		 if(!flag) {
			 average = sum/5;
		 System.out.print(name + "的平均分为：" + average);
		 }
		  
		}

}
