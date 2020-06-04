package bank;

public class Bank {
	//3���� ����, �� ���ະ �ִ� �� �� 100(2���� �迭)
	static Bank[][] arBank = new Bank[3][100];
	//�� ���ະ ������ ������ �� �ִ� �迭(1���� �迭)
	static int[] arCnt = new int[arBank.length];
	
	//KEY ��
	private final int KEY = 3;
	//������
	String name;
	//���¹�ȣ
	String account;
	//�ڵ���	��ȣ
	String phone;
	//��й�ȣ
	String pw;
	//�ܰ�
	int money;
	
	//*���¹�ȣ �ߺ��˻�
	//���¹�ȣ�� �޾ƿͼ� ����ҿ��� �˻����ִ� �޼ҵ�
	//�ߺ����� �ƴ��� �Ǵ�
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
	
	//*�ڵ��� ��ȣ �ߺ��˻�
	//���� �ߺ��˻�� ���������� �ڵ��� ��ȣ�� ���޹޾Ƽ�
	//�ߺ����� �ƴ��� �Ǵ�
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
	
	//*�α���
	//�ܺο��� ���¹�ȣ�� ��й�ȣ ���޹ޱ�
	//�α��� ����, ���� �Ǵ��ϱ�
	Bank login(String account, String pw) {
		Bank b = checkDup_account(account);
		if(b != null) {
			if(!decrypt(b.pw).equals(pw)) {
				b = null;
			}
		}
		return b;
	}
	//*��ȣȭ
	//�ܺο��� ��й�ȣ ���޹ް� �ƽ�Ű�ڵ�� ��ȣȭ �� ����
	String encrypt(String pw) {
		String result = "";
		for (int i = 0; i < pw.length(); i++) {
			result += (char)(pw.charAt(i) * KEY);
		}
		return result;
	}
	
	//*��ȣȭ
	//�ܺο��� ��ȣȭ�� ��й�ȣ ���޹ް� ��ȣȭ �� ����
	String decrypt(String en_pw) {
		String result = "";
		for (int i = 0; i < en_pw.length(); i++) {
			result += (char)(en_pw.charAt(i) / KEY);
		}
		return result;
	}
	//���Ա�
	//�Աݱݾ� ���޹ް� ��ü ���忡 �� �ֱ�
	void deposit(int money) {
		this.money += money;
	}
	
	//�����
	//��ݱݾ� ���޹ް� ��ü ���忡 �� �ֱ�
	//��, �ܾ� ���� �˻� �ʼ�!
	boolean withdraw(int money) {
		boolean check = false;
		if(money - this.money <= 0) {
			this.money -= money;
			check = true;
		}
		return check;
	}
	
	//�ܾ���ȸ
	@Override
	public String toString() {
		String msg = "���¹�ȣ : " + this.account +
				"\n������ : " + this.name +
				"\n���� �ܾ� : " + this.money + "��";
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





