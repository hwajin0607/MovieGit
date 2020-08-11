package com.mvc.movie.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mvc.movie.dto.MovieDto;

public class MovieService {

	public Object list(int page, String search) {

		System.out.println(search+":");
		
		int pagePerCnt = 25; //페이지당 보여줄 게시물의 수
		int end = page*pagePerCnt;
		int start = (end-pagePerCnt)+1; 
		
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
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
				
				sql = "SELECT rnum, midx, mopen, mgenre, murl, mbhit, mdate, mage, mcontent, mname	"
						+"FROM (SELECT row_number() OVER (ORDER BY midx DESC) AS rnum, midx, mopen, "
						+"mgenre, murl, mbhit, mdate, mage, mcontent, mname FROM movie) WHERE rnum BETWEEN ? AND ?";
			
				ps = conn.prepareStatement(sql);
				ps.setInt(1, start);
				ps.setInt(2, end);
				System.out.println("다가져와");
			}else {
				
				sql = "SELECT rnum, midx, mopen, mgenre, murl, mbhit, mdate, mage, mcontent, mname	"
						+"FROM (SELECT row_number() OVER (ORDER BY midx DESC) AS rnum,  midx, mopen, "
						+"mgenre, murl, mbhit, mdate, mage, mcontent, mname FROM movie) WHERE mname LIKE ? AND " 
						+"rnum BETWEEN ? AND ?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, "%"+search+"%");
				ps.setInt(2, start);
				ps.setInt(3, end);
				System.out.println("너만가져와");
			} 
			rs = ps.executeQuery();
			
			while (rs.next()) {
				MovieDto dto = new MovieDto();
				dto.setmIdx(rs.getInt("mIdx"));
				dto.setmOpen(rs.getDate("mOpen"));
				dto.setmGenre(rs.getString("mGenre"));
				dto.setmUrl(rs.getString("mUrl"));
				dto.setmBhit(rs.getInt("mBhit"));
				dto.setmDate(rs.getDate("mDate"));
				dto.setmAge(rs.getInt("mAge"));
				dto.setmContent(rs.getString("mContent"));
				dto.setmName(rs.getString("mName"));
				
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			
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
