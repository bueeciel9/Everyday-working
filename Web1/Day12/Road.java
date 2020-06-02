package day12;

import java.util.Scanner;

class Car{
	//�귣��, ����, ����
	String brand;
	int price;
	String color;
	String pw = "0000";
	int police_cnt;
	
	//�⺻ ������
	public Car() {}
	//�ʱ�ȭ ������
	public Car(String brand, int price, String color) {
		this.brand = brand;
		this.price = price;
		this.color = color;
	}
	
	public Car(String brand, int price, String color, String pw) {
		this.brand = brand;
		this.price = price;
		this.color = color;
		this.pw = pw;
	}
	//�õ��ѱ�, �õ�����
	//�õ�ų �� ��й�ȣ�� �Է¹ް� �ڵ��� ��й�ȣ�� ��ġ�ϸ� ���ֱ�
	//3�� ���� ������ "���� �⵿ ��" ����ϱ�
	void engineStart(String pw) {
		if(this.pw.equals(pw)) {
			police_cnt = 0;
			System.out.println("�õ� Ŵ");
		}else {
			police_cnt++;
			System.out.println("��й�ȣ ����");
		}
	}
	
	void engineStop() {
		System.out.println("�õ� ��");
	}
}

public class Road {
	public static void main(String[] args) {
		Car ferrari = new Car("Ferrari", 20000, "Red");
		Scanner sc = new Scanner(System.in);
		String pw = "";
		int choice = 0;
		
		while(true) {
			System.out.println("1.�õ��ѱ�\n2.�õ�����");
			choice = sc.nextInt();

			if(choice == 1) {
				System.out.print("��й�ȣ : ");
				pw = sc.next();
				ferrari.engineStart(pw);
				if(ferrari.police_cnt == 3) {
					System.out.println("���� �⵿ ��");
					break;
				}
			}else if(choice == 2) {
				ferrari.engineStop();
				break;
			}
		}
	}
}









