package day09;

public class MethodTask {
	//1~10���� println()���� ����ϴ� �޼ҵ�
	//1~10������ ���� �����ִ� �޼ҵ�
	//1~n������ ���� println()���� ������ִ� �޼ҵ�
	
	//�̸��� n�� println()���� ����ϴ� �޼ҵ�
	//��� �޼ҵ�
	//���� �ҽ��ڵ尡 ����������.
	//���� �ҽ��ڵ尡 ���������.
	void printName(String name, int n) {
		if(n == 0) {
			return;
		}else {
			System.out.println(name);
			printName(name, --n);
		}
	}
	//Ȧ���� ¦����, ¦���� Ȧ���� �ٲ��ִ� �޼ҵ�
	//�빮�ڸ� �ҹ��ڷ� �������ִ� �޼ҵ�
	//�ѱ��� ������ �������ִ� �޼ҵ�
	
	//5���� ������ �޾Ƽ� �ִ밪�� �ּҰ��� �����ִ� �޼ҵ�
	void getMaxAndMin(int[] arData, int[] result) {
		for(int i=0; i<result.length; i++) {
			result[i] = arData[0];
		}
		for (int i = 1; i < arData.length; i++) {
			if(result[0] < arData[i]) {result[0] = arData[i];}
			if(result[1] > arData[i]) {result[1] = arData[i];}
		}		
	}
	public static void main(String[] args) {
		new MethodTask().printName("�ѵ���", 10);
//		int[] result = new int[2];
//		int[] arData = {4, 2, 1, 7, 8};
//		new MethodTask().getMaxAndMin(arData, result);
//		System.out.println("�ִ밪 : " + result[0]);
//		System.out.println("�ּҰ� : " + result[1]);
		
	}
}











