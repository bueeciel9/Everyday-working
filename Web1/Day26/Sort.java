package sorting;

public interface Sort {

	void ascending(int [] arr); //�� �迭�� �ߴ��� ���ذ� �ȵǳ�
	void descending(int [] arr);
	
	default void description() {
		System.out.println("���ڸ� �����ϴ� �˰��� �Դϴ�.");
	}
}
