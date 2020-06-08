package inter;

public class Corporal implements Soldier{

	@Override
	public void eat() {
		System.out.println("경치를 보며 식사한다.");
	}

	@Override
	public void sleep() {
		System.out.println("잘 잔다.");
	}

	@Override
	public void work() {
		System.out.println("후임 시킨다.");
	}

	@Override
	public void salute() {
		System.out.println("ㅊㅅ");
	}
}
