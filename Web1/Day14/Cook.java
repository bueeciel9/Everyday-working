package di;

public class Cook {
	private Knife knife;
	
	//������ ����
//	1. �����ڸ� ���� ���� ����
//	public Cook(Knife knife) {
//		this.knife = knife;
//	}
//	2. setter�� ���� ���� ����
	public void setKnife(Knife knife) {
		this.knife = knife;
	}
	//������
//	public Cook() {
//		knife = new Knife();
//	}
	public void cook(Food food) {
		knife.cut(food);
	}
}
