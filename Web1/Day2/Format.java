package day02;

public class Format {
	public static void main(String[] args) {
		int data1 = 10, data2 = 20, data3 = 30;
		
		//달러 심볼
		//원하는 위치의 값을 가지고 올 때 사용한다.
		System.out.printf("%3$d, %2$d, %1$d\n", data1, data2, data3);
		
	}
}
