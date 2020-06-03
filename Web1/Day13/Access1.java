package access1;

class Access{
	void check() {
		Access1 a = new Access1();
		a.setData4("10");
		System.out.println(a.getData4());
	}
}

public class Access1 {
	
	String data1 = "1";
	public String data2 = "2";
	protected String data3 = "3";
	private String data4 = "4";
	
	public String getData4() {
		return data4;
	}

	public void setData4(String data4) {
		this.data4 = data4;
	}



	public static void main(String[] args) {
		new Access().check();
	}
}






