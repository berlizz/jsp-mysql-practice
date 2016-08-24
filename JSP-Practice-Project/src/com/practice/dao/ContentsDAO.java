package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.practice.dto.ContentsDTO;

public class ContentsDAO {
	Context context;
	DataSource dataSource;

	public ContentsDAO() {
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/MySQLDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ContentsDTO> list() {
		ArrayList<ContentsDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select * from Contents order by cGroup desc, cStep asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cId = rs.getInt("cId");
				String cTitle = rs.getString("cTitle");
				String cName = rs.getString("cName");
				String cContent = rs.getString("cContent");
				Timestamp cDate = rs.getTimestamp("cDate");
				int cHit = rs.getInt("cHit");
				int cGroup = rs.getInt("cGroup");
				int cStep = rs.getInt("cStep");
				int cIndent = rs.getInt("cIndent");
				ContentsDTO dto = new ContentsDTO(cId, cTitle, cName, cContent, cDate, cHit, cGroup, cStep, cIndent);
				list.add(dto);
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
		
		return list;
	}
	
	public ContentsDTO contentView(String cId) {
		hitUp(cId);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ContentsDTO dto = new ContentsDTO();
		
		try {
			conn = dataSource.getConnection();
			String sql = "select * from contents where cId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setcId(rs.getInt("cId"));
				dto.setcTitle(rs.getString("cTitle"));
				dto.setcName(rs.getString("cName"));
				dto.setcContent(rs.getString("cContent"));
				dto.setcDate(rs.getTimestamp("cDate"));
				dto.setcHit(rs.getInt("cHit"));
				dto.setcGroup(rs.getInt("cGroup"));
				dto.setcStep(rs.getInt("cStep"));
				dto.setcIndent(rs.getInt("cIndent"));
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
		
		return dto;
		
	}
	
	private void hitUp(String cId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "update contents set cHit = cHit + 1 where cId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			int returnValue = pstmt.executeUpdate();
			if(returnValue == 0) {
				// ..... sql문 에러 날 시 처리
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
	
	public void contentWrite(String cTitle, String cName, String cContent) {
		Connection conn = null;
		PreparedStatement pstmtInsert = null;
		PreparedStatement pstmtUpdate = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into contents (cTitle, cName, cContent, cGroup, cStep, cIndent) values (?, ?, ?, 0, 0, 0)";
			pstmtInsert = conn.prepareStatement(sql);
			pstmtInsert.setString(1, cTitle);
			pstmtInsert.setString(2, cName);
			pstmtInsert.setString(3, cContent);
			int resultValue = pstmtInsert.executeUpdate();
			if(resultValue == 0) {
				//
			}
			
			sql = "update contents set cGroup=cId where cTitle=? && cName=? && cContent=?";
			pstmtUpdate = conn.prepareStatement(sql);
			pstmtUpdate.setString(1, cTitle);
			pstmtUpdate.setString(2, cName);
			pstmtUpdate.setString(3, cContent);
			resultValue = pstmtUpdate.executeUpdate();
			if(resultValue == 0) {
				//
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmtInsert != null) pstmtInsert.close();
				if(pstmtUpdate != null) pstmtUpdate.close();
				if(conn != null) conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}	
	}
	
	public ContentsDTO contentEdit(String cId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ContentsDTO dto = new ContentsDTO();
		
		try {
			conn = dataSource.getConnection();
			String sql = "select cTitle, cName, cContent from contents where cId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String cTitle = rs.getString("cTitle");
				String cName = rs.getString("cName");
				String cContent = rs.getString("cContent");
				dto.setcId(Integer.parseInt(cId));
				dto.setcTitle(cTitle);
				dto.setcName(cName);
				dto.setcContent(cContent);
				
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
		
		return dto;
	}
	
	public void contentModify(String cId, String cTitle, String cContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "update contents set cTitle=?, cContent=? where cId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cTitle);
			pstmt.setString(2, cContent);
			pstmt.setInt(3, Integer.parseInt(cId));
			int resultValue = pstmt.executeUpdate();
			if(resultValue == 0) {
				//....
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
	
	public void contentDelete(String cId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "delete from contents where cId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			int resultValue = pstmt.executeUpdate();
			if(resultValue == 0) {
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
	
	public ContentsDTO contentReplyPage(String cId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ContentsDTO dto = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "select cGroup, cStep, cIndent from contents where cId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cId));
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new ContentsDTO();
				dto.setcGroup(rs.getInt("cGroup"));
				dto.setcStep(rs.getInt("cStep"));
				dto.setcIndent(rs.getInt("cIndent"));
				
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
		
		return dto;
		
	}
	
	public void contentReply(String cTitle, String cName, String cContent, String cGroup, String cStep, String cIndent) {
		replyStepUp(cGroup, cStep);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into contents (cTitle, cName, cContent, cGroup, cStep, cIndent) values (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cTitle);
			pstmt.setString(2, cName);
			pstmt.setString(3, cContent);
			pstmt.setInt(4, Integer.parseInt(cGroup));
			pstmt.setInt(5, Integer.parseInt(cStep) + 1);
			pstmt.setInt(6, Integer.parseInt(cIndent) + 1);
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
	
	private void replyStepUp(String cGroup, String cStep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "update contents set cStep=cStep+1 where cGroup=? && cStep>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cGroup));
			pstmt.setInt(2, Integer.parseInt(cStep));
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








