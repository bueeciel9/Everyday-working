package day07;

import java.util.Scanner;

public class ArTask {
	public static void main(String[] args) {
		/* 기초 */
		// 1, 2, 3 을 3칸 배열에 넣기
//		int[] arData = new int[3];
////		System.out.println(arData[0]);
////		System.out.println(arData[1]);
////		System.out.println(arData[2]);
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i+1;
//		}
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		// 3, 2, 1 을 3칸 배열에 넣기

		/* 초급 */
		// 100~1까지 배열에 넣고 출력(100-i)
		// 1~100까지 중 짝수만 배열에 넣고 출력((i+1)*2)
		// 1~10까지 배열에 넣고 총 합 출력
//		int[] arData = new int[10];
//		int total = 0;
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i + 1;
//			total += arData[i];
//		}
//		System.out.println(total);

		/* 중급 */
		// A~F까지 배열에 넣고 출력
//		char a = 10;
//		char[] arData = new char[6];
//		
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = (char)(i + 65);
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		// A~F까지 중 E제외하고 배열에 넣은 후 출력
//		char[] arData = new char[5];
//		int temp = 0;
//		for (int i = 0; i < arData.length; i++) {
//			temp = i;
//			if(i == arData.length-1) {
//				temp++;
//			}
//			arData[i] = (char)(temp + 65);
////			arData[i] = i == arData.length - 1 ? (char)(i + 66) : (char)(i + 65);
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		
		// 5개의 정수를 입력받고 최대값과 최소값 출력하기
//		Scanner sc = new Scanner(System.in);
//		int max = 0, min = 0;
//		
//		System.out.println("5개 정수 입력");
//		int[] arData = new int[5];
//		for (int i = 0; i < arData.length; i++) {
//			System.out.printf("%d번째 정수 : ", i+1);
//			arData[i] = sc.nextInt();
//		}
//		
//		max = arData[0];
//		min = arData[0];
//		
//		for (int i = 0; i < arData.length; i++) {
//			if(max < arData[i]) {max = arData[i];}
//			if(min > arData[i]) {min = arData[i];}
//		}
//		System.out.println("최대값 : " + max);
//		System.out.println("최소값 : " + min);
		
		
		/* 고급 */
		// 문자열을 입력받고(한글 제외) 소문자는 대문자로 변경해서 출력
//		Scanner sc = new Scanner(System.in);
//		String str = "";
//		String result = "";
//		
//		System.out.print("문자열(한글안됨) : ");
//		
//		str = sc.next().toUpperCase();
//		System.out.println(str);
//		for (int i = 0; i < str.length(); i++) {
//			char c = str.charAt(i);
//			if(c >= 97 &&  c <= 122) {
//				//65 : A
//				//97 : a
//				//97 - 65
//				result += (char)(c - 32);
//			}else {
//				result += c;
//			}
//		}
//		System.out.println(result);
		// 정수 입력받고 한글로 변경해서 출력
		// 입력 예)1024
		// 출력 예)일공이사
		Scanner sc = new Scanner(System.in);
		String hangle = "공일이삼사오육칠팔구";
//		int num = 0;
		String data = "";
		String result = "";
		
		System.out.print("정수 : ");
		data = sc.next();
//		문자 > 정수 == 문자 - 48
//		'0' : 48 - 48 = 0
		for (int i = 0; i < data.length(); i++) {
			result += hangle.charAt(data.charAt(i)-48);
		}
		System.out.println(result);
//		while(num != 0) {
//			result = hangle.charAt(num % 10) + result;
//			num /= 10;
//		}
//		System.out.println(result);
		
	}
}












