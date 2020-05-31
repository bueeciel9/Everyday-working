package day09;

import java.util.Scanner;

public class MovieManager {
	public static void main(String[] args) {
		// 관리자 페이지
		// 영화 추가, 수정, 삭제, 검색, 목록
		// 0열 : 영화제목, 1열 : 청불("Y", "N")
		String[][] arrFilm = new String[100][2];
		Scanner sc = new Scanner(System.in);
		String title = "[영화 관리 프로그램]";
		String msg = "1.영화추가\n2.영화 수정\n3.영화 삭제\n4.영화 검색\n5.영화 목록\n6.나가기";
		String errMsg = "다시 시도해주세요";

		String temp = null;
		String result = "";
		
		String tag = "⑲";
		
		boolean check = false;

		//추가된 총 영화 개수
		int insertCnt = 0;
		
		int choice = 0;

		while (true) {
			check = false;
			System.out.println(title + "\n" + msg);
			choice = sc.nextInt();
			//nextInt()는 엔터를 먹지 않기 때문에 남은 엔터를
			//nextLine()으로 먹어준다. 그래야 다음 nextLine()이 정상적으로 작동한다.
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
				//for문 영역 밖에서도 사용할 때에는 밖에 선언한다.
				int i = 0;
				//중복검사
				for (i = 0; i < insertCnt; i++) {
					if (temp.equals(arrFilm[i][0])) {
						//사용자가 입력한 영화가 이미 있으면 break;
						break;
					}
				}
				// 중복이 없을 때(break를 안만났을 때)
				if (i == insertCnt) {
					arrFilm[insertCnt][0] = temp;
					temp = "";
//					while(!temp.equals("Y") && !temp.equals("N")) {
					//사용자가 "Y" 또는 "N"을 입력할 때까지 무한반복
					while (!(temp.equals("Y") || temp.equals("N"))) {
						System.out.println("청소년 관람불가[Y], 전체 이용가[N]");
						//사용자가 소문자를 입력해도 대문자로 바꿔서 temp에 넣는다.
						temp = sc.next().toUpperCase();
					}
					//while문을 탈출했다면 정상적으로 모두 입력함.
					arrFilm[insertCnt][1] = temp;
					
					//추가완료시 영화개수 1증가
					insertCnt++;
				}
				break;
			// 영화 수정
			case 2:
				System.out.print("수정하실 영화 제목 : ");
				temp = sc.nextLine();
				//중복검사
				for (i = 0; i < insertCnt; i++) {
					// contains()는 해당 문자 또는 문자열이 포함되어 있다면 참
					// "타짜".contains("타") == true

//					if (arrFilm[i][0].contains(temp)) {
					if (arrFilm[i][0].equals(temp)) {
						//수정할 영화가 있으면 break;
						break;
					}
				}
				// 수정할 상품이 존재하면 참(break를 만났다면 참)
				if (i != insertCnt) {
					System.out.print("새로운 영화 제목 : ");
					temp = sc.nextLine();

					int j = 0;
					for (j = 0; j < insertCnt; j++) {
						if (arrFilm[j][0].equals(temp)) {
							break;
						}
					}
					if (j == insertCnt) {
						//수정할 영화 행(i)에 새로운 영화 제목을 넣는다.
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
						//삭제할 영화가 존재하면 이 영역에 들어옴
						
						//삭제할 행(i)부터 마지막 영화가 추가된 행(insertCnt-1)까지 밀어서 덮어 씌워준다.
						//만약 마지막 영화가 추가된 행(insertCnt-1)까지 밀지 않으면
						//마지막 2개의 값이 중복된다.
						
						//*삭제할 행 : 1
						
						//insertCnt : 3
						//"한동석"	"이순신"	"홍길동"	null
						//0			1			2			3
						
						//[비정상]
						//arData[1] = arData[2]
						//"한동석" "홍길동" "홍길동" null
						//0			1			2		 3
						
						//[정상]
						//arData[1] = arData[2]
						//arData[2] = arData[insertCnt];
						//"한동석" "홍길동" null null
						//0			1			2		 3
						
						
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
					//영화 제목에 입력한 키워드가 포함되면 참
					//예)"타짜".contains("타") == true
					if(arrFilm[i][0].contains(temp)) {
						//검색결과가 한 개라도 있으면 check는 true;
						//검색결과 출력이 끝나면 매번 check는 false로 초기화된다.
						check = true;
						if(arrFilm[i][1].equals("Y")) {
							//만약 청불영화라면 영화제목 앞에 tag를 붙여준다.
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
