package day16;
//���߱���
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
		
		//upcasting�� ��ü�� downcasting�� �ϴ� ����
		//upcasting�Ǹ鼭 �ڽ�Ŭ������ ���Ӱ� �߰��� �ʵ�� ��� �߷��� ����.
		//���� �ڽ� �ʵ忡�� ���� �߰��� ����� ��� ����ϰ� �ʹٸ�
		//downcasting�� �ؾ��Ѵ�.
		
		//instanceof�� ����ؾ� �ϴ� ����
		//upcasting�� ��ü�� � �ڽİ��� �� �ִ����� �˻��� �ʿ䰡 �ִ�.
		//�� �ִ� �ڽ� Ÿ�Կ� �°� downcasting�� �ϱ� ���� ����Ѵ�.
		System.out.println(t instanceof Transportation); // ��
		System.out.println(t instanceof Bus); // ����
		System.out.println(b instanceof Bus);// ��
		System.out.println(b instanceof Transportation); // ��
		System.out.println(upcasting_obj instanceof Bus); // ��
		System.out.println(upcasting_obj instanceof Transportation); // ��
		System.out.println(downcasting_obj instanceof Bus); //��
		System.out.println(downcasting_obj instanceof Transportation); // ��
		
////		Object data = new Double(3.15);
//		Object data = 3.15F;
//		
//		//1, 3.4, 'a', "�ȳ�"
//		Object[] arData = {1, 3.4, 'a', "�ȳ�"};
//		for(Object obj : arData) {
//			System.out.println(obj);
//		}
//		
//		System.out.println(new Integer(10) instanceof Integer);
//		System.out.println("�ȳ�" instanceof String);
//		System.out.println(new Float(3.156F) instanceof Float);
//		System.out.println(data instanceof Float);
	}
}







