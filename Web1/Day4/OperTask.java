package day04;

import java.util.Scanner;

public class OperTask {
	public static void main(String[] args) {
		//입력받은 값이 정수인지 실수인지 판단 후 출력하기(삼항 연산자)
		//숫자 입력 : 
		String numMsg = "숫자 입력 : ";
		double num = 0.0;
		Scanner sc = new Scanner(System.in);
		String msg = "";
		
		System.out.print(numMsg);
		num = sc.nextDouble();
		
		msg = (num - (int)num == 0 ? (int)num + "은(는) 정수입니다." :
			num + "은(는) 실수입니다.");
//		msg = num + (num - (int)num == 0 ? "은(는) 정수입니다." : "은(는) 실수입니다.");
		System.out.println(msg);
	}
}
