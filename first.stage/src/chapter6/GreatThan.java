package chapter6;

public class GreatThan {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1;i<10;i++) {
			sum += i;
			if(sum >20) {
				System.out.println("累加值为:" + sum );
				System.out.print("累加值大于20的当前数为:" + i );
				break;
			}
		}
		
	}

}
