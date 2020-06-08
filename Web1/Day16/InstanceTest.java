package day16;
//대중교통
class Transportation{
}

class Bus extends Transportation{
}

public class InstanceTest {
	public static void main(String[] args) {
		
		Transportation t = new Transportation();
		Bus b = new Bus();
		
		Transportation upcasting_obj = new Bus();
		Bus downcasting_obj = (Bus) upcasting_obj;
		
		//upcasting된 객체를 downcasting을 하는 이유
		//upcasting되면서 자식클래스에 새롭게 추가된 필드는 모두 잘려서 들어간다.
		//따라서 자식 필드에서 새로 추가된 기능을 모두 사용하고 싶다면
		//downcasting을 해야한다.
		
		//instanceof를 사용해야 하는 이유
		//upcasting된 객체에 어떤 자식값이 들어가 있는지를 검사할 필요가 있다.
		//들어가 있는 자식 타입에 맞게 downcasting을 하기 위해 사용한다.
		System.out.println(t instanceof Transportation); // 참
		System.out.println(t instanceof Bus); // 거짓
		System.out.println(b instanceof Bus);// 참
		System.out.println(b instanceof Transportation); // 참
		System.out.println(upcasting_obj instanceof Bus); // 참
		System.out.println(upcasting_obj instanceof Transportation); // 참
		System.out.println(downcasting_obj instanceof Bus); //참
		System.out.println(downcasting_obj instanceof Transportation); // 참
		
////		Object data = new Double(3.15);
//		Object data = 3.15F;
//		
//		//1, 3.4, 'a', "안녕"
//		Object[] arData = {1, 3.4, 'a', "안녕"};
//		for(Object obj : arData) {
//			System.out.println(obj);
//		}
//		
//		System.out.println(new Integer(10) instanceof Integer);
//		System.out.println("안녕" instanceof String);
//		System.out.println(new Float(3.156F) instanceof Float);
//		System.out.println(data instanceof Float);
	}
}







