package day10;

public class MethodTask2 {
	// 1~n������ ���� println()���� ������ִ� �޼ҵ�
	void sumFrom1(int end) {
		if(end > 1) {
			int result = 0;
			for (int i = 0; i < end; i++) {
				result += i + 1;
			}
			System.out.println(result);
		}else {
			System.out.println("1���� ū ���� �Է��ϼ���");
		}
	}
	// Ȧ���� ¦����, ¦���� Ȧ���� �ٲ��ִ� �޼ҵ�
	int change(int num) {
		if(num < 0) {
			return -1;
		}
		return ++num;
	}
	// �빮�ڸ� �ҹ��ڷ� �������ִ� �޼ҵ�
	String changeToLowerCase(String str) {
		String result = "";
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c >= 65 && c <= 90) {
				result += (char)(c + 32);
			}else {
				result += c;
			}
		}
		return result;
	}
	// �ѱ��� ������ �������ִ� �޼ҵ�(indexOf())
	int changeToInteger(String hangle) {
		String org_hangle = "�����̻�����ĥ�ȱ�";
		String result = "";
		for (int i = 0; i < hangle.length(); i++) {
			result += "" + org_hangle.indexOf(hangle.charAt(i));
		}
		return Integer.parseInt(result);
	}
	
	public static void main(String[] args) {
		System.out.println(new MethodTask2().changeToInteger("������������"));
//		int result = new MethodTask2().change(11);
//		
//		if(result == -1) {
//			System.out.println("������ �Է��� �� �����ϴ�.");
//		}else if(result % 2 == 0) {
//			System.out.println("¦���� �ٲ�����ϴ�.");
//		}else {
//			System.out.println("Ȧ���� �ٲ�����ϴ�.");
//		}
	}
}





