package view;

import dao.UserDAO;

public class Index {
	public static void main(String[] args) {
		new UserDAO().view();
	}
}
