package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.UserVO;

public class UserDAO {
	//���� ��ü
	Connection conn;
	//������ ��ü
	PreparedStatement pstm;
	//��� ��ü
	ResultSet rs;
	
	public static String session_id;
	
	private final int KEY = 3; 
	
	//���̵� �˻�
	public boolean checkId(String id) {
		//DB���� �ܺο��� ���޹��� id�� �˻��ϰ�
		//�˻� ��� �Ǽ��� ������ �´�.
		String query = "SELECT COUNT(*) FROM \"USER\""
				+ " WHERE ID = ?";
		boolean check = true;
		try {
			//���� �ϴ� �۾�
			conn = DBConnection.getConnection();
			
			//���� �ۼ��� SQL���� ��ü�� ����
			pstm = conn.prepareStatement(query);
			
			//'?' �ڸ��� ���ϴ� �� �ֱ�
			pstm.setString(1, id);
			
			//SQL�� ����
			rs = pstm.executeQuery();
			
			//ResultSet��ü�� ����� �������� �� next()�޼ҵ带
			//�ݵ�� ������־�� �Ѵ�.
			rs.next();
			if(rs.getInt(1) == 0) {
				//�˻���� 0�� ��, �ߺ�����
				check = false;
			}
		} catch(SQLException sqle) {
			System.out.println("checkId() ������ ����");
		} catch (Exception e) {
			System.out.println("�� �� ���� ����(checkId())");
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
	
	//ȸ������
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
				//��й�ȣ�� ��ȣȭ �� �� �����Ѵ�.
				pstm.setString(++idx, encrypt(pw));
				pstm.setString(++idx, name);
				pstm.setInt(++idx, age);
				pstm.setString(++idx, phone_number);
				//INSERT�� ������� �����Ƿ� ResultSet�� ������� �ʴ´�.
				pstm.executeQuery();
				check = true;
				
			} catch(SQLException sqle) {
				System.out.println(sqle);
				System.out.println("join() ������ ����");
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("�� �� ���� ����(join())");
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
	//��ȣȭ
	public String encrypt(String pw) {
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	
	//��ȣȭ
	public String decrypt(String en_pw) {
		String de_pw = "";
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / KEY);
		}
		return de_pw;
	}
	//�α���
	//���̵�� �н������ �α��� �õ�
	//DB���� ID, PW �˻�
	//�α��� ������ session��ü�� ID ����ֱ�
	//������ ������ USER_NUMBER�� 1�̴�.
	//���� Ÿ���� int�� �Ѵ�.
	//-1 : �α��� ����
	//0 : ������ ����
	//1 : �� �� �Ϲ� ����
	public int login(String id, String pw) {
		String query = "SELECT USER_NUMBER FROM \"USER\""
				+ "WHERE ID = ? AND PW = ?";
		
		int result = -1;
		//-1 : �α��� ����
		//0 : ������ ����
		//1 : �� �� �Ϲ� ����
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			
			//�α��� ���� : true
			//�α��� ���� : false
			if(rs.next()) {
				if(rs.getInt(1) == 1) {
					result = 0;
				}else {
					result = 1;
				}
				session_id = id;
			}
		} catch(SQLException sqle) {
			System.out.println("login() ������ ����");
		} catch (Exception e) {
			System.out.println("�� �� ���� ����(login())");
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
	//�α׾ƿ�
	public void logout() {
		session_id = null;
	}
	
	//����
	public boolean update(String pw, String new_pw) {
		String query = "UPDATE \"USER\" SET PW = ? "
				+ "WHERE ID = ? AND PW = ?";
		boolean check = false;
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, new_pw);
			pstm.setString(2, session_id);
			pstm.setString(3, encrypt(pw));
			check = pstm.execute();
			
		}catch(SQLException sqle) {
			System.out.println(sqle);
			System.out.println("update() ������ ����");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("�� �� ���� ����(update())");
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
			System.out.println("login() ������ ����");
		} catch (Exception e) {
			System.out.println("�� �� ���� ����(login())");
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
	//����
	
	//�����ڸ� ������ ������ �� �ִ�.
	//������ ������ ���̵� �Է¹޾ƾ� �Ѵ�.
	public int delete(String id) {
		int result = 0;
		if(checkAdmin(session_id)) {
			String query = "DELETE FROM \"USER\" WHERE ID = ?";
			try {
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(query);
				pstm.setString(1, id);
				if(pstm.execute()) {
					result = 1;
				}
			} catch(SQLException sqle) {
				System.out.println(sqle);
				System.out.println("delete() ������ ����");
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("�� �� ���� ����(delete())");
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
		//1 : ����
		//-1 : �Ϲ� �������� ���� �õ�
		//0 : ������ ���̵� �������� ����
		return result;
	}
	//�˻�
	public UserVO select() {
		String query = "SELECT * FROM \"USER\""
				+ "WHERE ID = ?";
		UserVO user = null;
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session_id);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString(2));
				user.setPw(rs.getString(3));
				user.setName(rs.getString(4));
				user.setAge(rs.getInt(5));
				user.setPhone_number(rs.getString(6));
			}   
			
		} catch(SQLException sqle) {
			System.out.println("select() ������ ����");
		} catch (Exception e) {
			System.out.println("�� �� ���� ����(select())");
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
	//���
	//���̵� ã��
	//��� ã��
}











