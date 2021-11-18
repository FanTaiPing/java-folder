package io.utils;

import java.io.File;

public class PathUtils {
	// 读取文件路径(localhost=获得当前系统默认用户主路径)
	public static String localhost = System.getProperty("user.home");
	// File.separator(通用转义路径符号<win代表\\,mac代表/>)
	// public static String path = localhost + File.separator + "Desktop" +
	// File.separator + "123" + File.separator + "Java.txt";
	public static String path = "D:" + File.separator + "study" + File.separator + "object" + File.separator + "src"
			+ File.separator + "io" + File.separator + "test" + File.separator + "Java2.txt";
	
	public static String outPath = "D:" + File.separator + "study" + File.separator + "object" + File.separator + "src"
			+ File.separator + "io" + File.separator + "test" + File.separator + "Java.txt";
	
	public static String namePath = "D:" + File.separator + "study" + File.separator + "object" + File.separator + "src"
			+ File.separator + "io" + File.separator + "test" + File.separator + "java3.txt";
	
	public static String nameOutPath = "D:" + File.separator + "study" + File.separator + "object" + File.separator
			+ "src" + File.separator + "io" + File.separator + "test" + File.separator + "nameOne1.txt";
	
	public static String picPath = "D:" + File.separator + "study" + File.separator + "object" + File.separator + "src"
			+ File.separator + "io" + File.separator + "test" + File.separator + "picture" + File.separator + "bag.jpeg";
	
	public static String picTwoPath = "D:" + File.separator + "study" + File.separator + "object" + File.separator + "src"
			+ File.separator + "io" + File.separator + "test" + File.separator + "picture" + File.separator + "bag1.jpeg";
	
	public static String classPath = localhost + File.separator + "Desktop" + File.separator + "123" + File.separator
			+ "FileDataInoutStreamTest.class";
	public static String outClassPath = localhost + File.separator + "Desktop" + File.separator + "123" + File.separator
			+ "TestData.class";
}
