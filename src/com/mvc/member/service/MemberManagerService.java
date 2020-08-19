package com.mvc.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mvc.member.dto.MemberDto;
import com.mvc.member.dto.MemberManagerDto;
import com.mvc.movie.dto.MovieManagerDto;

public class MemberManagerService {
	public Connection getConnection() throws Exception{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
		return ds.getConnection();
	}

	public Object list(int page, String search) {

		System.out.println(search+":"+page);
		int pagePerCnt = 25; //페이지당 보여줄 게시물의 수
		int end = page*pagePerCnt;
		int start = (end-pagePerCnt)+1; 
		
		ArrayList<MemberManagerDto> list = new ArrayList<MemberManagerDto>();
		Connection conn= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
	try {

		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");		
		conn = ds.getConnection();
		String sql = "";
		
		//서치가 널이거나 아니면 서치가 공백이라면
		if(search == null || search.equals("")) { 
			
			sql = "select rnum, uidx, uname, ubirth, ugender, uIden, upw, uemail, udate "
					+ "from (select row_number() over (order by uidx desc) as rnum, uidx, uname, "
					+ "ubirth, ugender, uIden, upw, uemail, udate from member) where rnum between ? and ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			System.out.println("제대로 작동");
			
			}else{
				System.out.println("서치기능 실행");
				sql = "select rnum, uidx, uname, ubirth, ugender, uIden, upw, uemail, udate "
						+ "from (select row_number() over (order by uidx desc) as rnum, uidx, uname, "
						+ "ubirth, ugender, uIden, upw, uemail, udate from member) where uname like ? and "
						+ "rnum between ? and ? ";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+search+"%");
				ps.setInt(2, start);
				ps.setInt(3, end);
			}
			rs = ps.executeQuery();

			
		while(rs.next()) {
				MemberManagerDto dto = new MemberManagerDto();
				dto.setuIdx(rs.getInt("uIdx"));
				dto.setuName(rs.getString("uName"));
				dto.setuBirth(rs.getDate("uBirth"));
				dto.setuGender(rs.getString("uGender"));
				dto.setuIden(rs.getString("uIden"));
				dto.setuPw(rs.getString("uPw"));
				dto.setuEmail(rs.getString("uEmail"));
				dto.setuDate(rs.getDate("uDate"));
				
				list.add(dto); 

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
				
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	public Object conlist(String uidx) {

		Connection conn= null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MovieManagerDto> list = new ArrayList<MovieManagerDto>();
		try {
			conn = getConnection();
			String sql = "select c.conIdx, c.midx,c.concontent,c.condate, m.midx, m.mname from content c , movie m where m.midx = c.midx and uidx = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uidx);
			rs = ps.executeQuery();
			while(rs.next()) {
				MovieManagerDto dto = new MovieManagerDto();
				dto.setmIdx(rs.getInt("midx"));
				dto.setmName(rs.getString("mname"));
				dto.setConContent(rs.getString("concontent"));
				dto.setmDate(rs.getDate("condate"));
				dto.setConIdx(rs.getInt("conIdx"));
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	//댓글지우기
	public int delComment(String conIdx) throws Exception {
		int result = 0;
		Connection conn = getConnection();
		String sql = "DELETE FROM content  "
				   + "WHERE  conIdx in (?) ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, conIdx);
		
		result = ps.executeUpdate();
		return result;
	}

	

}
