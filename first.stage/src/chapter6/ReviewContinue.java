package chapter6;

public class ReviewContinue {
	public static void main(String[] args) {
		int i = 0, j = 0;
		for (; i < 7; i++) {
			if (j > 4) {
				System.out.println("**");			
				continue;
			}
			System.out.println("*");
			j++;
		}
	}
}
