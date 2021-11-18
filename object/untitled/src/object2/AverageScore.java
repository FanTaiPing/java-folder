package object2;

import java.util.Scanner;

public class AverageScore {
	Scanner input = new Scanner(System.in);
	int scores[] = new int[5];
/*
 * 将输入的成绩存入数组中
 */
	public void saveScore(int score[]) {
		for (int i = 0; i < score.length; i++) {
			if (score[i] == 0) {
				score[i] = input.nextInt();
			}
		}
	}
	/*
	 * 算平均值
	 */
	public double avg(int[] score) {
		double sum =0;
		double avg=0;
		for(int i= 0;i<score.length;i++) {
			sum +=score[i];
		}
		avg = sum/score.length;
		return avg;
	}

/**
 * 求最大值
 */
	public double max(int[] score) {
		 double maxScore = score[0];
		for(int i=0;i<score.length;i++) {			
			if(score[0] < score[i]) {
				maxScore = score[i];
			}
			
		}
		return maxScore;
	}
}
