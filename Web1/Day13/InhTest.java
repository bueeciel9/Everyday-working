package day13;
class Car{
	String brand;
	String color;
	int price;
	
	public Car() {}

	public Car(String brand, String color, int price) {
		//최상위 부모 클래스의 생성자 호출
		//Object()
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	void engineStart() {
		System.out.println(this.brand + "시동 킴");
	}
	
	void engineStop() {
		System.out.println(this.brand + "시동 끔");
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
		System.out.print("음성으로 ");
		//super는 부모클래스명으로 본다.
		//super.engineStart() --> Car(부모).engineStart()
		super.engineStart();
	}
	
	@Override
	void engineStop() {
		System.out.print("음성으로 ");
		super.engineStop();
	}
	
	void openRoof() {
		System.out.println(this.brand + "지붕 열기");
	}
	
	void closeRoof() {
		System.out.println(this.brand + "지붕 닫기");
	}
	
}

public class InhTest {
	public static void main(String[] args) {
		
	}
}







