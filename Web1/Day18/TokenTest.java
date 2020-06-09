package str;

import java.util.StringTokenizer;

public class TokenTest {
	public static void main(String[] args) {
		String datas = "한동석,,남자,";
		String[] arData = datas.split(",",-1);
		for (int i = 0; i < arData.length; i++) {
			if(arData[i].equals("")) {
				System.out.println("선택안함");
				continue;
			}
			System.out.println(arData[i]);
		}
//		String str = "안녕하세요,반갑습니다,.한동석강사입니다!";
//		StringTokenizer token = new StringTokenizer(str, ",.!");
//		
//		while(token.hasMoreElements()) {
//			System.out.println(token.nextToken());
//		}
		
//		String[] arStr = str.split(",.!");
//		for (int i = 0; i < arStr.length; i++) {
//			System.out.println(arStr[i]);
//		}
	}
}
