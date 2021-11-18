package str;

public class TestUpper {
	public static void main(String[] args) {
		String str = "Hello World";
		// 转换全大写英文字母
		System.out.println(str.toUpperCase());
		// 转换为全小写英文字母
		System.out.println(str.toLowerCase());
		// 比较值时忽略英文大小写
		System.out.println("hello worlD".equalsIgnoreCase(str));

		
		
		String word = "Hello,      ";
		// 去掉字符串前后的空格
		word = word.trim();
		String s = word.concat("小鱼儿!");
		int index1 = s.indexOf(',');
		int index2 = s.indexOf('!');
		System.out.println(s.substring(index1 + 1, index2));
	}
}
