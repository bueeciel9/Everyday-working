package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.UserVO;

public class UserDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	UserVO user;
	
	private final int KEY = 3; 
	
	//아이디 검사
	public boolean checkId(String id) {
		String query = "SELECT COUNT(*) FROM \"USER\""
				+ " WHERE ID = ?";
		boolean check = true;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			rs = pstm.executeQuery();
			//ResultSet객체는 결과를 가져오기 전 next()메소드를
			//반드시 사용해주어야 한다.
			rs.next();
			if(rs.getInt(1) == 0) {
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
			
			try {
				int idx = 0;
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(query);
				pstm.setString(++idx, id);
				pstm.setString(++idx, encrypt(pw));
				pstm.setString(++idx, name);
				pstm.setInt(++idx, age);
				pstm.setString(++idx, phone_number);
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
	//수정
	//삭제
	//검색
	//목록
	//아이디 찾기
	//비번 찾기
}
