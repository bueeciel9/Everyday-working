package cupang;

import java.util.Random;

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

		String C1_1_category = "①노란색 블라우스￦50,000\n②봄 스커트￦60,000\n③메인 메뉴로 이동\n";
		String C1_2_category = "①티셔츠￦40,000\n②트레이닝복￦30,000\n③메인 메뉴로 이동\n";
		String C2_1_category = "①화장지￦2,000\n②키친 타월￦3,000\n③메인 메뉴로 이동\n";
		String C2_2_category = "①표백제￦7,000\n②섬유 유연제￦5,000\n③메인 메뉴로 이동\n";
		
		String C1_1_1_name = "노란색 블라우스";
		String C1_1_2_name = "봄 스커트";
		String C1_2_1_name = "티셔츠";
		String C1_2_2_name = "트레이닝복";
		String C2_1_1_name = "화장지";
		String C2_1_2_name = "키친타월";
		String C2_2_1_name = "표백제";
		String C2_2_2_name = "섬유 유연제";

		int C1_1_1_price = 50_000;
		int C1_1_2_price = 60_000;
		int C1_2_1_price = 40_000;
		int C1_2_2_price = 30_000;
		int C2_1_1_price = 2_000;
		int C2_1_2_price = 3_000;
		int C2_2_1_price = 7_000;
		int C2_2_2_price = 5_000;
		
		int choice = 0;
		
		int money = 1_000_000;
		int point = 0;
		//포인트 전액결제 Flag
		boolean pointCheck = false;
		
		/* 일괄처리를 위한 변수 */
		//사용자가 선택한 상품명
		String name = "";
		//사용자가 선택한 상품의 가격
		int price = 0;
		
		//난수를 발생시켜주는 메소드(nextInt())가 있는 클래스
		Random r = new Random();
		
		// x % y == 0 ~ y-1
		//1000 ~ 9999 - 1000
		//0 ~8999 + 1000
		int coupon = r.nextInt(9000) + 1000;
		
		//사용자가 입력한 쿠폰번호
		int myCoupon = 0;
		
		//봄 스커트 쿠폰 정보
		String C1_1_2_CouponMsg = "[봄 스커트 50%할인 쿠폰]\n";
		
		//사용자가 등록한 쿠폰 정보
		String myCouponMsg = "";
		
		//쿠폰 등록 Flag
		boolean couponCheck = false;
		
		//개발자 테스트 영역
