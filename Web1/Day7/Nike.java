package day07;

import java.util.Scanner;

public class Nike {
	public static void main(String[] args) {
		// 일반점, 키즈점
		// 강남점, 홍대점, 신촌점
		int[][] arrIncome = new int[2][3];

		int length = 0;
		
		String[] arAgeName = { "일반점", "키즈점" };
		String[] arBranchName = { "강남점", "홍대점", "신촌점" };

		// 연령별 총 매출액
		int[] arAgeTotal = new int[2];
		// 연령별 평균 매출액
		double[] arAgeAvg = new double[2];

		// 지점별 총 매출액
		int[] arBranchTotal = new int[3];
		// 지점별 평균 매출액
		double[] arBranchAvg = new double[3];

		// 나이키 총 매출액
		int total = 0;
		// 나이키 평균 매출액
		double avg = 0.0;

		boolean check = false;
		
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < arrIncome.length; i++) {
			length += arrIncome[i].length;
			for (int j = 0; j < arrIncome[i].length; j++) {
				System.out.println(arBranchName[j] + arAgeName[i] + " 매출액 입력(단위 : 만원)");
				arrIncome[i][j] = sc.nextInt();
				arAgeTotal[i] += arrIncome[i][j];
				arBranchTotal[j] += arrIncome[i][j];
				total += arrIncome[i][j];
			}
			arAgeAvg[i] = (double) arAgeTotal[i] / arrIncome[i].length;
		}

		for (int i = 0; i < arBranchAvg.length; i++) {
			arBranchAvg[i] = (double)arBranchTotal[i] / arrIncome.length;
		}
		
		avg = (double)total / length;
		
		//지점별 총, 평균 매출액 출력
		//연령별 총, 평균 매출액 출력
		//나이키 총, 평균 매출액 출력
		
		System.out.println("★인센티브 매장★");
		for (int i = 0; i < arrIncome.length; i++) {
			for (int j = 0; j < arrIncome[i].length; j++) {
				if (avg < arrIncome[i][j]) {
					System.out.println(arBranchName[j] + arAgeName[i]);
					check = true;
				}
			}
		}

		if(!check) {
			System.out.println("해당사항 없음");
		}
	}
}




