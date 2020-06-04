package day14;

class Car{
	//�귣��, ����, ����
	String brand;
	String color;
	int price;
	//�⺻ ������
	public Car() {
		//�ڽ��� �׻� �θ��� �⺻�����ڸ� ȣ���Ѵ�.
		//���� �⺻�����ڰ� ���ٸ� ������� ���� ������ ����.
		//�ֳ��ϸ� �θ��� �⺻ �����ڰ� ���� �����̴�.
		//���� Ŭ���� ����� �⺻ �����ڸ� �������ִ� ������ �ʿ��ϴ�.
	}
	
	//�ʱ�ȭ ������
	public Car(String brand, String color, int price) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	//�õ� �ѱ�, �õ� ����
	void engineStart() {
		System.out.println("�õ� �ѱ�");
	}

	void engineStop() {
		System.out.println("�õ� ����");
	}
}

class SuperCar extends Car{
	//Car ��ӹޱ�
	//���
	String mode;
	//�⺻ ������
	public SuperCar() {}
	//�ʱ�ȭ ������
	public SuperCar(String mode) {
		super();
		this.mode = mode;
	}
	public SuperCar(String brand, String color, int price, String mode) {
		super(brand, color, price);
		this.mode = mode;
	}
	//��������
	@Override
	void engineStart() {
		System.out.print("�������� ");
		super.engineStart();
	}
	
	//���� ����, ���� �ݱ�
	void openRoof() {
		System.out.println("���� ����");
	}
	
	void closeRoof() {
		System.out.println("���� �ݱ�");
	}
}

public class Road {
	public static void main(String[] args) {
		//up casting
		Car noOptionFerrari = new SuperCar("Ferrari", "Red", 25000, "Sport");
		noOptionFerrari.engineStart();
		
		//down casting
//		SuperCar brokenFerrari = (SuperCar)new Car(); �߸��� ���
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
		fullOptionFerrari.openRoof();
	}
}













