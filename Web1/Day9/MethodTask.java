package day09;

public class MethodTask {
	//1~10까지 println()으로 출력하는 메소드
	//1~10까지의 합을 구해주는 메소드
	//1~n까지의 합을 println()으로 출력해주는 메소드
	
	//이름을 n번 println()으로 출력하는 메소드
	//재귀 메소드
	//장점 소스코드가 간결해진다.
	//단점 소스코드가 어려워진다.
	void printName(String name, int n) {
		if(n == 0) {
			return;
		}else {
			System.out.println(name);
			printName(name, --n);
		}
	}
	//홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	//대문자를 소문자로 변경해주는 메소드
	//한글을 정수로 변경해주는 메소드
	
	//5개의 정수를 받아서 최대값과 최소값을 구해주는 메소드
	void getMaxAndMin(int[] arData, int[] result) {
		for(int i=0; i<result.length; i++) {
			result[i] = arData[0];
		}
		for (int i = 1; i < arData.length; i++) {
			if(result[0] < arData[i]) {result[0] = arData[i];}
			if(result[1] > arData[i]) {result[1] = arData[i];}
		}		
	}
	public static void main(String[] args) {
		new MethodTask().printName("한동석", 10);
//		int[] result = new int[2];
//		int[] arData = {4, 2, 1, 7, 8};
//		new MethodTask().getMaxAndMin(arData, result);
//		System.out.println("최대값 : " + result[0]);
//		System.out.println("최소값 : " + result[1]);
		
	}
}











