package day11;

class Car2{
	
	//브랜드, 색상, 가격
	String brand;
	String color;
	int price;
	boolean check;
	
	//기본 생성자()
	public Car2() {}

	//초기화 생성자(3개)
	public Car2(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	//시동켜기()
	//이미 시동이 켜져있거나 꺼져있으면 경고메세지 출력
	void engineStart() {
		if(!check) {
			check = true;
			System.out.println("시동 켜기");
		}else {
			System.out.println("이미 켜져있습니다.");
		}
	}
	//시동끄기()
	void engineStop() {
		if(check) {
			check = false;
			System.out.println("시동 끄기");
		}else {
			System.out.println("이미 꺼져있습니다.");
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











