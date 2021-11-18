package object_6;

public class TestUDisk {
	public static void main(String[] args) {
		UsbInterface usb = new UDisk();
		UsbInterface usb2 = new UMouse();
		usb.service();
		usb2.service();
	}
}
