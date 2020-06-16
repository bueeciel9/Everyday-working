package day25;

import java.util.ArrayList;

public class ExcuteProgram {
	public static void main(String[] args) {
		ArrayList<String> excute = new ArrayList<>();
		//실행프로그램 경로관련 블로그
		/*
		 * https://m.blog.naver.com/PostView.nhn?blogId=bls1105&logNo=140209168251&proxyReferer=https:%2F%2Fwww.google.com%2F
		 * 보통 C:\Windows\System32 >> 이 경로 안에 있음!
		 */
			
		//0번째 인덱스 : 실행할 프로그램 절대 경로
//		excute.add("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		//1번째 인덱스 : url
//		excute.add("www.google.com");
//		excute.add("C:\\Windows\\System32\\calc.exe");
//		excute.add("C:\\Windows\\System32\\notepad.exe");
//		ProcessBuilder pb = new ProcessBuilder(excute);
		
		//실행할 프로그램의 경로를 생성자에 바로 넣어도 작동한다.
		ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\System32\\calc.exe");
		
		try {
			pb.start();
		} catch (Exception e) {}
	}
}
