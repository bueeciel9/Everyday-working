package str;

public class StrTest {
	public String getType(String pathUrl) {
		return pathUrl.substring(pathUrl.lastIndexOf("."));
	}
	public static void main(String[] args) {
//		String url = "https://www.naver.com";
//		String url = "https://www.daum.net";
		String file = "E:\\web_1500_hds\\workspace\\day03\\src\\day03\\Dialog.java";
		//API사용 .com출력하기
//		System.out.println(url.substring(url.lastIndexOf(".")));
//		System.out.println(file.substring(file.lastIndexOf(".")));
		System.out.println(new StrTest().getType("www.google.com"));
	}
}
