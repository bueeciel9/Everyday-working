package zoo;

public class Animal implements Runnable {
	String sound;
	
	public Animal() {}
	
	public Animal(String sound) {
		super();
		this.sound = sound;
	}
	
	//ÀÚ¿ø
	public void makeSomeNoise() {
		for (int i = 0; i < 10; i++) {
			System.out.println(sound);
			try {Thread.sleep(500);} catch (InterruptedException e) {;}
		}
	}
	
	@Override
	public void run() {
		makeSomeNoise();
	}

}
