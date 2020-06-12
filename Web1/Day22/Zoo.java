package zoo;

public class Zoo {
	public static void main(String[] args) {
		//���� 3������ ���������� �����Ҹ��� ����.
		//�θ��� ������ ���ÿ� 10�� ���
		//���� ������ �������� 10�� ���.
		//��Ƽ ������� �����Ѵ�(Runnable ���)
		
		Animal[] animals = { new Animal("����"), 
				new Animal("����"), new Animal(".$#@#..")};
		
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







