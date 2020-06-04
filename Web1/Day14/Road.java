package day14;

class Car{
	//브랜드, 색상, 가격
	String brand;
	String color;
	int price;
	//기본 생성자
	public Car() {
		//자식은 항상 부모의 기본생성자를 호출한다.
		//만약 기본생성자가 없다면 상속하자 마자 오류가 난다.
		//왜냐하면 부모의 기본 생성자가 없기 때문이다.
		//따라서 클래스 선언시 기본 생성자를 선언해주는 습관이 필요하다.
	}
	
	//초기화 생성자
	public Car(String brand, String color, int price) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	//시동 켜기, 시동 끄기
	void engineStart() {
		System.out.println("시동 켜기");
	}

	void engineStop() {
		System.out.println("시동 끄기");
	}
}

class SuperCar extends Car{
	//Car 상속받기
	//모드
	String mode;
	//기본 생성자
	public SuperCar() {}
	//초기화 생성자
	public SuperCar(String mode) {
		super();
		this.mode = mode;
	}
	public SuperCar(String brand, String color, int price, String mode) {
		super(brand, color, price);
		this.mode = mode;
	}
	//음성지원
	@Override
	void engineStart() {
		System.out.print("음성으로 ");
		super.engineStart();
	}
	
	//지붕 열기, 지붕 닫기
	void openRoof() {
		System.out.println("지붕 열기");
	}
	
	void closeRoof() {
		System.out.println("지붕 닫기");
	}
}

public class Road {
	public static void main(String[] args) {
		//up casting
		Car noOptionFerrari = new SuperCar("Ferrari", "Red", 25000, "Sport");
		noOptionFerrari.engineStart();
		
		//down casting
//		SuperCar brokenFerrari = (SuperCar)new Car(); 잘못된 사용
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;
		fullOptionFerrari.openRoof();
	}
}













