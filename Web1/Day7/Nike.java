package day07;

import java.util.Scanner;

public class Nike {
	public static void main(String[] args) {
		// �Ϲ���, Ű����
		// ������, ȫ����, ������
		int[][] arrIncome = new int[2][3];

		int length = 0;
		
		String[] arAgeName = { "�Ϲ���", "Ű����" };
		String[] arBranchName = { "������", "ȫ����", "������" };

		// ���ɺ� �� �����
		int[] arAgeTotal = new int[2];
		// ���ɺ� ��� �����
		double[] arAgeAvg = new double[2];

		// ������ �� �����
		int[] arBranchTotal = new int[3];
		// ������ ��� �����
		double[] arBranchAvg = new double[3];

		// ����Ű �� �����
		int total = 0;
		// ����Ű ��� �����
		double avg = 0.0;

		boolean check = false;
		
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < arrIncome.length; i++) {
			length += arrIncome[i].length;
			for (int j = 0; j < arrIncome[i].length; j++) {
				System.out.println(arBranchName[j] + arAgeName[i] + " ����� �Է�(���� : ����)");
				arrIncome[i][j] = sc.nextInt();
				arAgeTotal[i] += arrIncome[i][j];
				arBranchTotal[j] += arrIncome[i][j];
				total += arrIncome[i][j];
			}
			arAgeAvg[i] = (double) arAgeTotal[i] / arrIncome[i].length;
		}

		for (int i = 0; i < arBranchAvg.length; i++) {
			arBranchAvg[i] = (double)arBranchTotal[i] / arrIncome.length;
		}
		
		avg = (double)total / length;
		
		//������ ��, ��� ����� ���
		//���ɺ� ��, ��� ����� ���
		//����Ű ��, ��� ����� ���
		
		System.out.println("���μ�Ƽ�� �����");
		for (int i = 0; i < arrIncome.length; i++) {
			for (int j = 0; j < arrIncome[i].length; j++) {
				if (avg < arrIncome[i][j]) {
					System.out.println(arBranchName[j] + arAgeName[i]);
					check = true;
				}
			}
		}

		if(!check) {
			System.out.println("�ش���� ����");
		}
	}
}




