package day18;

public class Refrigerator implements Electronics {

	@Override
	public void on() {
		System.out.println("스위치를 올려서 켜기");
	}

	@Override
	public void off() {
		System.out.println("스위치를 내려서 끄기");
	}
	
}
