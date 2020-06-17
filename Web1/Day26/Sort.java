package sorting;

public interface Sort {

	void ascending(int [] arr); //왜 배열로 했는지 이해가 안되네
	void descending(int [] arr);
	
	default void description() {
		System.out.println("숫자를 정렬하는 알고리즘 입니다.");
	}
}
