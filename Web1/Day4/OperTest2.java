package day04;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class OperTest2 {
	public static void main(String[] args) {
		//�� ���� �Է�
		Scanner sc = new Scanner(System.in);
		String msg = "-9999�� �񱳴���� �� �� �����ϴ�.";
		String n1Msg = "ù��° ������ �Է��ϼ���";
		String n2Msg = "�ι�° ������ �Է��ϼ��� ";
		
		String resultMsg = "";
		
		int num1 = 0, num2 = 0, result = 0;
		
		num1 = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		num2 = Integer.parseInt(JOptionPane.showInputDialog(n2Msg));
		
//		System.out.println(msg);
//		System.out.print(n1Msg);
//		num1 = sc.nextInt();
		
//		System.out.print(n2Msg);
//		num2 = sc.nextInt();
		
		//ū ���� ���
		//��������� resultMsg���� num1, num2, �� ���� �����ϴ�. �� �� �� ���� ���� ����.
		resultMsg = num1 > num2 ? "ū �� : " + num1 :
			//�� ���� ���ų� num2�� ũ�ٸ� false�κ��� �� �������� �´�.
			//�� �� �� ���׿����ڸ� ����ؼ� �Ǵ����ش�.
			num1 == num2 ? "�� ���� �����ϴ�." : "ū �� : " + num2;
		
//		result = num1 > num2 ? num1 :
//			num1 == num2 ? -9999 : num2;
//		
//		resultMsg = result == -9999 ? "�� ���� �����ϴ�." : "ū �� : " + result;
		
//		System.out.println(resultMsg);
		JOptionPane.showMessageDialog(null, resultMsg);
	}
}





