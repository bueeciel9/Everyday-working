package day07;

import java.util.Scanner;

public class ArTest {
	public static void main(String[] args) {
		// 구찌
		// 강남점 홍대점 신촌점
		// 평균 매출액은 백원단위까지 출력한다.
		int[] arIncome = new int[3];
		String[] arBranch = { "강남점", "홍대점", "신촌점" };
		Scanner sc = new Scanner(System.in);
		boolean check = false;

		int total = 0;
		double avg = 0.0;

		for (int i = 0; i < arIncome.length; i++) {
			System.out.println(arBranch[i] + " 매출액 입력(단위 : 만원)");
			arIncome[i] = sc.nextInt();
			// 총 매출액을 구하는 영역
			total += arIncome[i];
		}
		avg = Double.parseDouble(String.format("%.2f", (total + 0.0) / arIncome.length));

		System.out.println("구찌 총 매출액 : " + total + "만원");
		System.out.println("구찌 평균 매출액 : " + avg + "만원");

		// 평균 매출액보다 높은 매장은 인센티브 매장으로 출력
		// (출력 예)
		// ★인센티브 매장★
		// 강남점
		// 홍대점
		System.out.println("★인센티브 매장★");
		for (int i = 0; i < arIncome.length; i++) {
			if (avg < arIncome[i]) {
				System.out.println(arBranch[i]);
				check = true;
			}
		}

		if(!check) {
			System.out.println("해당사항 없음");
		}
		// 인센티브 매장이 없다면 해당사항 없음 출력
		// ★인센티브 매장★
		// 해당사항 없음
	}
}
