package bank;

public class Bank {
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
	
	//*계좌번호 중복검사
	//계좌번호를 받아와서 저장소에서 검색해주는 메소드
	//중복인지 아닌지 판단
	Bank checkDup_account(String account) {
		Bank b = null;
		for (int i = 0; i < arBank.length; i++) {
			for (int j = 0; j < arCnt[i]; j++) {
				if(arBank[i][j].account.equals(account)) {
					b = arBank[i][j];
					break;
				}
			}
		}
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
		Bank b = checkDup_account(account);
		if(b != null) {
			if(!decrypt(b.pw).equals(pw)) {
				b = null;
			}
		}
		return b;
	}
	//*암호화
	//외부에서 비밀번호 전달받고 아스키코드로 암호화 후 리턴
	String encrypt(String pw) {
		String result = "";
		for (int i = 0; i < pw.length(); i++) {
			result += (char)(pw.charAt(i) * KEY);
		}
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
		return check;
	}
	
	//잔액조회
	@Override
	public String toString() {
		String msg = "계좌번호 : " + this.account +
				"\n예금주 : " + this.name +
				"\n현재 잔액 : " + this.money + "원";
		return msg;
	}
	
	static Bank getInstance(int bank_num) {
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





