package ams;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AmsField {
	// �װ����ȣ, �װ���, �ִ�°���, �����, ������
	String[][] arPlane = new String[100][5];
	int insertCnt;
	int rowNum = -1;
	final String title = "AMS";

	// �ߺ� �˻�
	String[] checkDup(String plane_num) {
		rowNum = -1;
		String[] plane = null;

		for (int i = 0; i < insertCnt; i++) {
			if (arPlane[i][0].equals(plane_num)) {
				plane = arPlane[i];
				rowNum = i;
			}
		}
		return plane;
	}

	// �߰�
	int insert(String[] plane) {
		int check = 0;
		if (insertCnt == 100) {
			check = -1;
		} else if (checkDup(plane[0]) == null) {
			arPlane[insertCnt] = plane;
			insertCnt++;
			check = 1;
		}
		return check;
	}

	// ����
	boolean update(String plane_num, int idx, String new_value) {
		boolean check = false;
		idx += 3;
		String[] plane = checkDup(plane_num);
		if (plane != null) {
			plane[idx] = new_value;
			check = true;
		}
		return check;
	}

	// ����
	boolean delete(String plane_num) {
		String[] plane = checkDup(plane_num);
		boolean check = false;
		if (plane != null) {
			for (int i = rowNum; i < insertCnt; i++) {
				if (i == 99) {
					arPlane[i] = null;
					break;
				}
				arPlane[i] = arPlane[i + 1];

			}
			insertCnt--;
			check = true;
		}
		return check;
	}

	String getFrontForm(int[] arIdx) {
		int cnt = 0;
		String result = "�װ����ȣ / �װ��� / �ִ�°���/ ����� / ������\n";
		if(arIdx != null) {
			for (int i = 0; i < arIdx.length; i++) {
				++cnt;
				result += cnt + ". ";
				for (int j = 0; j < arPlane[i].length; j++) {
					result += arPlane[arIdx[i]][j];
					result += j == arPlane[i].length - 1 ? "\n" : " / ";
				}
			}
			return result;
		}
		return "";
	}

	// �˻�(�װ����ȣ, �װ���, �ִ�°���, �����, ������)
	String select(int idx, String keyword) {
		boolean check = false;
		boolean flag = false;
		int[] arIdx = null;
		String temp = "";
		for (int i = 0; i < insertCnt; i++) {
			check = idx == 2 ? arPlane[i][idx].equals(keyword) : arPlane[i][idx].contains(keyword);
			if (check) {
				temp += i + ",";
				flag = true;
			}
		}
		if(flag) {
			String[] arTemp = temp.split(",");
			arIdx = new int[arTemp.length];
			for (int i = 0; i < arTemp.length; i++) {
				arIdx[i] = Integer.parseInt(arTemp[i]);
			}
		}
		return getFrontForm(arIdx);
	}

	// ���
	String selectAll() {
		int[] arIdx = new int[insertCnt];
		for (int i = 0; i < arIdx.length; i++) {
			arIdx[i] = i;
		}
		return getFrontForm(arIdx);
	}

	// view
	void view() {
		String[] menu = {"�߰��ϱ�", "�����ϱ�", "�����ϱ�", "�˻��ϱ�", "��Ϻ���"};
		String[] search_category = {"�װ��� ��ȣ", "�װ���", "�ִ�°���", "�����", "������"};
		//���� ��� : ���� � ��ġ�� �ִ��� ã�ư� �� �ִ� ���
		//��� ��� : ���� ��ġ�� ���� ����Ǵ� ��� .(��������), ..(��������)
		ImageIcon icon = new ImageIcon("src/img/main.gif");
		int choice = 0;
		String[] plane = null;
		int insert_result = 0;
		String msg = "";
		String keyword = "";
		
		while(true) {
			choice = JOptionPane.showOptionDialog(null, "", title,
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, icon,
					menu, null);
			
			if(choice == -1) {break;}
			
			switch(choice) {
			//�߰�
			case 0:
				plane = ("" + JOptionPane.showInputDialog(null, 
						"���� ��Ŀ� ���缭 �װ��⸦ �߰����ּ���\n"
						+ "�װ����ȣ,�װ���,�ִ�°���,�����,������", title, JOptionPane.PLAIN_MESSAGE,
						icon, null, null)).split(",");
				if(plane.length != 5) {
					JOptionPane.showMessageDialog(null, "�߸� �Է��ϼ̽��ϴ�.");
					continue;
				}
				insert_result = insert(plane); 
				if(insert_result == 1) {
					msg = "�߰� ����";
				}else if(insert_result == 0){
					msg = "�߰� ���� / �ߺ��� �װ��� ��ȣ";
				}else {
					msg = "�߰� ���� / �� �̻� �߰��� �� ����";
				}
				JOptionPane.showMessageDialog(null, msg);
				break;
			//����
			case 1:
				break;
			//����
			case 2:
				break;
			//�˻�
			case 3:
				choice = JOptionPane.showOptionDialog(null, "", title,
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, icon,
						search_category, null);

				keyword = "" + JOptionPane.showInputDialog(null, 
						"�˻��Ͻ� "+search_category[choice]+"��(��) �Է��ϼ���", title, JOptionPane.PLAIN_MESSAGE,
						icon, null, null);
				
				msg = select(choice, keyword);
				JOptionPane.showMessageDialog(null, 
						msg.equals("") ? "�˻� ��� ����" : msg);
				
				break;
			//���
			case 4:
				msg = selectAll();
				JOptionPane.showMessageDialog(null,
						msg.equals("") ? "��� ����" : msg);
				break;
			}
			
		}
	}
}






