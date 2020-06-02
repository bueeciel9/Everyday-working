package day12;
class A{
	int data;
	
	public A() {
		System.out.println("부모 생성자 호출됨");
	}

	public A(int data) {
		super();
		this.data = data;
	}

	void printData() {
		System.out.println(data);
	}
	
	void intro() {
		System.out.println("안녕하세요");
	}
	
}
class B extends A{
	String name;
	
	public B() {}

	public B(String name) {
		super();
		System.out.println("자식 생성자 호출됨");
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
		System.out.println(name + "입니다.");
		super.intro();
	}
	
}
public class InhTest {
	public static void main(String[] args) {
		B obj = new B(100, "한동석");
		obj.printData();
		
	}
}