//		System.out.println(coupon);
		
		//choice가 4일때 탈출 
		while (choice != 4) {
			//매 반복마다 pointCheck 초기화
			pointCheck = false;
			
			choice = Integer.parseInt(JOptionPane.showInputDialog(myCouponMsg + title + "\n" + msg));
			
			switch (choice) {
			// 쇼핑하기
			case 1:
				// 변수의 재사용
				// 1. 메모리 효율 상승
				// 2. 가독성이 떨어진다.
				choice = Integer.parseInt(JOptionPane.showInputDialog(A_category));
				
				// nested switch(중첩 switch문)
				switch (choice) {
				// 패션/의류/잡화
				case 1:
					choice = Integer.parseInt(JOptionPane.showInputDialog(B1_category));
					switch (choice) {
					// 여성 패션
					case 1:
						choice = Integer.parseInt(JOptionPane.showInputDialog(C1_1_category));
						switch (choice) {
						// 블라우스/셔츠
						case 1:
							//사용자가 선택한 상품의 정보를 담아서 페이지 하단에 전달
							//페이지 하단에서 일괄처리(잔액부족 및 결제, 포인트처리) 
							name = C1_1_1_name;
							price = C1_1_1_price;
							break;
						// 스커트/치마
						case 2:
							name = C1_1_2_name;
							price = C1_1_2_price;
							break;
						// 메인화면으로 이동
						case 3:
							continue;
						// 그 외
						default:
							JOptionPane.showMessageDialog(null, errMsg);
							continue;
						}
						break;
					// 남성 패션
					case 2:
						choice = Integer.parseInt(JOptionPane.showInputDialog(C1_2_category));
						switch (choice) {
						// 티셔츠
						case 1:
							name = C1_2_1_name;
							price = C1_2_1_price;
							break;
						// 트레이닝복
						case 2:
							name = C1_2_2_name;
							price = C1_2_2_price;
							break;
						// 메인화면으로 이동
						case 3:
							continue;
						// 그 외
						default:
							JOptionPane.showMessageDialog(null, errMsg);
						}
						break;
					// 메인 화면으로 이동
					case 3:
						continue;
					default:
						JOptionPane.showMessageDialog(null, errMsg);
						continue;
					}

					break;
				// 생활 용품
				case 2:
					choice = Integer.parseInt(JOptionPane.showInputDialog(B2_category));
					switch (choice) {
					//화장지/물티슈
					case 1:
						choice = Integer.parseInt(JOptionPane.showInputDialog(C2_1_category));
						switch (choice) {
						// 화장지
						case 1:
							name = C2_1_1_name;
							price = C2_1_1_price;
							break;
						// 키친 타월
						case 2:
							name = C2_1_2_name;
							price = C2_1_2_price;
							break;
						// 메인화면으로 이동
						case 3:
							continue;
						// 그 외
						default:
							JOptionPane.showMessageDialog(null, errMsg);
							continue;
						}
						break;
					// 세탁 세제
					case 2:
						choice = Integer.parseInt(JOptionPane.showInputDialog(C2_2_category));
						switch (choice) {
						// 표백제
						case 1:
							name = C2_2_1_name;
							price = C2_2_1_price;
							break;
						// 섬유 유연제
						case 2:
							name = C2_2_2_name;
							price = C2_2_2_price;
							break;
						// 메인화면으로 이동
						case 3:
							continue;
						// 그 외
						default:
							JOptionPane.showMessageDialog(null, errMsg);
							continue;
						}
						break;
					// 메인 화면으로 이동
					case 3:
						continue;
					default:
						JOptionPane.showMessageDialog(null, errMsg);
						continue;
					}
					break;
				// 메인 화면으로 이동
				case 3:
					continue;
				// 그 외
				default:
					JOptionPane.showMessageDialog(null, errMsg);
					//사용자가 상품을 선택하지 않았을 경우 밑의 결제로 내려가면 안된다.
					//따라서 continue를 사용하여 막아준다.
					continue;
				}
				break;
			// 쿠폰등록
			case 2:
				//쿠폰 등록시 재등록 불가
				if(!couponCheck) {
					myCoupon = Integer.parseInt(JOptionPane.showInputDialog("쿠폰 번호 4자리 : "));
					
					//사용자가 선택한 쿠폰과 쇼핑몰 쿠폰이 일치하는지 검사
					if(coupon == myCoupon) {
						//스커트 50%할인 쿠폰 등록 성공
						JOptionPane.showMessageDialog(null, "봄 스커트 50%할인 쿠폰 등록 성공!");
						//메인 화면에 뿌려질 메세지에 등록한 쿠폰 정보를 담아준다.
						myCouponMsg = C1_1_2_CouponMsg;
						couponCheck = true;
					}else {
						//잘못된 쿠폰번호
						JOptionPane.showMessageDialog(null, errMsg);
					}
				}else {
					//이미 등록한 사용자
					JOptionPane.showMessageDialog(null, "이미 등록하셨습니다.");
				}
				continue;
			// 포인트 조회
			case 3:
				JOptionPane.showMessageDialog(null, "잔여 포인트 : " + point + "점");
				continue;
			// 나가기
			case 4:
				JOptionPane.showMessageDialog(null, good_bye_msg);
				continue;
			// 그 외 영역
			default:
				JOptionPane.showMessageDialog(null, errMsg);
				continue;
			}
			//결제영역
			if(couponCheck && name.equals("봄 스커트")) {
				//쿠폰 소지자 && 봄 스커트 구매 희망자
				JOptionPane.showMessageDialog(null, "쿠폰 사용 완료!");
				couponCheck = false;
				
				//쿠폰을 사용했기 때문에 메인화면에 더 이상 쿠폰정보가 출력되 않는다.
				myCouponMsg = "";
				
				//50%가격으로 변경
				price *= 0.5;
				
				//이전 쿠폰번호와 중복되지 않도록 하기 위함.
				int temp = coupon;
				while(temp == coupon) {
					coupon = r.nextInt(9000) + 1000;
					//중복이 아니라면 탈출
				}
				//새로운 쿠폰번호 테스트 영역
//				System.out.println(coupon);
			}
			//상품 정상선택시 도착하는 영역 
			name += " 구매 ";
			//money < price
			if(money - price < 0) {
				//잔액부족
				name += "실패 / 잔액 부족";
			}else {
				//정상결제
				//현금결제, 포인트+현금결제, 포인트 결제
				//포인트가 1점이라도 있다면 자동 사용
				//포인트 결제일 때 현재잔액을 출력하지 않는다.
				name += "성공 / ";
				if(point > 0) {
					//포인트 + 현금
					if(point < price) {
						//결제할 가격에서 포인트만큼 차감 후 남은 금액을 현금으로 결제
						money -= price - point;
						//포인트 모두 사용
						point = 0;
					}else {
						//포인트
						point -= price;
						pointCheck = true;
					}
				}else {
					//현금 결제
					money -= price;
					//결제한 금액의 50% 적립
					point += price * 0.5;
				}
				//포인트 결제일 때에만 메세지를 변경해준다.
				name += pointCheck ? "포인트 사용 성공" : "현재 잔액 : " + money + "원";
			}
			JOptionPane.showMessageDialog(null, name);
		}//while 닫는 괄호
	}//main()닫는 괄호
}//class 닫는 괄호










