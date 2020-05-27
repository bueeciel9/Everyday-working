package day05;

import java.util.Scanner;

public class ForTask {
	public static void main(String[] args) {
		// 정수를 입력 받기(증감 연산자 사용)
		// 출력은 두 번한다.
		// 입력 예) 5
		// 출력 예) 5
		// 7
//		String name = "한동석";
//		System.out.println(name.length());
//		System.out.println("한동석".length());
//		
//		Scanner sc = new Scanner(System.in);
//		
//		sc.nextInt();
//		new Scanner(System.in).nextInt();

//		System.out.print("정수 : ");
//		int num = new Scanner(System.in).nextInt();
//		System.out.println(num++);
//		System.out.println(++num);
		/*
		 * 모든 문제는 for문을 한 번만 사용한다. 초기값은 0으로 고정한다. 증감량은 1로 고정한다.
		 */
		// 100~1 출력
//		for (int i = 0; i < 100; i++) {
//			System.out.println(100 - i);
//		}
		// 1~100까지 중 짝수만 출력(50번반복)
//		for (int i = 0; i < 50; i++) {
//			System.out.println((i+1)*2);
//		}
		// 1~10까지의 합 출력
//		int result = 0;
//		for (int i = 0; i < 10; i++) {
////			result = result + i + 1;
//			result += i + 1;
//			//result = 0 + 1
//			//result = (0+1) + 2
//			//result = (0+1+2) + 3
//		}
//		System.out.println(result);
		// 1~n까지의 합 출력
//		Scanner sc = new Scanner(System.in);
//		int num = 0;
//		int result = 0;
//
//		System.out.print("정수 : ");
//		num = sc.nextInt();
//
//		if (num > 1) {
//			for (int i = 0; i < num; i++) {
//				result += i + 1;
//			}
//			System.out.println(result);
//		} else {
//			System.out.println("1보다 큰 값을 입력하세요");
//		}

		// A~F까지 출력
		// 문자 + 정수 = 정수
//		for (int i = 0; i < 6; i++) {
//			System.out.println((char)('A' + i));
//		}
//		for(char i = 'A'; i < 'G'; i++) {
//			System.out.println(i);
//		}
		// A~F까지 중 C제외하고 출력(5번반복)
//		int temp = 0;
//		for (int i = 0; i < 5; i++) {
//			temp = i;
//			if(i > 1) {
//				//i를 증가시키면 반복 횟수가 줄어든다
//				//(초기값이 증가할 수록 반복횟수가 감소)
//				//따라서 i값을 temp에 담고 temp를 증가시킨다.
//				temp++;
//			}
//			System.out.println((char)(temp + 65));
//		}

		// aBcDeF.....Z 출력
//		for (int i = 0; i < 26; i++) {
//			System.out.println((char)(i % 2 == 0 ? 'a' + i : 'A' + i));
//		}
		// 0 1 2 0 1 2 0 1 2출력
		// x % y : 0 ~ y-1
//		for(int i = 0; i < 9; i++) {
//			System.out.print(i % 3 + " ");
//		}
//		System.out.println();
		// 구구단 출력 (1단~9단)(변수는 한 개만 사용)
		for (int i = 0; i < 81; i++) {
//			i / 9 = 0~8 : 0, 9~17 : 1	+1
//			i % 9 = 0~8						+1
			System.out.printf("%d*%d=%d\n", i/9+1, i%9+1, (i/9+1)*(i%9+1));
		}
	}
}










