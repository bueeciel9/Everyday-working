package day04;

import java.util.Scanner;

public class OperTask {
	public static void main(String[] args) {
		//�Է¹��� ���� �������� �Ǽ����� �Ǵ� �� ����ϱ�(���� ������)
		//���� �Է� : 
		String numMsg = "���� �Է� : ";
		double num = 0.0;
		Scanner sc = new Scanner(System.in);
		String msg = "";
		
		System.out.print(numMsg);
		num = sc.nextDouble();
		
		msg = (num - (int)num == 0 ? (int)num + "��(��) �����Դϴ�." :
			num + "��(��) �Ǽ��Դϴ�.");
//		msg = num + (num - (int)num == 0 ? "��(��) �����Դϴ�." : "��(��) �Ǽ��Դϴ�.");
		System.out.println(msg);
	}
}
