package com.mvc.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mvc.member.dto.MemberDto;


public class MemberService {

	public Object list(int page, String search) {
	
		System.out.println(search+":"+page);
		int pagePerCnt = 5; //페이지당 보여줄 게시물의 수
		int end = page*pagePerCnt;
		int start = (end-pagePerCnt)+1; 
		
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
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
			
			}else {
				
				sql = "select rnum, uidx, uname, ubirth, ugender, uIden, upw, uemail, udate "
						+ "from (select row_number() over (order by uidx desc) as rnum, uidx, uname, "
						+ "ubirth, ugender, uIden, upw, uemail, udate from member) where uname like %? and "
						
						+ "rnum between ? and ? ";
				System.out.println(sql);
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+search+"%");
				ps.setInt(2, start);
				ps.setInt(3, end);
			}
			rs = ps.executeQuery();

			
		while(rs.next()) {
				MemberDto dto = new MemberDto();
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
	

}
