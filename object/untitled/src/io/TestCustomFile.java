package io;

import java.io.File;

import io.utils.PathUtils;

public class TestCustomFile {
	public static void main(String[] args) {
		System.out.println(PathUtils.outPath);
		// 创建文件对象
		File file = new File(PathUtils.outPath);
		File fileTwo = new File(PathUtils.path);
		CustomFile cf = new CustomFile();

		
		System.out.println(" ");
		
		
		// 调用相关方法
		cf.createrFile(file);
//		cf.deleteFile(file);
		cf.showFile(file);
		System.out.println(" ");
		cf.showFile(fileTwo);
	}
}
