package bank;

import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		String msg = "1.��������\n2.��������\n3.�츮����\n4.������";
		String menu = "1.���� ����\n2.�Ա��ϱ�\n3.����ϱ�\n4.�ܾ���ȸ\n5.���¹�ȣ ã��\n6.���� ����";
		
		Scanner sc = new Scanner(System.in);
		int choice = 0, menu_choice = 0;
		
		while(true) {
			System.out.println(msg);
			choice = sc.nextInt();
			
			if(choice == 4) {break;}
			
			while(true) {
				System.out.println(menu);
				menu_choice = sc.nextInt();
				
				if(menu_choice == 6) {
					break;
				}
				
				switch(menu_choice) {
				//���°���
				//���¹�ȣ�� ����, �ߺ� �ȵ� ������ ���� �ݺ�
				//�ڵ��� ��ȣ�� ����(Ư�����ڴ� ���� �ʴ´�)
				//��й�ȣ�� 4�ڸ�(�ƴ� �� ���ѹݺ�)
				//��й�ȣ ��ȣȭ
				//�� �۾� ��� �Ϸ�� �ش� ��ü arBank[?][?]�� �ֱ�
				case 1:
					break;
				//�Ա�
				case 2:
					break;
				//���
				case 3:
					break;
				//�ܾ���ȸ
				case 4:
					break;
				//���� ã��
				case 5:
					break;
				}
				
			}
		}
		
	}
}
