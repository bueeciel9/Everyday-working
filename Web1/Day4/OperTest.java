package day04;

public class OperTest {
	public static void main(String[] args) {
		//isTrue는 조건식이다.
		boolean isTrue = 10 != 10;
		System.out.println(10 > 4);
		System.out.println(10 > 4 && 10 != 10);
		System.out.println(!(10 > 4 || 10 != 10));
		System.out.println(isTrue);
	}
}
