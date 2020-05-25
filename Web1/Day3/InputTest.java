package day03;

import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		//변수 선언시 넣을 지정된 값이 없을 때에는
		//초기값을 넣어줌으로써 초기화를 해준다.
		//정수 : 0
		//실수 : 0.0
		//문자 : ' '(공백문자)
		//문자열 : "", null
		
		String name = "";
		//클래스 안에 있는 메소드를 사용하고자 할 때에는
		//클래스타입의 변수를 선언 후 변수에 마침표를 찍어서 접근한다.
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		name = sc.next() + "님";
		
		System.out.println(name);
		//ctrl + 메소드 혹은 변수 클릭 : 선언된 부분으로 이동
		//기본 제공 라이브러리 메소드를 클릭하게 되면
		//설명글과 코드를 볼 수 있으나, 처음 눌렀을 때에는
		//위치를 알려주어야 한다.
		//attach source 클릭 > external 체크 > jdk폴더 안에 src.zip 더블클릭>
		sc.close();
		//한번 닫히면 절대 다시 열 수 없다.
	}
}



