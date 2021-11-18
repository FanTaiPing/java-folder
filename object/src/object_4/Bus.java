package object_4;

public final class Bus extends MotoVehicle {
	private int seatCount;
	private String busNo;
//	private int busRent;// 租金

	/**
	 * bus构造方法
	 */
//	public Bus(String busNo, int seatCount) {
//		this.busNo = busNo;
//		this.seatCount = seatCount;

//	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public int getSeatCount() {
		return seatCount;
	}


	/**
	 * print()方法重写
	 */
	public void rent() {

	}
}
