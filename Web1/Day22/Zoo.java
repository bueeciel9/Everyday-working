package zoo;

public class Zoo {
	public static void main(String[] args) {
		//동물 3마리가 동물원에서 울음소리를 낸다.
		//두마리 동물은 동시에 10번 울고
		//남은 동물은 마지막에 10번 운다.
		//멀티 쓰레드로 구현한다(Runnable 사용)
		
		Animal[] animals = { new Animal("어흥"), 
				new Animal("으엉"), new Animal(".$#@#..")};
		
		Thread[] ths = new Thread[animals.length];
		
		for (int i = 0; i < ths.length; i++) {
			ths[i] = new Thread(animals[i]);
		}
		
		ths[0].start();
		ths[1].start();
		
		try {
			ths[0].join();
			ths[1].join();
		} catch (InterruptedException e) {;}
		
		ths[2].start();
	}
}







