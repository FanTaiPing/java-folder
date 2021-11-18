package chapter8;
/**
 * 多个班级多个学员成绩打印
 */
import java.util.Scanner;

public class ForDoubleScore {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int classNum[] = new int[3];
		double score[] = new double[5];
		double average[] = new double[3];
		
		for (int i = 0; i < classNum.length; i++) {
			double sum = 0;
			System.out.println("请输入第" + (i + 1) + "个班级的成绩：");
			for (int j = 0; j < score.length; j++) {
				System.out.print("第" + (j + 1) + "个学员的成绩：");
				score[j] = input.nextDouble();
				sum += score[j];
			}
			average[i] = sum /score.length;
			System.out.println("第" + (i + 1) + "个班级参赛学员的平均分是：" + average[i]);
		}
	}

}
