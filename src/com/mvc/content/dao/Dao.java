package com.mvc.content.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mvc.content.dto.Dto;





public class Dao {

	Connection conn= null;
	// 커넥션을 생성해주는 함수
	public Connection getConnection() {
		Context ctx;
		DataSource ds;
		Connection conn = null;
		try {
			ctx = new InitialContext();
			 ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
			 conn =  ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	// 커넥션을 닫아주는 함수
	public void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//댓글목록 (페이징)
	public List getComment(int page, int midx) {
		int pagePerCnt = 5; //페이지당 보여줄 게시물의 수
		int end = page*pagePerCnt;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList<>();
		try {
			conn = getConnection();
			
			//DB에 댓글 목록 셀렉트문
			String sql = "SELECT c.rnum, c.conIdx, c.mIdx, c.conContent, c.conDate, c.conRedate, m.uIden "
					+ "FROM (SELECT row_number() OVER (ORDER BY conIdx DESC) AS rnum "
					+ ", conIdx, mIdx, conContent,conDate, conRedate, uIdx FROM CONTENT) c, member m "
					+ "WHERE c.uIdx = m.uIdx "
					+ " AND mIdx = ? AND rnum BETWEEN 0 AND ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, midx);
			ps.setInt(2, end);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dto dto = new Dto();
				dto.setConIdx(rs.getInt("conIdx"));
				dto.setmIdx(rs.getInt("mIdx"));
				dto.setConContent(rs.getString("conContent"));
				dto.setConDate(rs.getDate("conDate"));
				dto.setConRedate(rs.getDate("conRedate"));
				dto.setuIden(rs.getString("uIden"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(conn, ps, rs);
		}
	
		return list;
	}
	// 댓글작성전에 사용자가 이영화에 댓글 작성한적이 있는지?
	/*public boolean isExistContent(int member, int movie) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			conn = getConnection();
			// 해당 영화 댓글 목록에 사용자가 작성한적이 있는지 체크
			String sql = "SELECT conIdx "
					+ "FROM Content "
					+ "WEHRE midx = ? AND uidx = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, movie);
			ps.setInt(2, member);
			
			rs = ps.executeQuery();
	
			flag = rs.next(); // rs.next(); 는 boolean을 리턴하는 함수로 next가 true면 만족하는 조건이 있다는 것
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(conn, ps, rs);
		}
		// flag 가 true면 이미 댓글이 존재 false 면 댓글 작성 가능
		return flag;
	}*/
	// 댓글 등록
	public int insertContent(int member, String content, int movie) {
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			conn = getConnection();
			// 댓글 작성 DB에 인설트 문
			// 콘IDX 자동을 생성하는지, 내가 넣어야 되는지,
			// 자동 생성일 시 , conidx 항목 다지우기
			
			String sql = "INSERT  INTO content (conIdx, uIdx, mIdx, conContent, conDate, conRedate) "
					+ "VALUES (Content_seq.nextval, ?, ?, ?, SYSDATE, SYSDATE)";
			// 콘아이디엑스에서 가장 큰 최대 값을 가져온다음 + 1해준다
			ps = conn.prepareStatement(sql);
			ps.setInt(1, member);
			ps.setInt(2, movie);
			ps.setString(3, content);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// insert, update, delete 문의 경우 rs를 null으로 보내주면 됨.
			closeConnection(conn, ps, null);
		}
		
		return result; // 0이면 실패, 1이면 성공
	}
	
	//댓글 수정
	public int updateContent(int member, String content, int cIdx) {

		PreparedStatement ps = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			//댓글 수정 업데이트 문
			String sql = "UPDATE content SET "
						+ "conContent = ?, conRedate = SYSDATE "
						+ "WHERE conIdx = ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, cIdx);
		
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(conn, ps, null);
		}
		
		return result; // 0이면 실패, 1이면 성공
	}
	
	//댓글 신고 
	
	/*public int updateCount(int cId, int uId) {
		
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			//댓글 신고 업데이트 문
			String sql = "";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cId);
			ps.setInt(2, uId);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			
		}finally {
			closeConnection(conn, ps, null);
		}
		
		return result;
		
	}*/
	
	
}
