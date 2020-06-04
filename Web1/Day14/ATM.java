package bank;

import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		String msg = "1.신한은행\n2.국민은행\n3.우리은행\n4.나가기";
		String menu = "1.계좌 개설\n2.입금하기\n3.출금하기\n4.잔액조회\n5.계좌번호 찾기\n6.은행 선택";
		
		Scanner sc = new Scanner(System.in);
		int choice = 0, menu_choice = 0;
		
		while(true) {
			System.out.println(msg);
			choice = sc.nextInt();
			
			if(choice == 4) {break;}
			
			while(true) {
				System.out.println(menu);
				menu_choice = sc.nextInt();
				
				if(menu_choice == 6) {
					break;
				}
				
				switch(menu_choice) {
				//계좌개설
				//계좌번호는 랜덤, 중복 안될 때까지 무한 반복
				//핸드폰 번호도 동일(특수문자는 넣지 않는다)
				//비밀번호는 4자리(아닐 시 무한반복)
				//비밀번호 암호화
				//위 작업 모두 완료시 해당 객체 arBank[?][?]에 넣기
				case 1:
					break;
				//입금
				case 2:
					break;
				//출금
				case 3:
					break;
				//잔액조회
				case 4:
					break;
				//계좌 찾기
				case 5:
					break;
				}
				
			}
		}
		
	}
}
