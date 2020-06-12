package bakery;

import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		Maker maker = new Maker();
		BakeryPlate bread = maker.getBread();
		
		Thread t = new Thread(maker);
		
		int choice = 0;
		String[] menu = {"»§ ¸Ô±â"};
		
		t.start();
		
		while(true) {
			choice = JOptionPane.showOptionDialog(null,
					"", "ÆÄ¸®¹Ù°ÔÆ®", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, menu, null);
			
			if(choice == -1) {
				System.exit(0);
			}else {
				bread.eatBread();
			}
		}
	}
}






