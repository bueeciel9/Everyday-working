package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.FestivalVO;

public class FestivalDAO {

	Connection conn;
	//쿼리문 객체
	PreparedStatement pstm;
	//결과 객체
	ResultSet rs;

	
	public FestivalVO season_fes_search(String season){
		
		String query = "SELECT * FROM FESTIVAL"
				+ "WHERE SEASON = ?";
		FestivalVO fes = null;
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, season);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				fes = new FestivalVO();
				fes.setFestival_name(rs.getString(2));
				fes.setDate(rs.getString(3));
				fes.setArea(rs.getString(4));
				fes.setAdress(rs.getString(5));
				fes.setUrl(rs.getString(6));
				fes.setSeason(rs.getString(7));
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
		
		return fes;
	}


public FestivalVO area_fes_search(String area){
	
	String query = "SELECT * FROM FESTIVAL"
			+ "WHERE AREA = ?";
	FestivalVO fes = null;
	
	try {
		conn = DBConnection.getConnection();
		pstm = conn.prepareStatement(query);
		pstm.setString(1, area);
		rs = pstm.executeQuery();
		
		if(rs.next()) {
			fes = new FestivalVO();
			fes.setFestival_name(rs.getString(2));
			fes.setDate(rs.getString(3));
			fes.setArea(rs.getString(4));
			fes.setAdress(rs.getString(5));
			fes.setUrl(rs.getString(6));
			fes.setSeason(rs.getString(7));
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
	return fes;
}
}