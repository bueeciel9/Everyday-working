package day03;

import javax.swing.JOptionPane;

public class Dialog {
	public static void main(String[] args) {
//		JOptionPane.showMessageDialog(null, "�ȳ�");
//		String name = JOptionPane.showInputDialog("�̸��� �Է��ϼ���");
//		JOptionPane.showMessageDialog(null, name + "�� ȯ���մϴ�.");
		
		//�� ������ �Է¹ް� ��� ������ ���
		//�� : ���� / ����
		//������ : ���� % ���� (�� : 10 % 3 == 1)
		//��ȭ���� ���
		
		int num1 = 0;
		int num2 = 0;
		int value = 0;
		int rest = 0;
		
		String n1Msg = "ù��° ������ �Է��ϼ���";
		String n2Msg = "�ι�° ������ �Է��ϼ���";
		String result = "";
		
		num1 = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		num2 = Integer.parseInt(JOptionPane.showInputDialog(n2Msg));
		
		value = num1 / num2;
		rest = num1 % num2;
		
		result = String.format("[���]\n%d/%d=%d\n%d%%%d=%d",
				num1, num2, value, num1, num2, rest);
		
		//[���]
		//10 / 3 = 3\n
		//10 % 3 = 1\n

		JOptionPane.showMessageDialog(null, result);
		
	}
}







