package day09;

public class HashTest {
	void init(int[] data) {
		data[0] = 10;
	}
	
	public static void main(String[] args) {
		int[] data = {100};
		new HashTest().init(data);
		System.out.println(data[0]);
	}
}
