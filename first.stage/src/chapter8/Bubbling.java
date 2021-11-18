package chapter8;
/**
 * 冒泡排序
 */
import java.util.Scanner;

public class Bubbling {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int scores[] = new int[5];

		System.out.println("请输入5名学员的成绩：");
		
		for(int a=0;a<5;a++) {
			scores[a] = input.nextInt();
		}
		
		for(int i=0;i<scores.length-1;i++) {
			for(int j=0;j<scores.length-i-1;j++) {
				if(scores[j]<scores[j+1]) {
					int temp =scores[j];//定义一个临时变量用于交换,当前面一个数比后面一个数的大时就把两个数位置交换
					scores[j] = scores[j+1];
					scores[j+1] = temp;
				}
			}			
		}
		System.out.print("学员成绩按降序排列为：");
		for(int b=0;b<scores.length;b++) {
			System.out.print(scores[b] + "\t");
		}
	}

}
