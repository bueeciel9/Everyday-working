package bank;

public class Woori extends Bank {
	//잔액조회시 재산 반토막
	@Override
	public String toString() {
		this.money *= 0.5;
		return super.toString();
	}
}
