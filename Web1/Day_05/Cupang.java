package cupang;

import javax.swing.JOptionPane;

public class Cupang {
	public static void main(String[] args) {
		String title = "▶쿠팡◀";
		String msg = "①쇼핑하기\n②쿠폰등록\n③포인트 조회\n④나가기\n";
		String good_bye_msg = "안녕히 가세요";
		String errMsg = "다시 시도해주세요";
		
		String A_category = "①패션/의류/잡화\n②생활 용품\n③메인 메뉴로 이동\n";
		
		String B1_category = "①여성 패션\n②남성 패션\n③메인 메뉴로 이동\n";
		String B2_category = "①화장지/물티슈\n②세탁세제\n③메인 메뉴로 이동\n";
		
		String C1_1_category = "①블라우스/셔츠\n②스커트/치마\n③메인 메뉴로 이동\n";
		String C1_2_category = "①티셔츠\n②트레이닝복\n③메인 메뉴로 이동\n";
		String C2_1_category = "①화장지\n②키친 타월\n③메인 메뉴로 이동\n";
		String C2_2_category = "①표백제\n②섬유 유연제\n③메인 메뉴로 이동\n";
		
		int choice = 0;
		
		while(choice != 4) {
			choice = Integer.parseInt(JOptionPane.showInputDialog(title + "\n" + msg));
			
			switch(choice) {
			//쇼핑하기
			case 1:
				break;
			//쿠폰등록
			case 2:
				break;
			//포인트 조회
			case 3:
				break;
			//나가기
			case 4:
				JOptionPane.showMessageDialog(null, good_bye_msg);
				break;
			//그 외 영역
			default:
				JOptionPane.showMessageDialog(null, errMsg);
			}
			
		}
		
	}
}
