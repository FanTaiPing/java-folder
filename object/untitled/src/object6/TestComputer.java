package object6;

public class TestComputer {
	public static void main(String[] args) {
		Computer cpu = new Computer();
		System.out.println("计算机的信息如下：" + "\n" + cpu.hardDish() + "\n" + cpu.ems() + "\n" + cpu.cpu());
	}
}
