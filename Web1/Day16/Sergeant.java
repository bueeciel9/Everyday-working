package inter;

public class Sergeant extends Army{

	@Override
	public void eat() {
		System.out.println("PX로 달린다.");
	}

	@Override
	public void sleep() {
		System.out.println("계속 잔다.");
	}
}
