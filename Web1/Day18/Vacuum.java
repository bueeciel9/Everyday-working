package day18;

public class Vacuum implements Electronics {

	@Override
	public void on() {
		System.out.println("버튼을 눌러서 켜기");
	}

	@Override
	public void off() {
		System.out.println("버튼을 눌러서 끄기");
	}

}
