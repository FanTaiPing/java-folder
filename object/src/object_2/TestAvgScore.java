package object_2;

public class TestAvgScore {
	public static void main(String[] args) {

		/**
		 * (当数组定义在测试类中时，下面调用的属性名就是scores，如果数组定义在类文件中时，
		 * 下面调用时也是调用scores,只是需要使用对象名.属性名)
		 * 注意传实参时不是调用方法中定义的参数 ，而是传一开始定义的属性，
		 * 为了好区分，一般不要将实参名和形参名定义了一致
		 */
//		int scores[] = new int[5];
		AverageScore averageScore = new AverageScore();
		System.out.println("请输入五名参赛者的成绩：");
//		averageScore.saveScore(scores);
		averageScore.saveScore(averageScore.scores);
//		double average = averageScore.avg(scores);
		double average = averageScore.avg(averageScore.scores);
		System.out.println("平均成绩：" + average);
//		System.out.print("最高成绩：" + averageScore.max(scores));
		System.out.print("最高成绩：" + averageScore.max(averageScore.scores));
	}
}
