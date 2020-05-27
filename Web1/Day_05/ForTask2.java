package day05;

public class ForTask2 {
	public static void main(String[] args) {
		// A~F까지 중 C제외하고 출력(continue)
//		for(int i=0; i<6; i++) {
//			if(i == 2) {
//				continue;
//			}
//			System.out.println((char)(65+i));
//		}
		// 100~1까지 중 70까지만 출력(break)
//		for (int i = 0; i < 100; i++) {
//			System.out.println(100 - i);
//			if(i == 30) {
//				break;
//			}
//		}
		// 1~100까지 중 3과 5의 공배수 출력(조건식은 2개를 사용하고 continue 사용)
		//
		for (int i = 0; i < 100; i++) {
//			if (!((i + 1) % 3 == 0 && (i + 1) % 5 == 0)) {
//				continue;
//			}
			if( (i+1) % 3 != 0 || (i+1) % 5 != 0) {
				continue;
			}
			System.out.println(i + 1);
		}
	}
}






