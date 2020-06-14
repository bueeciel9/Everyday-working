package homework;

import java.util.Random;

public class Gambling {
	public int roll_dice() {
		Random r = new Random();
		int num = r.nextInt(6) + 1;
		return num;
	}
	
	public void getResult(int money) {
		int total = 0;
		int temp = money;
		int result = 0;
		if(money >= 18) {
			money -= 18;
			for (int i = 0; i < 5; i++) {
				total += roll_dice();
			}
		}
		result = total - temp;
		// È¹µæ : total
		// ¼ÕÀÍ : total - temp
		System.out.println("È¹µæ : $"+total);
		System.out.print(result < 0 ? "¼ÕÀÍ : -$" : "¼ÕÀÍ : $");
		if(result < 0) {result *= -1;}
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		new Gambling().getResult(18);
	}
}


