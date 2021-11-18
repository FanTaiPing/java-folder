package object2;

public class TestPhone {
public static void main (String [] args) {
	Phone phone = new Phone();
	phone.showPhone();
	System.out.println("剩余可充电量为：" + phone.charge());
}	

}
