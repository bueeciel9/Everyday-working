package day03;

import java.util.Scanner;

public class InputTask {
	public static void main(String[] args) {
		//�� ������ �Է¹ް�(next()���)
		//�� ������ �� ���
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		String msg = "";
		
		String n1Msg = "ù��° ���� : ";
		String n2Msg = "�ι�° ���� : ";
		
		System.out.print(n1Msg);
//		num1 = Integer.parseInt(sc.next());
		num1 = sc.nextInt();
		
		System.out.print(n2Msg);
//		num2 = Integer.parseInt(sc.next());
		num2 = sc.nextInt();
		
		result = num1 + num2;
		//String.format("���Ĺ���", ��); : ���ڿ� ��
		msg = String.format("%d+%d=%d", num1, num2, result);
		System.out.println(msg);
//		System.out.printf("%d+%d=%d\n",num1, num2, num1 + num2);
		
	}
}









