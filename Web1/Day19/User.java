package collection;

import java.util.ArrayList;

public class User {
	ArrayList<ArrayList<String>> users = new ArrayList<>();
	private final int KEY = 3;
	
	private static ArrayList<String> session;
	
	public static ArrayList<String> getSession() {
		return session;
	}
	public static void setSession(ArrayList<String> session) {
		User.session = session;
	}
	//ȸ������(���̵�, �н�����, �̸�)
	public void join(ArrayList<String> user) {
		user.set(1, encrypt(user.get(1)));
		users.add(user);
	}
	//�α���(���̵�, �н�����)
	public boolean login(String id, String pw) {
		for (ArrayList<String> user : users) {
			if(user.get(0).equals(id)) {
				if(decrypt(user.get(1)).equals(pw)) {
					session = user;
					return true;
				}
			}
		}
		return false;
	}
	
	//�α׾ƿ�
	public void logout() {
		session = null;
	}
	
	//��ȣȭ
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * 3);
		}
		return en_pw;
	}
	//��ȣȭ
	public String decrypt(String pw) {
		String de_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			de_pw += (char)(pw.charAt(i) / 3);
		}
		return de_pw;
	}
}







