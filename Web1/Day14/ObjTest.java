package day14;

public class ObjTest {
	
	String name;

	public ObjTest() {}
	
	public ObjTest(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public static void main(String[] args) {
		ObjTest obj = new ObjTest("ÇÑµ¿¼®");
		System.out.println(obj);
		System.out.println(obj.toString());
	}
}
