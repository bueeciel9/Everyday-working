package day18;

public class TV implements Electronics{

	@Override
	public void on() {
		System.out.println("���������� �ѱ�");
	}

	@Override
	public void off() {
		System.out.println("���������� ����");
	}
	
}
