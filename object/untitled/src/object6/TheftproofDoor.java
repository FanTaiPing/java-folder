package object6;

public class TheftproofDoor implements Door, Lock {

	@Override
	public void lockup() {
		// TODO Auto-generated method stub
		System.out.println("插入钥匙，向左旋转钥匙三圈，锁上了，拔出钥匙。");
	}

	@Override
	public void openlock() {
		// TODO Auto-generated method stub
		System.out.println("插入钥匙，向右旋转三圈，锁打开了，拔出钥匙。");
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("用力推，门开了。");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("轻轻拉门，门关上了。");
	}

}
