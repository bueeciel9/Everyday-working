package day04;

import java.util.Scanner;

public class IfTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String msg = "사막을 같이 동행하는 동물 중\n 가장 먼저 버릴 동물을 선택하세요.\n";
		String choiceMsg = "1.호랑이\n2.양\n3.원숭이\n4.말\n5.소";
		
		String answer1 = "자존심";
		String answer2 = "사랑";
		String answer3 = "자식";
		String answer4 = "지식";
		String answer5 = "재산";
		String errMsg = "다시 시도해주세요";
		
		String result = "";
		
		int choice = 0;
		//Flag는 해당 영역에서 모든 작업을 완료할 수 없을 때
		//표시를 하고 나오기 위한 기법
		//boolean 혹은 int로 사용된다.
		boolean check = false;
		
		System.out.println(msg + choiceMsg);
		choice = sc.nextInt();
		
		switch(choice) {
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
		//사용자가 잘못 입력해서 default영역에 들어갔다면
		//check는 true이고, !(NOT)이 붙어 false로 변경된다.
		//따라서 잘못 입력했다면 if문에 들어가지 않는다.
		if(!check) {
			result = "당신은 " + result + "을(를) 버렸습니다.";
		}
		//일괄처리(실무코딩)
		System.out.println(result);
	}
}






