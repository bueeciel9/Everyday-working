package day16;

public class Seoul {
	public static void main(String[] args) {
		//강남점은 판매하지만
		Nike gangnam = new Nike();
		
		//신촌점은 판매하지 않는다(sell을 구현하지 않는다).
		Nike shinchon = new Nike();
		
		
		gangnam.regist_to_sell(new Store() {
			
			@Override
			public void sell(String choice) {
				String[] lists = getMenu();
				for (int i = 0; i < lists.length; i++) {
					if(lists[i].equals(choice)) {
						System.out.println(choice + " 판매 성공");
					}
				}
			}
			
			@Override
			public String[] getMenu() {
				String[] lists = {"반바지", "티셔츠"};
				return lists;
			}
		});
		
		shinchon.regist(new StoreAdapter() {
			@Override
			public String[] getMenu() {
				String[] lists = {"양말", "장갑", "가방"};
				return lists;
			}
		});
		
	}
}








