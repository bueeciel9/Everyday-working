package day07;

import java.util.Scanner;

public class ArTest {
	public static void main(String[] args) {
		// ����
		// ������ ȫ���� ������
		// ��� ������� ����������� ����Ѵ�.
		int[] arIncome = new int[3];
		String[] arBranch = { "������", "ȫ����", "������" };
		Scanner sc = new Scanner(System.in);
		boolean check = false;

		int total = 0;
		double avg = 0.0;

		for (int i = 0; i < arIncome.length; i++) {
			System.out.println(arBranch[i] + " ����� �Է�(���� : ����)");
			arIncome[i] = sc.nextInt();
			// �� ������� ���ϴ� ����
			total += arIncome[i];
		}
		avg = Double.parseDouble(String.format("%.2f", (total + 0.0) / arIncome.length));

		System.out.println("���� �� ����� : " + total + "����");
		System.out.println("���� ��� ����� : " + avg + "����");

		// ��� ����׺��� ���� ������ �μ�Ƽ�� �������� ���
		// (��� ��)
		// ���μ�Ƽ�� �����
		// ������
		// ȫ����
		System.out.println("���μ�Ƽ�� �����");
		for (int i = 0; i < arIncome.length; i++) {
			if (avg < arIncome[i]) {
				System.out.println(arBranch[i]);
				check = true;
			}
		}

		if(!check) {
			System.out.println("�ش���� ����");
		}
		// �μ�Ƽ�� ������ ���ٸ� �ش���� ���� ���
		// ���μ�Ƽ�� �����
		// �ش���� ����
	}
}
