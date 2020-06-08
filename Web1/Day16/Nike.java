package day16;

public class Nike {
	//등록하는 메소드 선언
	//매개변수로 Store객체 전달받기
	//메뉴판 출력
	
	//상품을 구매하는 메소드
	void regist_to_sell(Store s) {
		String[] menus = s.getMenu();
		System.out.println("=====상품목록=====");
		for (int i = 0; i < menus.length; i++) {
			System.out.println(i+1 + ". " + menus[i]);
		}
		
		s.sell("티셔츠");
		
	}
	//상품을 구매하지 않는 메소드
	void regist(Store s) {
		String[] menus = s.getMenu();
		System.out.println("=====상품목록=====");
		for (int i = 0; i < menus.length; i++) {
			System.out.println(i+1 + ". " + menus[i]);
		}
	}
	
	
	
}
