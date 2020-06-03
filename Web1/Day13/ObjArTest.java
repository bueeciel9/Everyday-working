package day13;

class Food{
	String name;
	int price;
	
	public Food() {}

	public Food(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	void cook(String how) {
		System.out.println(how);
	}
}

public class ObjArTest {
	public static void main(String[] args) {
//		Food ham = new Food("햄", 3000);
//		Food egg = new Food("계란", 500);
		
		Food[] foods = {
				new Food("햄", 3000),
				new Food("계란", 500),
				new Food("빵", 1500)
		};
		
		String[] hows = {"후라이팬에 넣고 볶기", "을 냄비에 넣고 보글보글", "을 토스트기에 넣기"};
		
		for(int i=0; i<foods.length; i++) {
			foods[i].cook(foods[i].name + hows[i]);
		}
	}
}











