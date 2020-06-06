package bank;

public class Bank {
	//모든 객체가 공유해야하는 저장소이므로 static을 붙여준다.
	
	//3개의 은행, 각 은행별 최대 고객 수 100(2차원 배열)
	static Bank[][] arBank = new Bank[3][100];
	//각 은행별 고객수를 저장할 수 있는 배열(1차원 배열)
	static int[] arCnt = new int[arBank.length];
	
	//KEY 값
	private final int KEY = 3;
	//예금주
	String name;
	//계좌번호
	String account;
	//핸드폰	번호
	String phone;
	//비밀번호
	String pw;
	//잔고
	int money;
	//고객의 은행번호
	int bank_num;
	
	//*계좌번호 중복검사
	//계좌번호를 받아와서 저장소에서 검색해주는 메소드
	//중복인지 아닌지 판단
	Bank checkDup_account(String account) {
		Bank b = null;
		//은행 개수만큼 반복
		for (int i = 0; i < arBank.length; i++) {
			//은행별 등록된 회원 수 만큼 반복
			for (int j = 0; j < arCnt[i]; j++) {
				//가입된 모든 고객의 계좌번호와 전달받은 계좌번호 비교
				if(arBank[i][j].account.equals(account)) {
					//b에 찾은 객체 저장
					b = arBank[i][j];
					//그 객체의 은행 번호에 행번호 저장
					//(고객의 은행번호 저장 0:신한,1:국민,2:우리)
					b.bank_num = i;
//					System.out.println(bank_num);
					break;
				}
			}
		}
		//계좌번호가 없다면 null, 있다면 찾은 객체 리턴
		return b;
	}
	
	//*핸드폰 번호 중복검사
	//위의 중복검사와 동일하지만 핸드폰 번호를 전달받아서
	//중복인지 아닌지 판단
	Bank checkDup_phone(String phone) {
		Bank b = null;
		for (int i = 0; i < arBank.length; i++) {
			for (int j = 0; j < arCnt[i]; j++) {
				if(arBank[i][j].phone.equals(phone)) {
					b = arBank[i][j];
					break;
				}
			}
		}
		return b;
	}
	
	//*로그인
	//외부에서 계좌번호와 비밀번호 전달받기
	//로그인 성공, 실패 판단하기
	Bank login(String account, String pw) {
		//계좌번호가 있다면 그 객체가 b에 담기고
		//없으면 null이 담긴다.
		Bank b = checkDup_account(account);
		if(b != null) {
			//계좌번호가 있다면 들어오는 영역
			if(!decrypt(b.pw).equals(pw)) {
				//비밀번호 오류시 들어오는 영역
				b = null;
			}
		}
		//로그인 실패 : null 리턴
		//로그인 성공 : 해당 객체 리턴
		return b;
	}
	//*암호화
	//외부에서 비밀번호 전달받고 아스키코드로 암호화 후 리턴
	String encrypt(String pw) {
		String result = "";
		for (int i = 0; i < pw.length(); i++) {
			//전달받은 pw문자열의 각 문자에 KEY값을 곱해준다.
			//그 후 result에 다시 누적연결해준다.
			//모든 문자가 암호화 된다.
			result += (char)(pw.charAt(i) * KEY);
		}
		//암호화된 비밀번호 리턴
		return result;
	}
	//*복호화
	//외부에서 암호화된 비밀번호 전달받고 복호화 후 리턴
	String decrypt(String en_pw) {
		String result = "";
		for (int i = 0; i < en_pw.length(); i++) {
			result += (char)(en_pw.charAt(i) / KEY);
		}
		return result;
	}
	//★입금
	//입금금액 전달받고 객체 통장에 돈 넣기
	void deposit(int money) {
		this.money += money;
	}
	
	//★출금
	//출금금액 전달받고 객체 통장에 돈 넣기
	//단, 잔액 부족 검사 필수!
	boolean withdraw(int money) {
		boolean check = false;
		
		if(money - this.money <= 0) {
			this.money -= money;
			check = true;
		}
		//잔액부족시 false, 아니면 true
		return check;
	}
	
	//잔액조회
	@Override
	public String toString() {
		//Object(최상위 클래스)에 있는 toString()은 객체를 출력할 때 
		//항상 생략되어 사용된다.
		//객체명.toString() == 객체명
		//따라서 주소가 아닌 원하는 값을 다루고 싶을 때에는
		//toString()을 재정의해준다.
		String msg = "계좌번호 : " + this.account +
				"\n예금주 : " + this.name +
				"\n현재 잔액 : " + this.money + "원";
		return msg;
	}
	
	static Bank getInstance(int bank_num) {
		//사용자가 선택한 은행에 맞는 새로운 객체를 리턴해준다. 
		if(bank_num == 1) {
			return new Shinhan();
		}else if(bank_num == 2) {
			return new Kookmin();
		}else if(bank_num == 3) {
			return new Woori();
		}
		return null;
	}
}





