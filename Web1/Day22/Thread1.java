package day22;

public class Thread1 extends Thread{
	String data;

	public Thread1() {}
	
	public Thread1(String data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		//쓰레드 구현
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			try {Thread.sleep(500);} catch (InterruptedException e) {;}
		}
	}
}












