package exception;

public class ExcTask {
	public static void main(String[] args) {

		try {
			System.out.println(10 / 0);
		} catch (Exception e) {;}
		System.out.println("�ݵ�� ��µǾ�� �ϴ� ����");
		
		//5ĭ �迭�� 6���� ���� ���� ��
		//try~catch������ ���� �޽��� ���
//		int[] arData = new int[5];
//		try {
////			arData[5] = 10;
//			for (int i = 0; i < arData.length+1; i++) {
//				arData[i] = i+1;
//			}
//		} catch (Exception e) {
//			System.out.println("�ε��� �ʰ�");
//		}
	}
}
