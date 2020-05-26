package day04;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class IfTest {
	public static void main(String[] args) {
		//대소 비교
		String n1Msg = "첫번째 정수 입력";
		String n2Msg = "첫번째 정수 입력";
		
		String result = "";
		
		int num1 = 0, num2 = 0;
		
		num1 = Integer.parseInt(JOptionPane.showInputDialog(n1Msg));
		num2 = Integer.parseInt(JOptionPane.showInputDialog(n2Msg));
		
		if(num1 > num2) {
			result = "큰 값 : " + num1;
			
		}else if(num1 != num2) {
			result = "큰 값 : " + num2;
			
		}else {
			result = "두 수는 같습니다.";
		}
		JOptionPane.showMessageDialog(null, result);
	}
}





