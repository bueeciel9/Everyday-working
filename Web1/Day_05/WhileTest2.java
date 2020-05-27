package day05;

import java.util.Scanner;

public class WhileTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String msg = "사막을 같이 동행하는 동물 중\n 가장 먼저 버릴 동물을 선택하세요.\n";
		String choiceMsg = "1.호랑이\n2.양\n3.원숭이\n4.말\n5.소\n0.나가기";
		
		String answer1 = "자존심";
		String answer2 = "사랑";
		String answer3 = "자식";
		String answer4 = "지식";
		String answer5 = "재산";
		String errMsg = "다시 시도해주세요";
		
		String result = "";
		
		int choice = 0;
		boolean check = false;
		
		do {
			result = "";
			check = false;
			System.out.println(msg + choiceMsg);
			choice = sc.nextInt();
			
			switch(choice) {
			case 0:
				check = true;
				break;
			case 1:
				result = answer1;
				break;
			case 2:
				result = answer2;
				break;
			case 3:
				result = answer3;
				break;
			case 4:
				result = answer4;
				break;
			case 5:
				result = answer5;
				break;
			default:
				result = errMsg;
				check = true;
			}
			
			if(!check) {
				result = "당신은 " + result + "을(를) 버렸습니다.";
			}
			System.out.println(result);
		}while(choice != 0);
		
		
		
		
		
		
		
		
		
//		int cnt = 0;
//		
//		while(cnt != 10) {
//			cnt++;
//			System.out.println(cnt + ". 한동석");
//		}
	}
}

