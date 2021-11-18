package str;

import java.util.Scanner;

public class TestBuffer {
	/**
	 * 逢三位插入逗号
	 * @param sb
	 */
	public void insertComma() {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入一串数字：");
		String num = input.next();
		StringBuffer sb = new StringBuffer(num);
		int index = num.length();
		//将一个数字字符串转换成逗号分隔的数字串，即从右边开始每三个数字用逗号分隔开
		for(;index>=0;index-=3) {
			//判断字符串长度不大于3，不插入逗号
			if(index<=3) {
				System.out.print(sb.toString());
				break;
			}
			//字符串长度满足三位，加入逗号
			if(sb.length() > 3) {
				sb.insert(index-3, ",");
			}
		}
	}
	
	public static void main(String[] args) {
		//创建StringBuffer对象并调用

		new TestBuffer().insertComma();	
	}
}
