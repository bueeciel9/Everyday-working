package di;

public class Cook {
	private Knife knife;
	
	//의존성 주입
//	1. 생성자를 통해 전달 받음
//	public Cook(Knife knife) {
//		this.knife = knife;
//	}
//	2. setter를 통해 전달 받음
	public void setKnife(Knife knife) {
		this.knife = knife;
	}
	//의존성
//	public Cook() {
//		knife = new Knife();
//	}
	public void cook(Food food) {
		knife.cut(food);
	}
}
