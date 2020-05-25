package day03;

import javax.swing.JOptionPane;

public class Dialog {
	public static void main(String[] args) {
//		JOptionPane.showMessageDialog(null, "안녕");
//		String name = JOptionPane.showInputDialog("이름을 입력하세요");
//		JOptionPane.showMessageDialog(null, name + "님 환영합니다.");
		
		//두 정수를 입력받고 몫과 나머지 출력
		//몫 : 정수 / 정수
		//나머지 : 정수 % 정수 (예 : 10 % 3 == 1)
		//대화상자 사용
		
		int num1 = 0;
		int num2 = 0;
		int value = 0;
		int rest = 0;
		
		String n1Msg = "첫번째 정수를 입력하세요";
		String n2Msg = "두번째 정수를 입력하세요";
		String result = "";
		
		num1 = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		num2 = Integer.parseInt(JOptionPane.showInputDialog(n2Msg));
		
		value = num1 / num2;
		rest = num1 % num2;
		
		result = String.format("[결과]\n%d/%d=%d\n%d%%%d=%d",
				num1, num2, value, num1, num2, rest);
		
		//[결과]
		//10 / 3 = 3\n
		//10 % 3 = 1\n

		JOptionPane.showMessageDialog(null, result);
		
	}
}







