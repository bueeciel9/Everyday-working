package animalGame;

import java.util.Scanner;

public class AnimalMain {
	public static void main(String[] args) {
		//µøπ∞ 3∏∂∏Æ ≈¨∑°Ω∫ πËø≠∑Œ º±æ
		AnimalField[] animals = {
			new AnimalField("πŸµœ¿Ã", "∞≥≤≠", 4.5, 5, 5),
			new AnimalField("≤‹≤‹¿Ã", "ø¡ºˆºˆ", 9.9, 8, 2),
			new AnimalField("ºÿºÿ¿Ã", "∏Ò√ ", 7.5, 3, 7)
		};
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int choice = 0;
		int menu_choice = 0;
		
		while(true) {
			boolean check = false;
			
			System.out.println("[∏ø©∂Û ºø∑¥ µøπ∞!]");
			for (i = 0; i < animals.length; i++) {
				System.out.println(i+1 + "." + animals[i].name);
			}
			System.out.println(i+1 + ".≥™∞°±‚");
			choice = sc.nextInt();
			
			if(choice == i+1) {
				break;
			}
			
			while(true) {
				System.out.println("1.π‰∏‘±‚\n2.ªÍ√•«œ±‚\n3.¿·¿⁄±‚\n4.ƒ≥∏Ø≈Õ º±≈√√¢");
				menu_choice = sc.nextInt();
				
				if(menu_choice == 4) {break;}
				
				switch(menu_choice) {
				//π‰∏‘±‚
				case 1:
					animals[choice-1].eat();
					if(animals[choice-1].weight >= 100){
						animals[choice-1].sleep();
//						check = true;
					}
					break;
				//ªÍ√•«œ±‚
				case 2:
					animals[choice-1].walk();
					if(animals[choice-1].hp == 0) {
						animals[choice-1].sleep();
//						check = true;
					}
					break;
				//¿·¿⁄±‚
				case 3:
					animals[choice-1].sleep();
					break;
				}
				
//				if(check) {
//					System.out.println(animals[choice-1].name + " æ»≥Á~");
//					AnimalField[] arTemp = {
//							new AnimalField("πŸµœ¿Ã", "∞≥≤≠", 4.5, 5, 5),
//							new AnimalField("≤‹≤‹¿Ã", "ø¡ºˆºˆ", 9.9, 8, 2),
//							new AnimalField("ºÿºÿ¿Ã", "∏Ò√ ", 7.5, 3, 7)
//					};
//					animals[choice-1] = arTemp[choice-1];
//					break;
//				}
			}
		}
	}
}






