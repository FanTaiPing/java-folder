package object_6;

public class TestHandset {
	public static void show() {
//		Handset comHandset = new CommonHandset();
		CommonHandset comHandset = new CommonHandset();
		comHandset.setBrand("G502c");
		comHandset.setType("索尼爱立信");
		comHandset.print();
		System.out.println(comHandset.play("开始播放音乐《热雪》"));
		comHandset.info();
		comHandset.voice();

		System.out.println(" ");
		AptitudeHandset aptHandset = new AptitudeHandset();
		aptHandset.setBrand("HTC");
		aptHandset.setType("I9100");
		aptHandset.print();
		aptHandset.networkCoon();
		System.out.println(aptHandset.play("开始播放视屏《小时代》"));
		aptHandset.takePicture();
		aptHandset.sendInfo();
		aptHandset.call();
	}

	public static void main(String[] args) {
		show();
	}

}
