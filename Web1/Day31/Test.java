package view;

import dao.UserDAO;

public class Test {
	public static void main(String[] args) {
//		System.out.println(DBConnection.getConnection());
		UserDAO dao = new UserDAO();
//		System.out.println(dao.checkId("hds"));
//		dao.join("admin", "1234", "admin", 20, "01012341234");
//		dao.join("hds1204", "1204", "�ѵ���", 20, "01043825111");
		if(dao.login("hds1204", "thGq[&GL") != -1) {
			System.out.println("�α��� ����");
			if(dao.update("thGq[&GL", "1234") != 0){
				System.out.println("��й�ȣ ���� ����");
				dao.logout();
				System.out.println("�α׾ƿ�");
				if(dao.login("hds1204", "1234") != -1) {
					System.out.println("�α��� ����");
				}
			}
		}
	}
}







