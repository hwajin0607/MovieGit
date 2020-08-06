package com.mvc.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mvc.movie.dto.MovieDto;

public class MovieDao {

	Connection conn = null ;
	PreparedStatement ps= null;
	ResultSet rs = null;
	
	public MovieDao() {
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");		
				conn = ds.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
    //전체영화목록	
	public ArrayList<MovieDto> movieList() throws SQLException {
		String sql = "SELECT mIdx, mName, mOpen, mGenre, mUrl, mBhit, mDate, mAge, mContent FROM Movie ORDER BY mName DESC";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			MovieDto dto = new MovieDto();
			dto.setmIdx(rs.getInt("mIdx"));
			dto.setmName(rs.getString("mName"));
			dto.setmOpen(rs.getDate("mOpen"));
			dto.setmGenre(rs.getString("mGenre"));
			dto.setmUrl(rs.getString("mUrl"));
			dto.setmBhit(rs.getInt("mBhit"));
			dto.setmDate(rs.getDate("mDate"));
			dto.setmAge(rs.getInt("mAge"));
			dto.setmContent(rs.getString("mContent"));
			list.add(dto);
		}
		
		return list;
		
		
	}
	
	public void resClose() {
		 try {
			 if(conn!=null) {conn.close();}
			 if(ps!=null) {ps.close();}
			 if(rs!=null) {rs.close();}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	//장르별 영화 보여주기
	public ArrayList<MovieDto> movieListG(String mGenre) throws SQLException {
		int z = 0;
		String sql = "SELECT mIdx, mName, mOpen, mGenre, mUrl, mBhit, mDate, mAge, mContent FROM Movie "
				+ "WHERE mGenre = ? ORDER BY mName DESC";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		ps = conn.prepareStatement(sql);
		ps.setString(1, mGenre);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			MovieDto dto = new MovieDto();
			dto.setmIdx(rs.getInt("mIdx"));
			dto.setmName(rs.getString("mName"));
			dto.setmOpen(rs.getDate("mOpen"));
			dto.setmGenre(rs.getString("mGenre"));
			dto.setmUrl(rs.getString("mUrl"));
			dto.setmBhit(rs.getInt("mBhit"));
			dto.setmDate(rs.getDate("mDate"));
			dto.setmAge(rs.getInt("mAge"));
			dto.setmContent(rs.getString("mContent"));
			list.add(dto);
			z++;
		}
		System.out.println(z);
		return list;
	}
	//정렬
	public ArrayList<MovieDto> movieListS(String sqlb, String genre) throws SQLException {
		if(genre.equals("")||genre==null) {
			String sql = "SELECT mIdx, mName, mOpen, mGenre, mUrl, mBhit, mDate, mAge, mContent FROM Movie "
					+ "ORDER BY mOpen "+sqlb;
			ps = conn.prepareStatement(sql);
			
		}else {
			String sql = "SELECT mIdx, mName, mOpen, mGenre, mUrl, mBhit, mDate, mAge, mContent FROM Movie "
					+ "WHERE mGenre=? ORDER BY mOpen "+sqlb;
			ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
		}
		
		
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		rs = ps.executeQuery();
		
		while(rs.next()) {
			MovieDto dto = new MovieDto();
			dto.setmIdx(rs.getInt("mIdx"));
			dto.setmName(rs.getString("mName"));
			dto.setmOpen(rs.getDate("mOpen"));
			dto.setmGenre(rs.getString("mGenre"));
			dto.setmUrl(rs.getString("mUrl"));
			dto.setmBhit(rs.getInt("mBhit"));
			dto.setmDate(rs.getDate("mDate"));
			dto.setmAge(rs.getInt("mAge"));
			dto.setmContent(rs.getString("mContent"));
			list.add(dto);
		}
		
		return list;
		
		
	}
}
