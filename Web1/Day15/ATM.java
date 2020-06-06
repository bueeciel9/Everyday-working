package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		String msg = "1.신한은행\n2.국민은행\n3.우리은행\n4.나가기";
		String menu = "1.계좌 개설\n2.입금하기\n3.출금하기\n4.잔액조회\n5.계좌번호 찾기\n6.은행 선택";

		Scanner sc = new Scanner(System.in);
		int choice = 0, menu_choice = 0;

		String account = "", pw = "", phone = "", name = "";
		int money = 0;

		Random r = new Random();
		
		//Bank필드에 접근하기 위해 사용
		//(로그인, 중복검사)
		Bank b = new Bank();
		
		//메소드 사용 후 결과를 담기 위한 객체
		Bank temp_obj = null;

		//규칙성 부여
		String[] bank_name = {"신한은행", "국민은행", "우리은행"};
		
		while (true) {
			//flag
			//사용자가 메뉴를 정상적으로 눌렀다면 true
			boolean check = false;
			System.out.println(msg);
			choice = sc.nextInt();

			if (choice == 4) {
				break;
			}
			for(int i=0; i<Bank.arBank.length; i++) {
				if(choice == i+1) {
					check = true;
				}
			}
			//은행번호가 아닌 다른 번호를 눌렀을 때
			if(!check) {continue;}
			
			while (true) {
				System.out.println(menu);
				menu_choice = sc.nextInt();

				if (menu_choice == 6) {
					break;
				}

				switch (menu_choice) {
				// 계좌개설
				// 계좌번호는 랜덤, 중복 안될 때까지 무한 반복
				// 핸드폰 번호도 동일(특수문자는 넣지 않는다)
				// 비밀번호는 4자리(아닐 시 무한반복)
				// 비밀번호 암호화
				// 위 작업 모두 완료시 해당 객체 arBank[?][?]에 넣기
				case 1:
					// 100000~999999
					// 0~899999 + 100000
					while (true) {
						//계좌번호 생성(6자리)
						account = "" + (r.nextInt(900000) + 100000);
						if (b.checkDup_account(account) == null) {
							//중복이 없다면 탈출
							break;
						}
					}
					System.out.print("예금주 : ");
					name = sc.next();

					while(true) {
						boolean flag = false;
						System.out.print("비밀번호(4자리) : ");
						pw = sc.next();
						//길이 검사(4자리가 아니면 다음 반복)
						if(pw.length() != 4) {continue;}
						
						//'정수'가 아닌 문자 검사
						for (int i = 0; i < pw.length(); i++) {
							char c = pw.charAt(i);
							if(c < 48 || c > 57) {
								flag = true;
							}
						}
						//정상적인 비밀번호 입력시 탈출
						if(!flag) {break;}
					}
					
					while(true) {
						boolean flag = false;
						System.out.print("핸드폰 번호('-'제외) : ");
						phone = sc.next();
						//길이 검사
						if(phone.length() != 11) {continue;}
						
						//'정수'가 아닌 문자 검사
						for (int i = 0; i < phone.length(); i++) {
							char c = phone.charAt(i);
							if(c < 48 || c > 57) {
								flag = true;
							}
						}
						
						//정상적인 핸드폰 번호를 입력했다면 탈출
						if(!flag && b.checkDup_phone(phone) == null) {break;}
					}
					
					//모두 잘 입력했을 때 오는 영역
					temp_obj = Bank.getInstance(choice);
					temp_obj.name = name;
					temp_obj.account = account;
					temp_obj.phone = phone;
					//암호화한 후 대입
					temp_obj.pw = b.encrypt(pw);

					//해당 은행이 무슨 은행인지(choice-1) : 행
					//몇번째 고객인지(Bank.arCnt[choice-1]) : 열
					
					Bank.arBank[choice-1][Bank.arCnt[choice-1]] = temp_obj;
//					System.out.println(Bank.arBank[choice-1][Bank.arCnt[choice-1]]);
					//해당 은행 고객 수 1증가
					Bank.arCnt[choice-1]++;
					System.out.println("계좌 개설 성공!");
					System.out.println(name + "님의 계좌번호 : " + account);
					break;
				// 입금(타행 입금 불가)
				case 2:
					System.out.print("계좌번호 : ");
					account = sc.next();
					System.out.print("비밀번호 : ");
					pw = sc.next();
					
					//로그인 성공시 해당 객체가 리턴된다.
					temp_obj = b.login(account, pw);
					if(temp_obj != null) {
						//로그인 성공시 들어옴
//						System.out.println(temp_obj.bank_num);
						if(temp_obj.bank_num != choice-1) {
							//고객의 은행번호와 현재 들어와 있는 은행이 다르면
							//입금 불가
							System.out.println(bank_name[temp_obj.bank_num]+ "에서 입금 가능합니다.");
							continue;
						}
						System.out.print("입금액 : ");
						money = sc.nextInt();
						temp_obj.deposit(money);
						System.out.println("입금 성공");
					}else {
						System.out.println("입금 실패 / 계좌번호 혹은 비밀번호 오류");
					}
					break;
				// 출금
				case 3:
					System.out.print("계좌번호 : ");
					account = sc.next();
					System.out.print("비밀번호 : ");
					pw = sc.next();
					
					temp_obj = b.login(account, pw);
					if(temp_obj != null) {
						System.out.print("출금액 : ");
						money = sc.nextInt();
						//잔액 부족이면 false, 성공이면 true 리턴
						if(temp_obj.withdraw(money)) {
							System.out.println("출금 성공");
							System.out.println("남은 잔액 : " + temp_obj.money + "원");
						}else {
							System.out.println("출금 실패 / 잔액 부족");
						}
					}else {
						System.out.println("출금 실패 / 계좌번호 혹은 비밀번호 오류");
					}
					break;
				// 잔액조회
				case 4:
					System.out.print("계좌번호 : ");
					account = sc.next();
					System.out.print("비밀번호 : ");
					pw = sc.next();
					
					temp_obj = b.login(account, pw);
					if(temp_obj != null) {
						//189, 190번째 줄 모두 같은 결과
//						System.out.println(temp_obj.toString());
						System.out.println(temp_obj);
					}else {
						System.out.println("계좌번호 혹은 비밀번호 오류");
					}
					break;
				// 계좌 찾기
				case 5:
					//핸드폰번호, 비밀번호
					System.out.print("개설시 입력한 핸드폰 번호 : ");
					phone = sc.next();
					
					temp_obj = b.checkDup_phone(phone);
					if(temp_obj != null) {
						System.out.print("비밀번호 : ");
						pw = sc.next();
						//기존 비밀번호는 암호화가 되어 있기 때문에
						//사용자가 입력한 비밀번호도 암호화 해준다.
						if(temp_obj.pw.equals(b.encrypt(pw))) {
							//새로운 계좌번호 생성
							while(true) {
								account = "" + (r.nextInt(900000) + 100000);
								if(b.checkDup_account(account) == null) {break;}
							}
							//새롭게 생성된 계좌번호로 변경
							temp_obj.account = account;
							System.out.println("본인확인 완료");
							System.out.println("새로운 계좌번호 : " + account);
						}
					}else {
						System.out.println("등록되지 않은 번호입니다.");
					}
					break;
				}
			}
		}
	}
}
