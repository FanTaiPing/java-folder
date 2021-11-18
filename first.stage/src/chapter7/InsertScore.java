package chapter7;

import java.util.Arrays;
import java.util.Scanner;

public class InsertScore {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int score[] = { 99, 85, 82, 63, 60,0 };
		int index = 0;
		System.out.print("请输入新增成绩：");
		int insertScore = input.nextInt();
		for (int i = 0; i < score.length; i++) {
			if (insertScore >score[i]) {
				index = i;// 找到新元素插入位置
				break;
			}
		}
		for (int j = score.length - 1; j > index; j--) {
			score[j] = score[j - 1];// 元素后移
		}
		score[index] = insertScore;// 新元素放在index位置
		Arrays.sort(score);
		System.out.println("插入成绩的下标是：" + index);
		System.out.print("插入后成绩是：");
		for (int j = score.length-1; j >=0 ; j--) {
			System.out.print("\t" + score[j]);
		}

	}

}
