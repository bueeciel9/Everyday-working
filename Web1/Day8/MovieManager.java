package day08;

import java.util.Scanner;

public class MovieManager {
	public static void main(String[] args) {
		// 관리자 페이지
		// 영화 추가, 수정, 삭제, 검색, 목록
		// 영화제목, 청불
		String[][] arrFilm = new String[100][2];
		Scanner sc = new Scanner(System.in);
		String title = "[영화 관리 프로그램]";
		String msg = "1.영화추가\n2.영화 수정\n3.영화 삭제\n4.영화 검색\n5.영화 목록\n6.나가기";
		String errMsg = "다시 시도해주세요";

		String temp = null;
		String result = "";
		
		String tag = "⑲";
		
		boolean check = false;

		int insertCnt = 0; 
		int choice = 0;

		while (true) {
			System.out.println(title + "\n" + msg);
			choice = sc.nextInt();
			sc.nextLine();

			if (choice == 6) {
				break;
			}

			switch (choice) {
			// 영화 추가
			case 1:
				System.out.println("[영화 추가]");
				System.out.print("영화 제목 : ");
				temp = sc.nextLine();
				int i = 0;
				for (i = 0; i < insertCnt; i++) {
					if (temp.equals(arrFilm[i][0])) {
						break;
					}
				}
				// 중복이 없을 때
				if (i == insertCnt) {
					arrFilm[insertCnt][0] = temp;
					temp = "";
//					while(!temp.equals("Y") && !temp.equals("N")) {
					while (!(temp.equals("Y") || temp.equals("N"))) {
						System.out.println("청소년 관람불가[Y], 전체 이용가[N]");
						temp = sc.next().toUpperCase();
					}
					arrFilm[insertCnt][1] = temp;
					insertCnt++;
				}
				break;
			// 영화 수정
			case 2:
				System.out.print("수정하실 영화 제목 : ");
				temp = sc.nextLine();
				for (i = 0; i < insertCnt; i++) {
					// contains()는 해당 문자 또는 문자열이 포함되어 있다면 참
					// "타짜".contains("타") == true

//					if (arrFilm[i][0].contains(temp)) {
					if (arrFilm[i][0].equals(temp)) {
						break;
					}
				}
				// 수정할 상품이 존재하면 참
				if (i != insertCnt) {
					System.out.print("새로운 영화 제목 : ");
					temp = sc.nextLine();

					int j = 0;
					for (j = 0; j < insertCnt; j++) {
						if (arrFilm[i][0].equals(temp)) {
							break;
						}
					}
					if (j == insertCnt) {
						arrFilm[i][0] = temp;
						temp = "";

						while (!(temp.equals("Y") || temp.equals("N"))) {
							System.out.println("청소년 관람불가[Y], 전체 이용가[N]");
							temp = sc.next().toUpperCase();
						}
						arrFilm[i][1] = temp;
					}
				}
				break;
			// 영화 삭제
			case 3:
				System.out.print("삭제할 영화 : ");
				temp = sc.nextLine();
				for (i = 0; i < insertCnt; i++) {
					if (temp.equals(arrFilm[i][0])) {
						for(int j = i; j < insertCnt ; j++) {
							arrFilm[j] = arrFilm[j+1];
						}
						insertCnt--;
					}
				}
				break;
				
			// 영화 검색
				//청불 영화라면 19붙여서 출력
				//검색한 키워드가 한 개라도 들어가 있어도 출력
			case 4:
				result = "";
				System.out.print("검색 : ");
				temp = sc.nextLine();
				for(i = 0; i < insertCnt; i++) {
					if(arrFilm[i][0].contains(temp)) {
						check = true;
						if(arrFilm[i][1].equals("Y")) {
							result += tag;
						}
						result += arrFilm[i][0] + "\n";
					}
				}
				System.out.println(!check ? "검색 결과 없음" : result);
				break;
			// 영화 목록
			case 5:
				System.out.println(insertCnt == 0 ? "목록 없음" : "[영화 목록]");
				for (i = 0; i < insertCnt; i++) {
					if (arrFilm[i][1].equals("Y")) {
						System.out.print(tag);
					}
					System.out.println(arrFilm[i][0]);
				}
				break;
			// 그 외
			default:
				System.out.println(errMsg);
			}

		}

	}
}
