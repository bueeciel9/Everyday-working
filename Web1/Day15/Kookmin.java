package bank;

public class Kookmin extends Bank {
	//출금시 수수료 50%
	//100만원을 뽑는다. 그러면 150만원이 필요하다
	//100 ????? 150
	//1.5
	//반드시 super를 사용하기
	@Override
	boolean withdraw(int money) {
		money *= 1.5;
		return super.withdraw(money);
	}
}
