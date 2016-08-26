package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MembersDAO {

	Context context;
	DataSource dataSource;
	
	public MembersDAO() {
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/MySQLDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean memberLogin(String mUserId, String mPassword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select * from members where mUserId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mUserId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String passwordFromDB = rs.getString("mPassword");
				if(passwordFromDB.equals(mPassword)) {
					result = true;
				} else {
					result = false;
				}
			} else {
				result = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}
	
	public void memberSignup(String mUserId, String mPassword, String mDisplayName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into members (mUserId, mPassword, mDisplayName) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mUserId);
			pstmt.setString(2, mPassword);
			pstmt.setString(3, mDisplayName);
			int returnValue = pstmt.executeUpdate();
			if(returnValue == 0) {
				//...
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	
}






