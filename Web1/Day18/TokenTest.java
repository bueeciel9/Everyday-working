package str;

import java.util.StringTokenizer;

public class TokenTest {
	public static void main(String[] args) {
		String datas = "�ѵ���,,����,";
		String[] arData = datas.split(",",-1);
		for (int i = 0; i < arData.length; i++) {
			if(arData[i].equals("")) {
				System.out.println("���þ���");
				continue;
			}
			System.out.println(arData[i]);
		}
//		String str = "�ȳ��ϼ���,�ݰ����ϴ�,.�ѵ��������Դϴ�!";
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
