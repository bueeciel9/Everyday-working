package day22;

public class ThreadTest {
	public static void main(String[] args) {
		//up casting
		Runnable t1 = new Thread2("!");
		Runnable t2 = new Thread2("?");
		
		//start()�� �����ٸ��� �ϱ� ���Ͽ�
		//Runnable��ü�� �����ڷ� �����Ѵ�.
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		
		//��Ƽ ������(2���� ������)
		//���޹��� Runnable ��ü�� �ִ� run()�� �����ٸ� ���ش�.
		th1.start();
		th2.start();
		
		try {
			//���� ���� �۾��ϱ� ���� join()�� ����Ѵ�.
			th1.join();
			th2.join();
		} catch (InterruptedException e) {;}
		
		//join()�� ������� ���� main������� ���� �۾��� ��� �Ϸ�� ��
		//����ȴ�.
		System.out.println("main�޼ҵ� ����");
		
//		Thread1 t1 = new Thread1("��");
//		Thread1 t2 = new Thread1("��");
//
//		t1.start();
//		t2.start();
		
//		t1.run();
//		t2.run();
	}
}
