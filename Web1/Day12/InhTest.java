package day12;
class A{
	int data;
	
	public A() {
		System.out.println("�θ� ������ ȣ���");
	}

	public A(int data) {
		super();
		this.data = data;
	}

	void printData() {
		System.out.println(data);
	}
	
	void intro() {
		System.out.println("�ȳ��ϼ���");
	}
	
}
class B extends A{
	String name;
	
	public B() {}

	public B(String name) {
		super();
		System.out.println("�ڽ� ������ ȣ���");
		this.name = name;
	}
	
	public B(int data, String name) {
		super(data);
		this.name = name;
	}

	void printName() {
		System.out.println(name);
	}
	
	@Override
	void intro() {
		System.out.println(name + "�Դϴ�.");
		super.intro();
	}
	
}
public class InhTest {
	public static void main(String[] args) {
		B obj = new B(100, "�ѵ���");
		obj.printData();
		
	}
}







