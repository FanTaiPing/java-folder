package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 排序
 * @author HXZY
 *
 */
public class Sort {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int score[] = new int [5];
		System.out.println("请输入5位同学的成绩：");
		for(int i=0;i<score.length;i++) {
			score[i] = input.nextInt();
		}
		Arrays.sort(score);
		System.out.print("输入的5位同学的成绩升序排列为：");
		for(int i=0;i<score.length;i++) {			
			System.out.print(score[i]+"\t");
			
		}
		System.out.println(" ");
		System.out.print("输入的5位同学的成绩降序排列为：");
		for(int i=score.length-1;i>=0;i--) {
			System.out.print(score[i] +"\t");
		}
		
	}

}
