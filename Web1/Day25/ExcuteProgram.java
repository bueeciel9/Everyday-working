package day25;

import java.util.ArrayList;

public class ExcuteProgram {
	public static void main(String[] args) {
		ArrayList<String> excute = new ArrayList<>();
		//�������α׷� ��ΰ��� ��α�
		/*
		 * https://m.blog.naver.com/PostView.nhn?blogId=bls1105&logNo=140209168251&proxyReferer=https:%2F%2Fwww.google.com%2F
		 * ���� C:\Windows\System32 >> �� ��� �ȿ� ����!
		 */
			
		//0��° �ε��� : ������ ���α׷� ���� ���
//		excute.add("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		//1��° �ε��� : url
//		excute.add("www.google.com");
//		excute.add("C:\\Windows\\System32\\calc.exe");
//		excute.add("C:\\Windows\\System32\\notepad.exe");
//		ProcessBuilder pb = new ProcessBuilder(excute);
		
		//������ ���α׷��� ��θ� �����ڿ� �ٷ� �־ �۵��Ѵ�.
		ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\System32\\calc.exe");
		
		try {
			pb.start();
		} catch (Exception e) {}
	}
}
