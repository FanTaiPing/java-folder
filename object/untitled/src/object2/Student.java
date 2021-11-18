package object2;
/**
 * 在保存了多个学生姓名的数组中，指定查找区间，查找某个学生姓名并显示是否查找成功 
 * 设计方法，通过传递三个参数（开始位置、结束位置、查找的姓名）来实现
 * @author HXZY
 *
 */
import java.util.Scanner;

public class Student {
//	String[] names = new String[30];// 存储学生姓名的数组
	String[] names = {"小诸葛刘能","尼古拉斯赵四","才子宋子峰","刘首付王大拿"};
	Scanner input = new Scanner(System.in);

//增加学生姓名
	public void addName(String name) {
//
//		for (int i = 0; i < 6; i++) {
//			System.out.print("请输入学生的姓名：");
//			name = input.next();
//			names[i] =names[i+1];
//		}
	}

	/*
	 * 显示全部学生的姓名
	 */
	public void showNames() {
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}
	/**
	 * 带三个参数的搜索姓名方法
	 * @param start  下标从哪开始
	 * @param end    下标从哪结束
	 * @param name   查找的姓名
	 * @return true or false 
	 */
	
	public boolean searchName(int start,int end,String name) {
		boolean find = false;//是否找到标识
		//开始不能小于零或者大于数组的最大下标
		if(start <0 || start >=names.length-1) {
			start =0;
		}
		//结束不能大于数组的最大下标
		if (end > names.length-1) {
			end = names.length-1;
		}
		//在指定区间数组中，查找姓名
		for (int i = start;i< end;i++) {
			if(names[i].equals(name)) {
				find = true;
				break; 
				
			}
			
		}
		
		return find;
	}
}
