package day09;

public class MethodTest {
	//f(x) = 2x+1
	//��, x�� �����̴�.
	//�޼ҵ�� ����
	int f(int x){
		int result = 2*x+1;
		return result;
	}
	//�� ������ ������ �޼ҵ�(�Ҽ��� 2°�ڸ�����)
	String div(int num1, int num2) {
		String result = "";
		if(num2 != 0) {
			result = String.format("%.2f", (double)num1 / num2);
		}else {
			result = "error";
		}
		return result;
	}
	
	public static void main(String[] args) {
		MethodTest m = new MethodTest();
		System.out.println(m.div(10, 0));
	}
}





