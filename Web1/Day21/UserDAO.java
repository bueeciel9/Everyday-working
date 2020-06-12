package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;

import vo.UserVO;

public class UserDAO {
	//�߰�
	public void insert(String name, int age, int kor, int eng, int math) {
		UserVO user = new UserVO();
		ArrayList<Integer> scores = new ArrayList<>();

		user.setName(name);
		user.setAge(age);
		
		scores.add(kor);
		scores.add(eng);
		scores.add(math);
		
		Connection.DB.put(user, scores);
	}
//	public void insert(UserVO user, ArrayList<Integer> scores) {
//		
//	}
	//�л�ã��
	public ArrayList<UserVO> selectUser(String name) {
		Iterator<UserVO> iter = Connection.DB.keySet().iterator();
		ArrayList<UserVO> users = new ArrayList<>();
		
		while(iter.hasNext()) {
			UserVO user = iter.next();
			if(user.getName().equals(name)) {
				users.add(user);
			}
		}
		return users;
	}
	
	//����(�л� ����)
	public void update(UserVO user, int idx, int score) {
		Connection.DB.get(user).set(idx-1, score);
	}
	//����
	public void delete(UserVO user) {
		Connection.DB.remove(user);
	}
	//�˻�
	public Set<Entry<UserVO, ArrayList<Integer>>> select(String name) {
		Iterator<Entry<UserVO, ArrayList<Integer>>> iter = 
				Connection.DB.entrySet().iterator();
		
		Set<Entry<UserVO, ArrayList<Integer>>> resultSet = new HashSet<>();
		
		while(iter.hasNext()) {
			Entry<UserVO, ArrayList<Integer>> entry = iter.next();
			if(entry.getKey().getName().equals(name)) {
				resultSet.add(entry);
			}
		}
		return resultSet;
	}
	//���
	public Set<Entry<UserVO, ArrayList<Integer>>> selectAll() {
		Iterator<Entry<UserVO, ArrayList<Integer>>> iter = 
				Connection.DB.entrySet().iterator();
		
		Set<Entry<UserVO, ArrayList<Integer>>> resultSet = new HashSet<>();
		
		while(iter.hasNext()) {
			Entry<UserVO, ArrayList<Integer>> entry = iter.next();
			resultSet.add(entry);
		}
		return resultSet;
		
	}
	
	public void view() {
		//�߰�, ����, ����, �˻�, ���(CreateReadUpdateDelete)
		String title = "[�л� ���� ���α׷�]";
		String msg = "1.�߰�\n2.����\n3.����\n4.�˻�\n5.���\n6.������";
		int choice = 0, user_choice = 0;
		
		Scanner sc = new Scanner(System.in);
		
		String name = ""; int age = 0, kor = 0, eng = 0, math = 0, score = 0; 
		String[] arSubj = {"����", "����", "����"};
		
		ArrayList<UserVO> users = null;
		Iterator<Entry<UserVO, ArrayList<Integer>>> iter = null;
		
		while(true) {
			System.out.println(title);
			System.out.println(msg);
			choice = sc.nextInt();
			
			if(choice == 6) {break;}
			
			switch(choice) {
			//�߰�
			case 1:
				System.out.print("�̸� : ");
				name = sc.next();
				
				System.out.print("���� : ");
				age = sc.nextInt();
				
				System.out.print("���� ���� ����(��������) : ");
				kor = sc.nextInt();
				eng = sc.nextInt();
				math = sc.nextInt();
				
				insert(name, age, kor, eng, math);
				System.out.println(name + " �л� �߰� �Ϸ�");
				break;
			//����
			case 2:
				System.out.print("�����Ͻ� �л��� �̸� : ");
				name = sc.next();
				
				users = selectUser(name);
				
				if(users.size() == 0) {
					System.out.println("�߸��� �̸��Դϴ�.");
					break;
				}
				
				System.out.println("�����Ͻ� ����\n1.����\n2.����\n3.����");
				choice = sc.nextInt();
				System.out.print("���ο� ���� : ");
				score = sc.nextInt();
				
				if(users.size() == 1) {
					update(users.get(0), choice, score);
				}else { 
//					int cnt = 0;
//					for (int i = users.size()-1; i > -1 ; i--) {
//						System.out.println("[" + ++cnt + "]\n" +users.get(i).getNum() 
//								+ "�� " + users.get(i).getName());
//					}
					for (int i = 0; i < users.size(); i++) {
						System.out.println("[" + (i+1) + "]\n" +users.get(i).getNum() 
								+ "�� " + users.get(i).getName());
					}
					user_choice = sc.nextInt();
					
					update(users.get(user_choice-1), choice , score);
				}
				System.out.println("���� �Ϸ�");
				break;
			//����
			case 3:
				System.out.print("�����Ͻ� �л��� �̸� : ");
				name = sc.next();
				
				users = selectUser(name);
				
				if(users.size() == 0) {
					System.out.println("�߸��� �̸��Դϴ�.");
					break;
				}
				
				if(users.size() == 1) {
					delete(users.get(0));
				}else { 
					int cnt = 0;
//					for (int i = users.size()-1; i > -1 ; i--) {
//						System.out.println("[" + ++cnt + "]\n" +users.get(i).getNum() 
//								+ "�� " + users.get(i).getName());
//					}
					for (int i = 0; i < users.size(); i++) {
						System.out.println("[" + (i+1) + "]\n" +users.get(i).getNum() 
								+ "�� " + users.get(i).getName());
					}
					user_choice = sc.nextInt();
					
					delete(users.get(user_choice - 1));
				}
				System.out.println("���� �Ϸ�");
				break;
			//�˻�
			case 4:
				System.out.print("�˻��Ͻ� �л��� �̸� : ");
				name = sc.next();
				
				iter = select(name).iterator();
				if (!iter.hasNext()) {
					System.out.println("�߸��� �̸��Դϴ�.");
				}
				
				while(iter.hasNext()) {
					Entry<UserVO, ArrayList<Integer>> entry = iter.next();
					
					System.out.println(entry.getKey().toString());
					
					for(int i = 0; i < entry.getValue().size(); i++) {
						System.out.println(arSubj[i] + " : " + entry.getValue().get(i));
					}
				}
				break;
			//���
			case 5:
				Set<Entry<UserVO, ArrayList<Integer>>> set =  
					selectAll();
				
				if(set.size() != 0) {
					iter = set.iterator();
					while(iter.hasNext()) {
						Entry<UserVO, ArrayList<Integer>> entry = iter.next();
						
						System.out.println(entry.getKey().toString());
						
						for(int i = 0; i < entry.getValue().size(); i++) {
							System.out.println(arSubj[i] + " : " + entry.getValue().get(i));
						}
					}
				}else {
					System.out.println("��� ����");
				}
				break;
			}
		}
	}
}









