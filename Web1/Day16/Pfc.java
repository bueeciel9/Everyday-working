package inter;

public class Pfc implements Soldier{

	@Override
	public void eat() {
		System.out.println("���� ���ǰ� ���� ������ ������ ���� �Ļ��Ѵ�.");
	}

	@Override
	public void sleep() {
		System.out.println("�� �ڴٰ� ��� ����.");
	}

	@Override
	public void work() {
		System.out.println("������ ���ϸ� ������� ����.");
	}

	@Override
	public void salute() {
		System.out.println("��!��!");
	}
}
