package inter;

public class Pfc implements Soldier{

	@Override
	public void eat() {
		System.out.println("후임 식판과 선임 식판을 번갈아 보며 식사한다.");
	}

	@Override
	public void sleep() {
		System.out.println("잘 자다가 어디 간다.");
	}

	@Override
	public void work() {
		System.out.println("열심히 일하며 결과물이 좋다.");
	}

	@Override
	public void salute() {
		System.out.println("충!성!");
	}
}
