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
			System.out.println("1.ȸ������\n2.�α���\n3.������");
			choice = sc.nextInt();
			
			if(choice == 3) {
				break;
			}
			
			switch(choice) {
			case 1:
				user = new ArrayList<>();
				System.out.print("���̵� : ");
				user.add(sc.next());
				System.out.print("��й�ȣ : ");
				user.add(sc.next());
				System.out.print("�̸� : ");
				user.add(sc.next());
				
				u.join(user);
				
				break;
			case 2:
				System.out.print("���̵� : ");
				id = sc.next();
				System.out.print("��й�ȣ : ");
				pw = sc.next();
				
				if(u.login(id, pw)) {
					System.out.println(User.getSession().get(2) + "�� ȯ���մϴ�.");
					while(true) {
						System.out.println("1.�α׾ƿ�");
						choice = sc.nextInt();
						break;
					}
				}
				
				break;
			}
			
			
		}
	}
}
