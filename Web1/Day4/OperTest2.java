package day04;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class OperTest2 {
	public static void main(String[] args) {
		//두 정수 입력
		Scanner sc = new Scanner(System.in);
		String msg = "-9999는 비교대상이 될 수 없습니다.";
		String n1Msg = "첫번째 정수를 입력하세요";
		String n2Msg = "두번째 정수를 입력하세요 ";
		
		String resultMsg = "";
		
		int num1 = 0, num2 = 0, result = 0;
		
		num1 = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		num2 = Integer.parseInt(JOptionPane.showInputDialog(n2Msg));
		
//		System.out.println(msg);
//		System.out.print(n1Msg);
//		num1 = sc.nextInt();
		
//		System.out.print(n2Msg);
//		num2 = sc.nextInt();
		
		//큰 값을 출력
		//결과적으로 resultMsg에는 num1, num2, 두 수는 같습니다. 셋 중 한 개의 값이 들어간다.
		resultMsg = num1 > num2 ? "큰 값 : " + num1 :
			//두 수가 같거나 num2가 크다면 false부분인 이 영역으로 온다.
			//한 번 더 삼항연산자를 사용해서 판단해준다.
			num1 == num2 ? "두 수는 같습니다." : "큰 값 : " + num2;
		
//		result = num1 > num2 ? num1 :
//			num1 == num2 ? -9999 : num2;
//		
//		resultMsg = result == -9999 ? "두 수는 같습니다." : "큰 값 : " + result;
		
//		System.out.println(resultMsg);
		JOptionPane.showMessageDialog(null, resultMsg);
	}
}





