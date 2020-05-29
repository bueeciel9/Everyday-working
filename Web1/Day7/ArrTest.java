package day07;

public class ArrTest {
	public static void main(String[] args) {
		int[][] arrData = new int[2][3];
		int length = arrData.length * arrData[0].length;
		int cnt = 0;
		// 1~6까지 넣기
		// 0 1 2 3 4 5 / 3 == 0 0 0 1 1 1
		// 0 1 2 3 4 5 % 3 == 0 1 2 0 1 2
		for (int i = 0; i < arrData.length; i++) {
			for (int j = 0; j < arrData[i].length; j++) {
				arrData[i][j] = ++cnt;
			}
		}
		for (int i = 0; i < arrData.length; i++) {
			for (int j = 0; j < arrData[i].length; j++) {
				System.out.println(arrData[i][j]);
			}
		}
		//		for (int i = 0; i < length; i++) {
//			arrData[i / 3][i % 3] = i + 1;
//		}
//		for (int i = 0; i < length; i++) {
//			System.out.println(arrData[i / 3][i % 3]);
//		}

	}
}
