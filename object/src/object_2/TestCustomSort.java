package object_2;
/**
 * 利用数组存储学生姓名,实现对客户姓名的排序
 * @author HXZY
 *
 */
public class TestCustomSort {
public static void main(String[] args) {
	CustomSort customSort = new CustomSort();
	System.out.println("*******排序前*******");
	//调用显示客户姓名显示方法
	customSort.showCustomSort();
	System.out.println("\n*******排序后*******");
	//调用客户姓名排序方法
	customSort.sortNames(customSort.names);
}
}
