package atm;

public class ATM implements Runnable{
	int money = 10000;
	
	public void withdraw(int money) {
		this.money -= money;
		System.out.println(Thread.currentThread().getName() 
				+ "이(가) " + money + "원 출금");
		System.out.println("현재 잔액 : " + this.money + "원");
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			synchronized (this) {
				withdraw(1000);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					;
				}
			}
		}
	}
}





