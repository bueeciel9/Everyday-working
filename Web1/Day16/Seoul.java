package day16;

public class Seoul {
	public static void main(String[] args) {
		//�������� �Ǹ�������
		Nike gangnam = new Nike();
		
		//�������� �Ǹ����� �ʴ´�(sell�� �������� �ʴ´�).
		Nike shinchon = new Nike();
		
		
		gangnam.regist_to_sell(new Store() {
			
			@Override
			public void sell(String choice) {
				String[] lists = getMenu();
				for (int i = 0; i < lists.length; i++) {
					if(lists[i].equals(choice)) {
						System.out.println(choice + " �Ǹ� ����");
					}
				}
			}
			
			@Override
			public String[] getMenu() {
				String[] lists = {"�ݹ���", "Ƽ����"};
				return lists;
			}
		});
		
		shinchon.regist(new StoreAdapter() {
			@Override
			public String[] getMenu() {
				String[] lists = {"�縻", "�尩", "����"};
				return lists;
			}
		});
		
	}
}








