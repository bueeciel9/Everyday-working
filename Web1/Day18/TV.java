package day18;

public class TV implements Electronics{

	@Override
	public void on() {
		System.out.println("리모콘으로 켜기");
	}

	@Override
	public void off() {
		System.out.println("리모콘으로 끄기");
	}
	
}
