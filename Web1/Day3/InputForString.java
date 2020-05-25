package day03;

import java.util.Scanner;

public class InputForString {
	public static void main(String[] args) {
		String name = "";
//		String firstName = "";
//		String lastName = "";
		String age = "";
		
		String nameMsg = "¿Ã∏ß : ";
		String ageMsg = "≥™¿Ã : ";
		
		Scanner sc = new Scanner(System.in);

		System.out.print(ageMsg);
		age = sc.nextInt() + "ªÏ";
		//ø£≈Õ ªÛº‚
		sc.nextLine();
		
		System.out.print(nameMsg);
		name = sc.nextLine() + "¥‘";
//		lastName = sc.next();
//		firstName = sc.next() + "¥‘";
//		name = lastName + firstName;
		
		System.out.println(name + "\n" + age);
	}
}





