package day18;

public class Refrigerator implements Electronics {

	@Override
	public void on() {
		System.out.println("����ġ�� �÷��� �ѱ�");
	}

	@Override
	public void off() {
		System.out.println("����ġ�� ������ ����");
	}
	
}
