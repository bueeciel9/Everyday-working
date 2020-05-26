package day04;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int choice = 0;
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
		
		System.out.println(msg + choiceMsg);
		choice = sc.nextInt();
		
		//사용자가 입력한 정수를 하나씩 비교한다.
		//참이라면 false부분은 더 이상 하지 않는다.
		result = choice == 1 ? answer1 :
			choice == 2 ? answer2 :
				choice == 3 ? answer3 :
					choice == 4 ? answer4 :
						choice == 5 ? answer5 :
							errMsg;
		
		//errMsg일 때에는 그대로 출력해야 하므로 삼항 연산자를 한 번 더 사용한다.
		//문자열끼리 비교할 때에는 ==이 아닌 equals()를 사용한다. 
		result = result.equals(errMsg) ? result : "당신은 " + result + "을(를) 버렸습니다.";
		System.out.println(result);
	}
}





