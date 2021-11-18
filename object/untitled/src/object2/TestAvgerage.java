package object2;

public class TestAvgerage {
	public static void main(String[] args) {
		Average average = new Average();
		average.avg();
		System.out.print("三门课的平均分为：" + average.showAvg());
	}

}
