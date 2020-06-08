package day16;

public class Starbucks {
	void regist(Cafe c) {
		String[] menu = c.getMenu();
		System.out.println("=====메뉴판=====");
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i+1 + ". " + menu[i]);
		}
		c.sell("아메리카노");
	}
}
