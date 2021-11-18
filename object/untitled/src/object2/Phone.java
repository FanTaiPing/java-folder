package object2;

import java.util.Scanner;

/**
 * 编写手机类，可以下载音乐，可以播放音乐，可以充电
 * 
 * @author HXZY
 *
 */
public class Phone {
	
	String brand;

	/*
	 * 音乐下载方法
	 */
	public String download() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要下载的音乐：");
		String music = input.next();
		return music;
	}

	/*
	 * 音乐播放方法 
	 */
	public String play() {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要播放的音乐：");
		String music = input.next();
		return music;
	}

	 
	/*
	 * 充电方法
	 */
	public String charge() {
		Cell cell = new Cell();
     String charge = cell.getElectricity();
		return charge;
	}
	
	public void showPhone() {
		System.out.println("下载的音乐为：" + download());
		System.out.println("播放的音乐为：" + play());
		System.out.println("手机电池电量过低，正在充电中！");
	}

}
