package chapter6;

public class JudgeEvevOdd {
public static void main(String[] args) {
	int sum = 0;
	int even;
	int odd;
	for(int i = 1;i<=10;i++) {
		if(i%2!=0) {
			continue;
		}
		sum += i;
	}
	System.out.print("1~10之间的所有偶数和为：" + sum);
	
}
	
}
