package day13;
class Car{
	String brand;
	String color;
	int price;
	
	public Car() {}

	public Car(String brand, String color, int price) {
		//�ֻ��� �θ� Ŭ������ ������ ȣ��
		//Object()
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	void engineStart() {
		System.out.println(this.brand + "�õ� Ŵ");
	}
	
	void engineStop() {
		System.out.println(this.brand + "�õ� ��");
	}
}

class SuperCar extends Car{
	String mode;
	
	public SuperCar() {}

	public SuperCar(String brand, String color, int price, String mode) {
		super(brand, color, price);
		this.mode = mode;
	}
	
	@Override
	void engineStart() {
		System.out.print("�������� ");
		//super�� �θ�Ŭ���������� ����.
		//super.engineStart() --> Car(�θ�).engineStart()
		super.engineStart();
	}
	
	@Override
	void engineStop() {
		System.out.print("�������� ");
		super.engineStop();
	}
	
	void openRoof() {
		System.out.println(this.brand + "���� ����");
	}
	
	void closeRoof() {
		System.out.println(this.brand + "���� �ݱ�");
	}
	
}

public class InhTest {
	public static void main(String[] args) {
		
	}
}







