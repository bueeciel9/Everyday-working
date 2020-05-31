package ams;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AmsField {
	// 항공기번호, 항공사, 최대승객수, 출발지, 도착지
	String[][] arPlane = new String[100][5];
	int insertCnt;
	int rowNum = -1;
	final String title = "AMS";

	// 중복 검사
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

	// 추가
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

	// 수정
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

	// 삭제
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
		String result = "항공기번호 / 항공사 / 최대승객수/ 출발지 / 도착지\n";
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

	// 검색(항공기번호, 항공사, 최대승객수, 출발지, 도착지)
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

	// 목록
	String selectAll() {
		int[] arIdx = new int[insertCnt];
		for (int i = 0; i < arIdx.length; i++) {
			arIdx[i] = i;
		}
		return getFrontForm(arIdx);
	}

	// view
	void view() {
		String[] menu = {"추가하기", "수정하기", "삭제하기", "검색하기", "목록보기"};
		String[] search_category = {"항공기 번호", "항공사", "최대승객수", "출발지", "도착지"};
		//절대 경로 : 현재 어떤 위치에 있더라도 찾아갈 수 있는 경로
		//상대 경로 : 현재 위치에 따라서 변경되는 경로 .(현재폴더), ..(이전폴더)
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
			//추가
			case 0:
				plane = ("" + JOptionPane.showInputDialog(null, 
						"밑의 양식에 맞춰서 항공기를 추가해주세요\n"
						+ "항공기번호,항공사,최대승객수,출발지,도착지", title, JOptionPane.PLAIN_MESSAGE,
						icon, null, null)).split(",");
				if(plane.length != 5) {
					JOptionPane.showMessageDialog(null, "잘못 입력하셨습니다.");
					continue;
				}
				insert_result = insert(plane); 
				if(insert_result == 1) {
					msg = "추가 성공";
				}else if(insert_result == 0){
					msg = "추가 실패 / 중복된 항공기 번호";
				}else {
					msg = "추가 실패 / 더 이상 추가할 수 없음";
				}
				JOptionPane.showMessageDialog(null, msg);
				break;
			//수정
			case 1:
				break;
			//삭제
			case 2:
				break;
			//검색
			case 3:
				choice = JOptionPane.showOptionDialog(null, "", title,
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, icon,
						search_category, null);

				keyword = "" + JOptionPane.showInputDialog(null, 
						"검색하실 "+search_category[choice]+"을(를) 입력하세요", title, JOptionPane.PLAIN_MESSAGE,
						icon, null, null);
				
				msg = select(choice, keyword);
				JOptionPane.showMessageDialog(null, 
						msg.equals("") ? "검색 결과 없음" : msg);
				
				break;
			//목록
			case 4:
				msg = selectAll();
				JOptionPane.showMessageDialog(null,
						msg.equals("") ? "목록 없음" : msg);
				break;
			}
			
		}
	}
}






