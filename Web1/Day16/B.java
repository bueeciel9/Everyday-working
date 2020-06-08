package day16;

public class B extends A{
	@Override
	void init(int data) {
		data = 20;
		System.out.println(data);
	}
	
	
	public static void main(String[] args) {
		A obj = new A() {
			
			@Override
			void init(int data) {
				// TODO Auto-generated method stub
			}
		};
	}
	
}








