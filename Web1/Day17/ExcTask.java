package exception;

public class ExcTask {
	public static void main(String[] args) {

		try {
			System.out.println(10 / 0);
		} catch (Exception e) {;}
		System.out.println("반드시 출력되어야 하는 문장");
		
		//5칸 배열에 6개의 값을 넣을 때
		//try~catch문으로 오류 메시지 출력
//		int[] arData = new int[5];
//		try {
////			arData[5] = 10;
//			for (int i = 0; i < arData.length+1; i++) {
//				arData[i] = i+1;
//			}
//		} catch (Exception e) {
//			System.out.println("인덱스 초과");
//		}
	}
}
