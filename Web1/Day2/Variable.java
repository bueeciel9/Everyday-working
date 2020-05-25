package day02;

public class Variable {
	public static void main(String[] args) {
		int data1 = 10_000_000;
		float data2 = 2.2156F;
		double data3 = 2.2156;
		char data4 = 'a';
		String data5 = "ABC";
		
		System.out.printf("data1 : %d\n", data1);
		System.out.printf("data1 : %o\n", data1);
		System.out.printf("data1 : %x\n", data1);
		System.out.printf("data1 : %X\n", data1);
		//서식문자 %f는 반올림
		System.out.printf("data2 : %.1f\n", data2);
		System.out.printf("data3 : %.3f\n", data3);
		System.out.printf("data4 : %c\n", data4);
		System.out.printf("data5 : %s\n", data5);
		
	}
}
