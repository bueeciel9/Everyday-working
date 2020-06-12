package day22;

public class ThreadTest {
	public static void main(String[] args) {
		//up casting
		Runnable t1 = new Thread2("!");
		Runnable t2 = new Thread2("?");
		
		//start()로 스케줄링을 하기 위하여
		//Runnable객체를 생성자로 전달한다.
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		
		//멀티 쓰레드(2개의 쓰레드)
		//전달받은 Runnable 객체에 있는 run()을 스케줄링 해준다.
		th1.start();
		th2.start();
		
		try {
			//가장 먼저 작업하기 위해 join()을 사용한다.
			th1.join();
			th2.join();
		} catch (InterruptedException e) {;}
		
		//join()을 사용하지 않은 main쓰레드는 위의 작업이 모두 완료된 후
		//실행된다.
		System.out.println("main메소드 종료");
		
//		Thread1 t1 = new Thread1("★");
//		Thread1 t2 = new Thread1("♥");
//
//		t1.start();
//		t2.start();
		
//		t1.run();
//		t2.run();
	}
}
