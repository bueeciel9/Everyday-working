package day10;

public class MethodTask2 {
	// 1~n까지의 합을 println()으로 출력해주는 메소드
	void sumFrom1(int end) {
		if(end > 1) {
			int result = 0;
			for (int i = 0; i < end; i++) {
				result += i + 1;
			}
			System.out.println(result);
		}else {
			System.out.println("1보다 큰 수를 입력하세요");
		}
	}
	// 홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	int change(int num) {
		if(num < 0) {
			return -1;
		}
		return ++num;
	}
	// 대문자를 소문자로 변경해주는 메소드
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
	// 한글을 정수로 변경해주는 메소드(indexOf())
	int changeToInteger(String hangle) {
		String org_hangle = "공일이삼사오육칠팔구";
		String result = "";
		for (int i = 0; i < hangle.length(); i++) {
			result += "" + org_hangle.indexOf(hangle.charAt(i));
		}
		return Integer.parseInt(result);
	}
	
	public static void main(String[] args) {
		System.out.println(new MethodTask2().changeToInteger("공삼육구오공"));
//		int result = new MethodTask2().change(11);
//		
//		if(result == -1) {
//			System.out.println("음수는 입력할 수 없습니다.");
//		}else if(result % 2 == 0) {
//			System.out.println("짝수로 바뀌었습니다.");
//		}else {
//			System.out.println("홀수로 바뀌었습니다.");
//		}
	}
}





