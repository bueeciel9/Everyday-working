package day07;

import java.util.Scanner;

public class ArTask {
	public static void main(String[] args) {
		/* ���� */
		// 1, 2, 3 �� 3ĭ �迭�� �ֱ�
//		int[] arData = new int[3];
////		System.out.println(arData[0]);
////		System.out.println(arData[1]);
////		System.out.println(arData[2]);
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i+1;
//		}
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		// 3, 2, 1 �� 3ĭ �迭�� �ֱ�

		/* �ʱ� */
		// 100~1���� �迭�� �ְ� ���(100-i)
		// 1~100���� �� ¦���� �迭�� �ְ� ���((i+1)*2)
		// 1~10���� �迭�� �ְ� �� �� ���
//		int[] arData = new int[10];
//		int total = 0;
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i + 1;
//			total += arData[i];
//		}
//		System.out.println(total);

		/* �߱� */
		// A~F���� �迭�� �ְ� ���
//		char a = 10;
//		char[] arData = new char[6];
//		
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = (char)(i + 65);
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		// A~F���� �� E�����ϰ� �迭�� ���� �� ���
//		char[] arData = new char[5];
//		int temp = 0;
//		for (int i = 0; i < arData.length; i++) {
//			temp = i;
//			if(i == arData.length-1) {
//				temp++;
//			}
//			arData[i] = (char)(temp + 65);
////			arData[i] = i == arData.length - 1 ? (char)(i + 66) : (char)(i + 65);
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		
		// 5���� ������ �Է¹ް� �ִ밪�� �ּҰ� ����ϱ�
//		Scanner sc = new Scanner(System.in);
//		int max = 0, min = 0;
//		
//		System.out.println("5�� ���� �Է�");
//		int[] arData = new int[5];
//		for (int i = 0; i < arData.length; i++) {
//			System.out.printf("%d��° ���� : ", i+1);
//			arData[i] = sc.nextInt();
//		}
//		
//		max = arData[0];
//		min = arData[0];
//		
//		for (int i = 0; i < arData.length; i++) {
//			if(max < arData[i]) {max = arData[i];}
//			if(min > arData[i]) {min = arData[i];}
//		}
//		System.out.println("�ִ밪 : " + max);
//		System.out.println("�ּҰ� : " + min);
		
		
		/* ��� */
		// ���ڿ��� �Է¹ް�(�ѱ� ����) �ҹ��ڴ� �빮�ڷ� �����ؼ� ���
//		Scanner sc = new Scanner(System.in);
//		String str = "";
//		String result = "";
//		
//		System.out.print("���ڿ�(�ѱ۾ȵ�) : ");
//		
//		str = sc.next().toUpperCase();
//		System.out.println(str);
//		for (int i = 0; i < str.length(); i++) {
//			char c = str.charAt(i);
//			if(c >= 97 &&  c <= 122) {
//				//65 : A
//				//97 : a
//				//97 - 65
//				result += (char)(c - 32);
//			}else {
//				result += c;
//			}
//		}
//		System.out.println(result);
		// ���� �Է¹ް� �ѱ۷� �����ؼ� ���
		// �Է� ��)1024
		// ��� ��)�ϰ��̻�
		Scanner sc = new Scanner(System.in);
		String hangle = "�����̻�����ĥ�ȱ�";
//		int num = 0;
		String data = "";
		String result = "";
		
		System.out.print("���� : ");
		data = sc.next();
//		���� > ���� == ���� - 48
//		'0' : 48 - 48 = 0
		for (int i = 0; i < data.length(); i++) {
			result += hangle.charAt(data.charAt(i)-48);
		}
		System.out.println(result);
//		while(num != 0) {
//			result = hangle.charAt(num % 10) + result;
//			num /= 10;
//		}
//		System.out.println(result);
		
	}
}












