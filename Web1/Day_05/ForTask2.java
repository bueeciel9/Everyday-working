package day05;

public class ForTask2 {
	public static void main(String[] args) {
		// A~F���� �� C�����ϰ� ���(continue)
//		for(int i=0; i<6; i++) {
//			if(i == 2) {
//				continue;
//			}
//			System.out.println((char)(65+i));
//		}
		// 100~1���� �� 70������ ���(break)
//		for (int i = 0; i < 100; i++) {
//			System.out.println(100 - i);
//			if(i == 30) {
//				break;
//			}
//		}
		// 1~100���� �� 3�� 5�� ����� ���(���ǽ��� 2���� ����ϰ� continue ���)
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






