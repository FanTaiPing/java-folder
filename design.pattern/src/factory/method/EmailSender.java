package factory.method;

public class EmailSender implements Sender{
	@Override
	public void Send() {
System.out.println("this is emailsender!");	
	}
}
