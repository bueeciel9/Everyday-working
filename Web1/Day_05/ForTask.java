package day05;

import java.util.Scanner;

public class ForTask {
	public static void main(String[] args) {
		// ������ �Է� �ޱ�(���� ������ ���)
		// ����� �� ���Ѵ�.
		// �Է� ��) 5
		// ��� ��) 5
		// 7
//		String name = "�ѵ���";
//		System.out.println(name.length());
//		System.out.println("�ѵ���".length());
//		
//		Scanner sc = new Scanner(System.in);
//		
//		sc.nextInt();
//		new Scanner(System.in).nextInt();

//		System.out.print("���� : ");
//		int num = new Scanner(System.in).nextInt();
//		System.out.println(num++);
//		System.out.println(++num);
		/*
		 * ��� ������ for���� �� ���� ����Ѵ�. �ʱⰪ�� 0���� �����Ѵ�. �������� 1�� �����Ѵ�.
		 */
		// 100~1 ���
//		for (int i = 0; i < 100; i++) {
//			System.out.println(100 - i);
//		}
		// 1~100���� �� ¦���� ���(50���ݺ�)
//		for (int i = 0; i < 50; i++) {
//			System.out.println((i+1)*2);
//		}
		// 1~10������ �� ���
//		int result = 0;
//		for (int i = 0; i < 10; i++) {
////			result = result + i + 1;
//			result += i + 1;
//			//result = 0 + 1
//			//result = (0+1) + 2
//			//result = (0+1+2) + 3
//		}
//		System.out.println(result);
		// 1~n������ �� ���
//		Scanner sc = new Scanner(System.in);
//		int num = 0;
//		int result = 0;
//
//		System.out.print("���� : ");
//		num = sc.nextInt();
//
//		if (num > 1) {
//			for (int i = 0; i < num; i++) {
//				result += i + 1;
//			}
//			System.out.println(result);
//		} else {
//			System.out.println("1���� ū ���� �Է��ϼ���");
//		}

		// A~F���� ���
		// ���� + ���� = ����
//		for (int i = 0; i < 6; i++) {
//			System.out.println((char)('A' + i));
//		}
//		for(char i = 'A'; i < 'G'; i++) {
//			System.out.println(i);
//		}
		// A~F���� �� C�����ϰ� ���(5���ݺ�)
//		int temp = 0;
//		for (int i = 0; i < 5; i++) {
//			temp = i;
//			if(i > 1) {
//				//i�� ������Ű�� �ݺ� Ƚ���� �پ���
//				//(�ʱⰪ�� ������ ���� �ݺ�Ƚ���� ����)
//				//���� i���� temp�� ��� temp�� ������Ų��.
//				temp++;
//			}
//			System.out.println((char)(temp + 65));
//		}

		// aBcDeF.....Z ���
//		for (int i = 0; i < 26; i++) {
//			System.out.println((char)(i % 2 == 0 ? 'a' + i : 'A' + i));
//		}
		// 0 1 2 0 1 2 0 1 2���
		// x % y : 0 ~ y-1
//		for(int i = 0; i < 9; i++) {
//			System.out.print(i % 3 + " ");
//		}
//		System.out.println();
		// ������ ��� (1��~9��)(������ �� ���� ���)
		for (int i = 0; i < 81; i++) {
//			i / 9 = 0~8 : 0, 9~17 : 1	+1
//			i % 9 = 0~8						+1
			System.out.printf("%d*%d=%d\n", i/9+1, i%9+1, (i/9+1)*(i%9+1));
		}
	}
}










