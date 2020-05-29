package cupang;

import java.util.Random;

import javax.swing.JOptionPane;

public class Cupang {
	public static void main(String[] args) {
		String title = "�����΢�";
		String msg = "������ϱ�\n���������\n������Ʈ ��ȸ\n�곪����\n";
		String good_bye_msg = "�ȳ��� ������";
		String errMsg = "�ٽ� �õ����ּ���";

		String A_category = "���м�/�Ƿ�/��ȭ\n���Ȱ ��ǰ\n����� �޴��� �̵�\n";

		String B1_category = "�翩�� �м�\n�賲�� �м�\n����� �޴��� �̵�\n";
		String B2_category = "��ȭ����/��Ƽ��\n�輼Ź����\n����� �޴��� �̵�\n";

		String C1_1_category = "������ ���콺��50,000\n�躽 ��ĿƮ��60,000\n����� �޴��� �̵�\n";
		String C1_2_category = "��Ƽ������40,000\n��Ʈ���̴׺���30,000\n����� �޴��� �̵�\n";
		String C2_1_category = "��ȭ������2,000\n��Űģ Ÿ����3,000\n����� �޴��� �̵�\n";
		String C2_2_category = "��ǥ������7,000\n�輶�� ��������5,000\n����� �޴��� �̵�\n";
		
		String C1_1_1_name = "����� ���콺";
		String C1_1_2_name = "�� ��ĿƮ";
		String C1_2_1_name = "Ƽ����";
		String C1_2_2_name = "Ʈ���̴׺�";
		String C2_1_1_name = "ȭ����";
		String C2_1_2_name = "ŰģŸ��";
		String C2_2_1_name = "ǥ����";
		String C2_2_2_name = "���� ������";

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
		//����Ʈ ���װ��� Flag
		boolean pointCheck = false;
		
		/* �ϰ�ó���� ���� ���� */
		//����ڰ� ������ ��ǰ��
		String name = "";
		//����ڰ� ������ ��ǰ�� ����
		int price = 0;
		
		//������ �߻������ִ� �޼ҵ�(nextInt())�� �ִ� Ŭ����
		Random r = new Random();
		
		// x % y == 0 ~ y-1
		//1000 ~ 9999 - 1000
		//0 ~8999 + 1000
		int coupon = r.nextInt(9000) + 1000;
		
		//����ڰ� �Է��� ������ȣ
		int myCoupon = 0;
		
		//�� ��ĿƮ ���� ����
		String C1_1_2_CouponMsg = "[�� ��ĿƮ 50%���� ����]\n";
		
		//����ڰ� ����� ���� ����
		String myCouponMsg = "";
		
		//���� ��� Flag
		boolean couponCheck = false;
		
		//������ �׽�Ʈ ����
//		System.out.println(coupon);
		
		//choice�� 4�϶� Ż�� 
		while (choice != 4) {
			//�� �ݺ����� pointCheck �ʱ�ȭ
			pointCheck = false;
			
			choice = Integer.parseInt(JOptionPane.showInputDialog(myCouponMsg + title + "\n" + msg));
			
			switch (choice) {
			// �����ϱ�
			case 1:
				// ������ ����
				// 1. �޸� ȿ�� ���
				// 2. �������� ��������.
				choice = Integer.parseInt(JOptionPane.showInputDialog(A_category));
				
				// nested switch(��ø switch��)
				switch (choice) {
				// �м�/�Ƿ�/��ȭ
				case 1:
					choice = Integer.parseInt(JOptionPane.showInputDialog(B1_category));
					switch (choice) {
					// ���� �м�
					case 1:
						choice = Integer.parseInt(JOptionPane.showInputDialog(C1_1_category));
						switch (choice) {
						// ���콺/����
						case 1:
							//����ڰ� ������ ��ǰ�� ������ ��Ƽ� ������ �ϴܿ� ����
							//������ �ϴܿ��� �ϰ�ó��(�ܾ׺��� �� ����, ����Ʈó��) 
							name = C1_1_1_name;
							price = C1_1_1_price;
							break;
						// ��ĿƮ/ġ��
						case 2:
							name = C1_1_2_name;
							price = C1_1_2_price;
							break;
						// ����ȭ������ �̵�
						case 3:
							continue;
						// �� ��
						default:
							JOptionPane.showMessageDialog(null, errMsg);
							continue;
						}
						break;
					// ���� �м�
					case 2:
						choice = Integer.parseInt(JOptionPane.showInputDialog(C1_2_category));
						switch (choice) {
						// Ƽ����
						case 1:
							name = C1_2_1_name;
							price = C1_2_1_price;
							break;
						// Ʈ���̴׺�
						case 2:
							name = C1_2_2_name;
							price = C1_2_2_price;
							break;
						// ����ȭ������ �̵�
						case 3:
							continue;
						// �� ��
						default:
							JOptionPane.showMessageDialog(null, errMsg);
						}
						break;
					// ���� ȭ������ �̵�
					case 3:
						continue;
					default:
						JOptionPane.showMessageDialog(null, errMsg);
						continue;
					}

					break;
				// ��Ȱ ��ǰ
				case 2:
					choice = Integer.parseInt(JOptionPane.showInputDialog(B2_category));
					switch (choice) {
					//ȭ����/��Ƽ��
					case 1:
						choice = Integer.parseInt(JOptionPane.showInputDialog(C2_1_category));
						switch (choice) {
						// ȭ����
						case 1:
							name = C2_1_1_name;
							price = C2_1_1_price;
							break;
						// Űģ Ÿ��
						case 2:
							name = C2_1_2_name;
							price = C2_1_2_price;
							break;
						// ����ȭ������ �̵�
						case 3:
							continue;
						// �� ��
						default:
							JOptionPane.showMessageDialog(null, errMsg);
							continue;
						}
						break;
					// ��Ź ����
					case 2:
						choice = Integer.parseInt(JOptionPane.showInputDialog(C2_2_category));
						switch (choice) {
						// ǥ����
						case 1:
							name = C2_2_1_name;
							price = C2_2_1_price;
							break;
						// ���� ������
						case 2:
							name = C2_2_2_name;
							price = C2_2_2_price;
							break;
						// ����ȭ������ �̵�
						case 3:
							continue;
						// �� ��
						default:
							JOptionPane.showMessageDialog(null, errMsg);
							continue;
						}
						break;
					// ���� ȭ������ �̵�
					case 3:
						continue;
					default:
						JOptionPane.showMessageDialog(null, errMsg);
						continue;
					}
					break;
				// ���� ȭ������ �̵�
				case 3:
					continue;
				// �� ��
				default:
					JOptionPane.showMessageDialog(null, errMsg);
					//����ڰ� ��ǰ�� �������� �ʾ��� ��� ���� ������ �������� �ȵȴ�.
					//���� continue�� ����Ͽ� �����ش�.
					continue;
				}
				break;
			// �������
			case 2:
				//���� ��Ͻ� ���� �Ұ�
				if(!couponCheck) {
					myCoupon = Integer.parseInt(JOptionPane.showInputDialog("���� ��ȣ 4�ڸ� : "));
					
					//����ڰ� ������ ������ ���θ� ������ ��ġ�ϴ��� �˻�
					if(coupon == myCoupon) {
						//��ĿƮ 50%���� ���� ��� ����
						JOptionPane.showMessageDialog(null, "�� ��ĿƮ 50%���� ���� ��� ����!");
						//���� ȭ�鿡 �ѷ��� �޼����� ����� ���� ������ ����ش�.
						myCouponMsg = C1_1_2_CouponMsg;
						couponCheck = true;
					}else {
						//�߸��� ������ȣ
						JOptionPane.showMessageDialog(null, errMsg);
					}
				}else {
					//�̹� ����� �����
					JOptionPane.showMessageDialog(null, "�̹� ����ϼ̽��ϴ�.");
				}
				continue;
			// ����Ʈ ��ȸ
			case 3:
				JOptionPane.showMessageDialog(null, "�ܿ� ����Ʈ : " + point + "��");
				continue;
			// ������
			case 4:
				JOptionPane.showMessageDialog(null, good_bye_msg);
				continue;
			// �� �� ����
			default:
				JOptionPane.showMessageDialog(null, errMsg);
				continue;
			}
			//��������
			if(couponCheck && name.equals("�� ��ĿƮ")) {
				//���� ������ && �� ��ĿƮ ���� �����
				JOptionPane.showMessageDialog(null, "���� ��� �Ϸ�!");
				couponCheck = false;
				
				//������ ����߱� ������ ����ȭ�鿡 �� �̻� ���������� ��µ� �ʴ´�.
				myCouponMsg = "";
				
				//50%�������� ����
				price *= 0.5;
				
				//���� ������ȣ�� �ߺ����� �ʵ��� �ϱ� ����.
				int temp = coupon;
				while(temp == coupon) {
					coupon = r.nextInt(9000) + 1000;
					//�ߺ��� �ƴ϶�� Ż��
				}
				//���ο� ������ȣ �׽�Ʈ ����
//				System.out.println(coupon);
			}
			//��ǰ �����ý� �����ϴ� ���� 
			name += " ���� ";
			//money < price
			if(money - price < 0) {
				//�ܾ׺���
				name += "���� / �ܾ� ����";
			}else {
				//�������
				//���ݰ���, ����Ʈ+���ݰ���, ����Ʈ ����
				//����Ʈ�� 1���̶� �ִٸ� �ڵ� ���
				//����Ʈ ������ �� �����ܾ��� ������� �ʴ´�.
				name += "���� / ";
				if(point > 0) {
					//����Ʈ + ����
					if(point < price) {
						//������ ���ݿ��� ����Ʈ��ŭ ���� �� ���� �ݾ��� �������� ����
						money -= price - point;
						//����Ʈ ��� ���
						point = 0;
					}else {
						//����Ʈ
						point -= price;
						pointCheck = true;
					}
				}else {
					//���� ����
					money -= price;
					//������ �ݾ��� 50% ����
					point += price * 0.5;
				}
				//����Ʈ ������ ������ �޼����� �������ش�.
				name += pointCheck ? "����Ʈ ��� ����" : "���� �ܾ� : " + money + "��";
			}
			JOptionPane.showMessageDialog(null, name);
		}//while �ݴ� ��ȣ
	}//main()�ݴ� ��ȣ
}//class �ݴ� ��ȣ










