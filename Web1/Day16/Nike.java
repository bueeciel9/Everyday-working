package day16;

public class Nike {
	//����ϴ� �޼ҵ� ����
	//�Ű������� Store��ü ���޹ޱ�
	//�޴��� ���
	
	//��ǰ�� �����ϴ� �޼ҵ�
	void regist_to_sell(Store s) {
		String[] menus = s.getMenu();
		System.out.println("=====��ǰ���=====");
		for (int i = 0; i < menus.length; i++) {
			System.out.println(i+1 + ". " + menus[i]);
		}
		
		s.sell("Ƽ����");
		
	}
	//��ǰ�� �������� �ʴ� �޼ҵ�
	void regist(Store s) {
		String[] menus = s.getMenu();
		System.out.println("=====��ǰ���=====");
		for (int i = 0; i < menus.length; i++) {
			System.out.println(i+1 + ". " + menus[i]);
		}
	}
	
	
	
}
