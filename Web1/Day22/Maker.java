package bakery;

public class Maker implements Runnable {

	private BakeryPlate bread = new BakeryPlate();
	
//	public Maker(BakeryPlate bread) {
//		this.bread = bread;
//	}
	
	public BakeryPlate getBread() {
		return bread;
	}

	public void setBread(BakeryPlate bread) {
		this.bread = bread;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			bread.makeBread();
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
		System.out.println("영업 종료");
	}

}
