package bakery;

public class BakeryPlate {
	int breadCnt;
	int eatCnt;
	
	synchronized public void makeBread() {
		if(breadCnt > 9) {
			try {
				System.out.println("»§ÀÌ °¡µæ Ã¡½À´Ï´Ù. ¸ÔÀ¸¼¼¿ä.");
				wait();
			} catch (InterruptedException e) {;}
		}
		breadCnt++;
		System.out.println("»§À» 1°³ ¸¸µé¾ú½À´Ï´Ù. ÃÑ : " + breadCnt + "°³");
	}
	
	synchronized public void eatBread() {
		if(eatCnt == 20) {
			System.out.println("»§ÀÌ ´Ù ¶³¾îÁ³½À´Ï´Ù.");
		}else if(breadCnt < 1) {
			System.out.println("±â´Ù¸®¼¼¿ä.");
		}else {
			breadCnt --;
			eatCnt++;
			System.out.println("»§À» 1°³ ¸Ô¾ú½À´Ï´Ù. ÃÑ : " + breadCnt + "°³");
		}
		this.notify();
	}
}








