package inter;

public class Private implements Soldier {

	@Override
	public void eat() {
		System.out.println("�㸮�� ��� ��� �����Ļ縦 �Ѵ�.");
	}

	@Override
	public void sleep() {
		System.out.println("��������� ��ô�̴� ��� ����.");
	}

	@Override
	public void work() {
		System.out.println("������ ������ ����� ���� ������ ��� ����.");
	}

	@Override
	public void salute() {
		System.out.println("��!!!!!!!!!!!!!!!!!��!!!!!!!!!!!!!!!!");
	}

}
