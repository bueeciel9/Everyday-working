package cupang;

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
		
		String C1_1_category = "����콺/����\n�轺ĿƮ/ġ��\n����� �޴��� �̵�\n";
		String C1_2_category = "��Ƽ����\n��Ʈ���̴׺�\n����� �޴��� �̵�\n";
		String C2_1_category = "��ȭ����\n��Űģ Ÿ��\n����� �޴��� �̵�\n";
		String C2_2_category = "��ǥ����\n�輶�� ������\n����� �޴��� �̵�\n";
		
		int choice = 0;
		
		while(choice != 4) {
			choice = Integer.parseInt(JOptionPane.showInputDialog(title + "\n" + msg));
			
			switch(choice) {
			//�����ϱ�
			case 1:
				break;
			//�������
			case 2:
				break;
			//����Ʈ ��ȸ
			case 3:
				break;
			//������
			case 4:
				JOptionPane.showMessageDialog(null, good_bye_msg);
				break;
			//�� �� ����
			default:
				JOptionPane.showMessageDialog(null, errMsg);
			}
			
		}
		
	}
}
