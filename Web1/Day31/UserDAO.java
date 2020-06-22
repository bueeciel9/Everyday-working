package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import vo.UserVO;

public class UserDAO {
	//연결 객체
	Connection conn;
	//쿼리문 객체
	PreparedStatement pstm;
	//결과 객체
	ResultSet rs;
	
	public static String session_id;
	
	private final int KEY = 3; 
	
	//아이디 검사
	public boolean checkId(String id) {
		//DB에서 외부에서 전달받은 id를 검색하고
		//검색 결과 건수를 가지고 온다.
		String query = "SELECT COUNT(*) FROM \"USER\""
				+ " WHERE ID = ?";
		boolean check = true;
		try {
			//연결 하는 작업
			conn = DBConnection.getConnection();
			
			//위에 작성한 SQL문을 객체에 저장
			pstm = conn.prepareStatement(query);
			
			//'?' 자리에 원하는 값 넣기
			pstm.setString(1, id);
			
			//SQL문 실행
			rs = pstm.executeQuery();
			
			//ResultSet객체는 결과를 가져오기 전 next()메소드를
			//반드시 사용해주어야 한다.
			rs.next();
			if(rs.getInt(1) == 0) {
				//검색결과 0건 즉, 중복없음
				check = false;
			}
		} catch(SQLException sqle) {
			System.out.println("checkId() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("알 수 없는 오류(checkId())");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
	
	//회원가입
	public boolean join(String id, String pw, String name, int age, String phone_number) {
		String query = "";
		boolean check = false;
		if(!checkId(id)) {
			query = "INSERT INTO \"USER\" (USER_NUMBER, ID, PW, NAME, AGE, PHONE_NUMBER)"
					+ "VALUES(USER_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
//			query = "INSERT INTO \"USER\" (USER_NUMBER, ID, PW, NAME, AGE, PHONE_NUMBER)"
//					+ "VALUES(?, ?, ?, ?, ?, ?)";
			try {
				int idx = 0;
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(query);
//				pstm.setInt(++idx, 1);
				pstm.setString(++idx, id);
				//비밀번호를 암호화 한 후 전달한다.
				pstm.setString(++idx, encrypt(pw));
				pstm.setString(++idx, name);
				pstm.setInt(++idx, age);
				pstm.setString(++idx, phone_number);
				//INSERT는 결과값이 없으므로 ResultSet은 사용하지 않는다.
				pstm.executeQuery();
				check = true;
				
			} catch(SQLException sqle) {
				System.out.println(sqle);
				System.out.println("join() 쿼리문 오류");
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("알 수 없는 오류(join())");
			} finally {
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		return check;
	}
	//암호화
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	
	//복호화
	public String decrypt(String en_pw) {
		String de_pw = "";
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / KEY);
		}
		return de_pw;
	}
	//로그인
	//아이디와 패스워드로 로그인 시도
	//DB에서 ID, PW 검사
	//로그인 성공시 session객체에 ID 담아주기
	//관리자 계정은 USER_NUMBER가 1이다.
	//리턴 타입은 int로 한다.
	//-1 : 로그인 실패
	//0 : 관리자 계정
	//1 : 그 외 일반 계정
	public int login(String id, String pw) {
		String query = "SELECT USER_NUMBER FROM \"USER\""
				+ "WHERE ID = ? AND PW = ?";
		
		int result = -1;
		//-1 : 로그인 실패
		//0 : 관리자 계정
		//1 : 그 외 일반 계정
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			
			//로그인 성공 : true
			//로그인 실패 : false
			if(rs.next()) {
				if(rs.getInt(1) == 1) {
					result = 0;
				}else {
					result = 1;
				}
				session_id = id;
			}
		} catch(SQLException sqle) {
			System.out.println("login() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("알 수 없는 오류(login())");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return result;
	}
	//로그아웃
	public void logout() {
		session_id = null;
	}
	
	//수정
	public int update(String pw, String new_pw) {
		String query = "UPDATE \"USER\" SET PW = ? "
				+ "WHERE ID = ? AND PW = ?";
		int check = -1;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, encrypt(new_pw));
			pstm.setString(2, session_id);
			pstm.setString(3, encrypt(pw));
			check = pstm.executeUpdate();
			
		}catch(SQLException sqle) {
			System.out.println(sqle);
			System.out.println("update() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("알 수 없는 오류(update())");
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
	public boolean checkAdmin(String id) {
		
		boolean check = false;
		
		String query = "SELECT USER_NUMBER FROM \"USER\""
				+ "WHERE ID = ?";
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			rs.next();
			
			if(rs.getInt(1) == 1) {
				check = true;
			}
			
		} catch(SQLException sqle) {
			System.out.println("login() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("알 수 없는 오류(login())");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return check;
	}
	//삭제
	
	//관리자만 계정을 삭제할 수 있다.
	//삭제할 계정의 아이디를 입력받아야 한다.
	public int delete(String id) {
		int result = 0;
		if(checkAdmin(session_id)) {
			String query = "DELETE FROM \"USER\" WHERE ID = ?";
			try {
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(query);
				pstm.setString(1, id);
				if(pstm.executeUpdate() != 0) {
					result = 1;
				}
			} catch(SQLException sqle) {
				System.out.println(sqle);
				System.out.println("delete() 쿼리문 오류");
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("알 수 없는 오류(delete())");
			} finally {
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}else {
			result = -1;
		}
		//1 : 성공
		//-1 : 일반 계정으로 삭제 시도
		//0 : 삭제할 아이디가 존재하지 않음
		return result;
	}
	//검색(내 정보(로그인한 유저 정보))
	public UserVO select() {
		String query = "SELECT * FROM \"USER\""
				+ "WHERE ID = ?";
		UserVO user = null;
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			//현재 로그인된 계정의 아이디(session_id)를 검색한다
			pstm.setString(1, session_id);
			rs = pstm.executeQuery();
			
			//검색된 결과가 있다면 true 없으면 false
			if(rs.next()) {
				//각 정보를 순서대로 user객체에 담아준다(setter()사용)
				user = new UserVO();
				//user.setUser_number(rs.getInt(1))  //회원 번호가 불필요하면 저장하지 않는다.
				user.setId(rs.getString(2));
				user.setPw(rs.getString(3));
				user.setName(rs.getString(4));
				user.setAge(rs.getInt(5));
				user.setPhone_number(rs.getString(6));
			}   
			
		} catch(SQLException sqle) {
			System.out.println("select() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("알 수 없는 오류(select())");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return user;	
	}
	//목록
	public ArrayList<UserVO> selectAll() {
		String query = "SELECT * FROM \"USER\"";
		
		ArrayList<UserVO> users = new ArrayList<>();
		UserVO user = null;
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				//행이 여러개이므로 반복문을 사용하고
				//몇 번 반복할지 모르기 때문에 while문을 사용한다.
				user = new UserVO();
				user.setId(rs.getString(2));
				user.setPw(rs.getString(3));
				user.setName(rs.getString(4));
				user.setAge(rs.getInt(5));
				user.setPhone_number(rs.getString(6));
				
				//한 명에 대한 검색 결과를 user객체에 담고
				//ArrayList에 순차적으로 저장시켜 놓는다.
				users.add(user);
			}
			
		} catch(SQLException sqle) {
			System.out.println("select() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("알 수 없는 오류(select())");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return users;	
	}
	//아이디 찾기
	public String findId(String phone_number, String pw) {
		String query = "SELECT ID FROM \"USER\""
				+ " WHERE PHONE_NUMBER = ? AND PW = ?";
		String id = null;
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, phone_number);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				//ID컬럼을 검색에 성공했을 때 들어온다.
				//컬럼번호 대신 컬럼명을 사용해도 된다.
				id = rs.getString("ID");
			}
			
		}catch(SQLException sqle) {
			System.out.println("select() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("알 수 없는 오류(select())");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return id;
	}
	//비번 찾기
	public void finePw(String id, String phone_number) {
		//랜덤한 문자의 조합으로 임시 비밀번호를 만든다.
		String temp = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*()_+-=[] {};:/?";
		Random r = new Random();
		
		//비밀번호를 찾기 전에 존재하는 회원인지 먼저 검색해준다.
		String query = "SELECT USER_NUMBER FROM \"USER\""
				+ "WHERE ID = ? AND PHONE_NUMBER = ?";
		
		int idx = 0;
		
		String temp_pw = "";
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, phone_number);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				//입력한 정보에 맞는 사용자가 존재하면 들어와서
				//임시 비밀번호를 발급해준다.
				idx = rs.getInt(1);
				for (int i = 0; i < 8; i++) {
					temp_pw += temp.charAt(r.nextInt(temp.length()));
				}
				//발급된 임시 비밀번호로 DB에 수정요청을 한다.
				query = "UPDATE \"USER\" SET PW = ?"
						+ " WHERE USER_NUMBER = ?";
				
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(query);
				pstm.setString(1, encrypt(temp_pw));
				pstm.setInt(2, idx);
				pstm.executeUpdate();
				
				//외부 API(SMS전송 API)
				String api_key = "";
				String api_secret = "MTT01YRNLW5HJ3LZHAR3ICNNLSU2SFMU";
				Message coolsms = new Message(api_key, api_secret);

				HashMap<String, String> params = new HashMap<String, String>();
				params.put("to", phone_number); // 수신번호
				params.put("from", "01043825111"); // 발신번호
				params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
				params.put("text", "[테스트]\n임시 비밀번호 : "+temp_pw+"\n노출될 수 있으니 반드시 비밀번호 변경을 해주세요."); // 문자내용
				params.put("app_version", "JAVA SDK v2.2");

				try {
					JSONObject obj = coolsms.send(params);
				} catch (CoolsmsException e) {
					System.out.println(e.getMessage());
					System.out.println(e.getCode());
				}
				
			}
		}catch(SQLException sqle) {
			System.out.println("select() 쿼리문 오류");
		} catch (Exception e) {
			System.out.println("알 수 없는 오류(select())");
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		

	}
}











