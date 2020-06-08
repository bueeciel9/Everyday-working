package inner;

import javax.swing.JFrame;

class Out{
	int out_data = 100;
	
	public Out() {}
	
	public void printOut_data(){
		System.out.println(out_data);
	}
	
	class In extends JFrame{
		int in_data = 50;
		
		public In() {}
		
		void printInData() {
			out_data = 10000;
			printOut_data();
			System.out.println(in_data);
		}
		
	}
}
public class InnerTest {
	public static void main(String[] args) {
		Out out = new Out();
		Out.In in = out.new In();
		in.printInData();
	}
}










