package day12;

import java.util.Scanner;

class Car{
	//브랜드, 가격, 색상
	String brand;
	int price;
	String color;
	String pw = "0000";
	int police_cnt;
	
	//기본 생성자
	public Car() {}
	//초기화 생성자
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
	//시동켜기, 시동끄기
	//시동킬 때 비밀번호를 입력받고 자동차 비밀번호와 일치하면 켜주기
	//3번 연속 오류시 "경찰 출동 중" 출력하기
	void engineStart(String pw) {
		if(this.pw.equals(pw)) {
			police_cnt = 0;
			System.out.println("시동 킴");
		}else {
			police_cnt++;
			System.out.println("비밀번호 오류");
		}
	}
	
	void engineStop() {
		System.out.println("시동 끔");
	}
}

public class Road {
	public static void main(String[] args) {
		Car ferrari = new Car("Ferrari", 20000, "Red");
		Scanner sc = new Scanner(System.in);
		String pw = "";
		int choice = 0;
		
		while(true) {
			System.out.println("1.시동켜기\n2.시동끄기");
			choice = sc.nextInt();

			if(choice == 1) {
				System.out.print("비밀번호 : ");
				pw = sc.next();
				ferrari.engineStart(pw);
				if(ferrari.police_cnt == 3) {
					System.out.println("경찰 출동 중");
					break;
				}
			}else if(choice == 2) {
				ferrari.engineStop();
				break;
			}
		}
	}
}









