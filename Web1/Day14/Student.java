package day14;

public class Student {
	//��� ��ü�� �����ؾ� �� �����ʹ� static������ ��´�!!!!!!
	//������ ��ü�� �ƴ� Ŭ������ �����Ѵ�.
	//���� static������ Ŭ���������� �Ѵ�.
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
		Student s1 = new Student("�ѵ���");
		Student s2 = new Student("ȫ�浿");
		Student s3 = new Student("�̼���");
		Student s4 = new Student("�ظ�����");
		
		System.out.println(s1.num + "��");
		System.out.println(s2.num + "��");
		System.out.println(s3.num + "��");
		System.out.println(s4.num + "��");
		
	}
	
}









