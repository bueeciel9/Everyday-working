package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		User u = new User();
		
		ArrayList<String> user = null;
		String id = "";
		String pw = "";
		
		while(true) {
			System.out.println("1.회원가입\n2.로그인\n3.나가기");
			choice = sc.nextInt();
			
			if(choice == 3) {
				break;
			}
			
			switch(choice) {
			case 1:
				user = new ArrayList<>();
				System.out.print("아이디 : ");
				user.add(sc.next());
				System.out.print("비밀번호 : ");
				user.add(sc.next());
				System.out.print("이름 : ");
				user.add(sc.next());
				
				u.join(user);
				
				break;
			case 2:
				System.out.print("아이디 : ");
				id = sc.next();
				System.out.print("비밀번호 : ");
				pw = sc.next();
				
				if(u.login(id, pw)) {
					System.out.println(User.getSession().get(2) + "님 환영합니다.");
					while(true) {
						System.out.println("1.로그아웃");
						choice = sc.nextInt();
						break;
					}
				}
				
				break;
			}
			
			
		}
	}
}
