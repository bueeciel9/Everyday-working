package view;

import dao.DBConnection;
import dao.UserDAO;

public class Test {
	public static void main(String[] args) {
//		System.out.println(DBConnection.getConnection());
		UserDAO dao = new UserDAO();
//		System.out.println(dao.checkId("hds"));
		dao.join("hds4321", "1234", "ÇÑµ¿¼®", 20, "01012341234");
	}
}







