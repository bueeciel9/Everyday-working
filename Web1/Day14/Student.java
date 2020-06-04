package day14;

public class Student {
	//모든 객체가 공유해야 할 데이터는 static변수에 담는다!!!!!!
	//접근은 객체가 아닌 클래스로 접근한다.
	//따라서 static변수를 클래스변수라 한다.
	static int cnt;
	int num;
	String name;
	
	public Student() {}

	public Student(String name) {
		super();
		cnt++;
		this.name = name;
		this.num = cnt;
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("한동석");
		Student s2 = new Student("홍길동");
		Student s3 = new Student("이순신");
		Student s4 = new Student("해리포터");
		
		System.out.println(s1.num + "번");
		System.out.println(s2.num + "번");
		System.out.println(s3.num + "번");
		System.out.println(s4.num + "번");
		
	}
	
}









