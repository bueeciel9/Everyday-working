package day02;

public class Casting2 {
	public static void main(String[] args) {
		//컴퓨터는 문자를 정수로 기억한다.
		//이러한 값을 아스키 코드값이라고 한다.
		char data = 67;
		System.out.println((char)(data + 3));
	}
}
