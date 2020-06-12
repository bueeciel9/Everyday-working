package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;

import vo.UserVO;

public class UserDAO {
	//추가
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
	//학생찾기
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
	
	//수정(학생 점수)
	public void update(UserVO user, int idx, int score) {
		Connection.DB.get(user).set(idx-1, score);
	}
	//삭제
	public void delete(UserVO user) {
		Connection.DB.remove(user);
	}
	//검색
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
	//목록
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
		//추가, 수정, 삭제, 검색, 목록(CreateReadUpdateDelete)
		String title = "[학생 관리 프로그램]";
		String msg = "1.추가\n2.수정\n3.삭제\n4.검색\n5.목록\n6.나가기";
		int choice = 0, user_choice = 0;
		
		Scanner sc = new Scanner(System.in);
		
		String name = ""; int age = 0, kor = 0, eng = 0, math = 0, score = 0; 
		String[] arSubj = {"국어", "영어", "수학"};
		
		ArrayList<UserVO> users = null;
		Iterator<Entry<UserVO, ArrayList<Integer>>> iter = null;
		
		while(true) {
			System.out.println(title);
			System.out.println(msg);
			choice = sc.nextInt();
			
			if(choice == 6) {break;}
			
			switch(choice) {
			//추가
			case 1:
				System.out.print("이름 : ");
				name = sc.next();
				
				System.out.print("나이 : ");
				age = sc.nextInt();
				
				System.out.print("국어 영어 수학(공백포함) : ");
				kor = sc.nextInt();
				eng = sc.nextInt();
				math = sc.nextInt();
				
				insert(name, age, kor, eng, math);
				System.out.println(name + " 학생 추가 완료");
				break;
			//수정
			case 2:
				System.out.print("수정하실 학생의 이름 : ");
				name = sc.next();
				
				users = selectUser(name);
				
				if(users.size() == 0) {
					System.out.println("잘못된 이름입니다.");
					break;
				}
				
				System.out.println("수정하실 과목\n1.국어\n2.영어\n3.수학");
				choice = sc.nextInt();
				System.out.print("새로운 점수 : ");
				score = sc.nextInt();
				
				if(users.size() == 1) {
					update(users.get(0), choice, score);
				}else { 
//					int cnt = 0;
//					for (int i = users.size()-1; i > -1 ; i--) {
//						System.out.println("[" + ++cnt + "]\n" +users.get(i).getNum() 
//								+ "번 " + users.get(i).getName());
//					}
					for (int i = 0; i < users.size(); i++) {
						System.out.println("[" + (i+1) + "]\n" +users.get(i).getNum() 
								+ "번 " + users.get(i).getName());
					}
					user_choice = sc.nextInt();
					
					update(users.get(user_choice-1), choice , score);
				}
				System.out.println("수정 완료");
				break;
			//삭제
			case 3:
				System.out.print("삭제하실 학생의 이름 : ");
				name = sc.next();
				
				users = selectUser(name);
				
				if(users.size() == 0) {
					System.out.println("잘못된 이름입니다.");
					break;
				}
				
				if(users.size() == 1) {
					delete(users.get(0));
				}else { 
					int cnt = 0;
//					for (int i = users.size()-1; i > -1 ; i--) {
//						System.out.println("[" + ++cnt + "]\n" +users.get(i).getNum() 
//								+ "번 " + users.get(i).getName());
//					}
					for (int i = 0; i < users.size(); i++) {
						System.out.println("[" + (i+1) + "]\n" +users.get(i).getNum() 
								+ "번 " + users.get(i).getName());
					}
					user_choice = sc.nextInt();
					
					delete(users.get(user_choice - 1));
				}
				System.out.println("삭제 완료");
				break;
			//검색
			case 4:
				System.out.print("검색하실 학생의 이름 : ");
				name = sc.next();
				
				iter = select(name).iterator();
				if (!iter.hasNext()) {
					System.out.println("잘못된 이름입니다.");
				}
				
				while(iter.hasNext()) {
					Entry<UserVO, ArrayList<Integer>> entry = iter.next();
					
					System.out.println(entry.getKey().toString());
					
					for(int i = 0; i < entry.getValue().size(); i++) {
						System.out.println(arSubj[i] + " : " + entry.getValue().get(i));
					}
				}
				break;
			//목록
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
					System.out.println("목록 없음");
				}
				break;
			}
		}
	}
}









