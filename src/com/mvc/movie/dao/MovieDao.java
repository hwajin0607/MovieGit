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
	//찜 목록 리스트
	public ArrayList<MovieDto> list(String uidx) {
		String sql ="SELECT zidx,midx,zdate FROM zzim WHERE uidx = ? ORDER BY zidx DESC";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uidx);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MovieDto dto = new MovieDto();
				dto.setMidx(rs.getInt("midx"));
				dto.setZidx(rs.getInt("zidx"));
				dto.setZdate(rs.getDate("zdate"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			resClose();
		}
		
		return list;
	}
	
	public void resClose() {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(conn != null) {conn.close();}
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	//검색 목록 리스트
	public ArrayList<MovieDto> srlist(String mName, String mGenre) {
		ArrayList<MovieDto> srlist = new ArrayList<MovieDto>();
		String sql = "SELECT mName,mOpen,mGenre,mUrl,mAge FROM movie WHERE mName = ? OR mGenre=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,mName);
			ps.setString(2, mGenre);
			rs = ps.executeQuery();
			System.out.println("2차 확인");
			
			while(rs.next()) {
				MovieDto dto = new MovieDto();
				dto.setmName(rs.getString("mName"));
				dto.setmOpen(rs.getDate("mOpen"));
				dto.setmGenre(rs.getString("mGenre"));
				dto.setmUrl(rs.getString("mUrl"));
				
				dto.setmAge(rs.getInt("mAge"));
				srlist.add(dto);
				System.out.println("3차 확인");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			resClose();
		}
		
		return srlist;
	}


	//랜덤으로 값 가져오기 
	public ArrayList<MovieDto> random() {
		String sql = "SELECT m.mIdx, m.mName, f.mfUrl FROM Movie m, movieFoster f order by SYS.dbms_random.VALUE";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			boolean su = rs.next();
			while(su) {
				MovieDto dto = new MovieDto();
				dto.setmIdx(rs.getInt("mIdx"));
				dto.setmName(rs.getString("mName"));
				dto.setMfUrl(rs.getString("mfUrl"));
				su = false;
				System.out.println(dto.getmIdx()+dto.getmName()+dto.getMfUrl());
				list.add(dto);
			}
			System.out.println("값을 가져오기");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
