package day11;

class Car2{
	
	//�귣��, ����, ����
	String brand;
	String color;
	int price;
	boolean check;
	
	//�⺻ ������()
	public Car2() {}

	//�ʱ�ȭ ������(3��)
	public Car2(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	//�õ��ѱ�()
	//�̹� �õ��� �����ְų� ���������� ���޼��� ���
	void engineStart() {
		if(!check) {
			check = true;
			System.out.println("�õ� �ѱ�");
		}else {
			System.out.println("�̹� �����ֽ��ϴ�.");
		}
	}
	//�õ�����()
	void engineStop() {
		if(check) {
			check = false;
			System.out.println("�õ� ����");
		}else {
			System.out.println("�̹� �����ֽ��ϴ�.");
		}
	}
}

public class Road2 {
	public static void main(String[] args) {
		Car2 myCar = new Car2("Bentley", "White", 35000);
		
		myCar.engineStart();
		myCar.engineStart();
		myCar.engineStart();
		myCar.engineStop();
		myCar.engineStop();
		myCar.engineStop();
		myCar.engineStop();
		myCar.engineStop();
	}
}











