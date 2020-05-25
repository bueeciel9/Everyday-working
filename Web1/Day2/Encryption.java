package day02;

public class Encryption {
	public static void main(String[] args) {
		//기존 pw
		String pw = "a1b2c3";
		//암호화된 pw
		String en_pw = "";
		//복호화된 pw
		String de_pw = "";
		
		//KEY값
		int key = 3;
		
		//암호화
		for (int i = 0; i < pw.length(); i++) {
			//문자*정수 = 정수 (자동 형변환)
			//(char)(문자*정수) = 문자 (강제 형변환)
			en_pw += (char)(pw.charAt(i) * key); 
		}
		//복호화
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / key); 
		}
		
		System.out.printf("기존 :  %s\n", pw);
		System.out.printf("암호화 :  %s\n", en_pw);
		System.out.printf("복호화 :  %s\n", de_pw);
	}
}
