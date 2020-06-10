package day19;

public class ForEachTest {
	public static void main(String[] args) {
		
		Object[][] arrObj = {{"ABC", 10},{3.156, 3.587F},{'a', "��ǻ��"}};
		
		//��� ��(���� for���� ���)
		//"ABC" 10
		//3.156 3.587F
		//'a' "��ǻ��"
		for(Object[] arObj : arrObj) {
			for(Object obj : arObj) {
				
				if(obj instanceof Float) {
					System.out.println(obj + "F");
					continue;
				}
				System.out.println(obj);
			}
		}
		
		//up casting
		//auto boxing
//		Object[] arObj = {"ABC", 'a', 10, 10.987};
//		
//		for(Object obj : arObj) {
//			System.out.println(obj);
//		}
	}
}



