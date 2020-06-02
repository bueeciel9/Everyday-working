package day11;

import java.util.Scanner;

class Car{
	String brand;
	int price;
	String color;
	
	public Car(int price, String color) {
		this.price = price;
		this.color = color;
	}

	public Car(String brand, int price, String color) {
		this.brand = brand;
		this.price = price;
		this.color = color;
	}

	void engineStart() {
		System.out.println(this);
		System.out.println(this.brand + "½Ãµ¿ Å´");
	}
	
	void engineStop() {
		System.out.println(brand + "½Ãµ¿ ²û");
	}
}

public class Road {
	public static void main(String[] args) {
		Car mom_car = new Car("Benz", 8000, "Black");
		Car dady_car = new Car(7000, "Blue");
		Car my_car = new Car("Bentley", 35000, "White");
		
//		mom_car.brand = "Benz";
//		dady_car.brand = "BMW";
//		my_car.brand = "Bentley";
		
		dady_car.brand = new Scanner(System.in).next();
		
		System.out.println(mom_car);
		mom_car.engineStart();
		
		dady_car.engineStart();
		
	}
}













