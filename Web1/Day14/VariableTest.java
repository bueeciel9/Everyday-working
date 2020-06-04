package day14;

public class VariableTest {
	static int data_s = 10;
	int data = 10;
	
	public void increase() {
		System.out.println(++data);
	}
	
	public void increase_s() {
		System.out.println(++data_s);
	}
}
