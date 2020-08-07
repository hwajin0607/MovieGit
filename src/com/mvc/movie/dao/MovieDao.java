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
	public ArrayList<MovieDto> movieList(int page) throws SQLException {
		int pagePerCnt = 4; //페이지당 보여줄 게시물의 수
		int end = page*pagePerCnt;
		int start = (end-pagePerCnt)+1;
		
		String sql = "SELECT rnum, mIdx, mName, mOpen, mGenre, mUrl, mBhit, mDate, mAge, mContent FROM(SELECT ROW_NUMBER() OVER(ORDER BY mIdx DESC) AS rnum, mIdx, mName, mOpen, mGenre, mUrl, mBhit, mDate, mAge, mContent FROM movie) \r\n" + 
				" WHERE rnum BETWEEN ? AND ?";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
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
	public ArrayList<MovieDto> movieListG(String mGenre,int page) throws SQLException {
		//int z = 0;
		int pagePerCnt = 4; //페이지당 보여줄 게시물의 수
		int end = page*pagePerCnt;
		int start = (end-pagePerCnt)+1;
		String sql = " SELECT rnum, mIdx, mName, mOpen, mGenre, mUrl, mBhit, mDate, mAge, mContent FROM(SELECT ROW_NUMBER() OVER(ORDER BY mIdx DESC) AS rnum, mIdx, mName, mOpen, mGenre, mUrl, mBhit, mDate, mAge, mContent FROM movie) \r\n" + 
				"WHERE (rnum BETWEEN ? AND ? AND mGenre = ?)ORDER BY mName DESC";
		/*String sql = "SELECT mIdx, mName, mOpen, mGenre, mUrl, mBhit, mDate, mAge, mContent FROM Movie "
				+ "WHERE mGenre = ? ORDER BY mName DESC";*/
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ps.setString(3, mGenre);
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
			//z++;
		}
		//System.out.println(z);
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

	//마이페이지 찜목록 보여주기
	public ArrayList<MovieDto> myPageZ(String uIdx) {
		String sql ="select DISTINCT z.uIdx, m.mIdx, m.mName, m.mGenre, m.mUrl, m.mAge, m.mContent, d.mddirector, a.maactor, f.mfurl "
				+ "FROM zzim z, Movie m, moviedirector d, movieactor a, moviefoster f where z.uIdx = ? ORDER BY z.zDate DESC";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uIdx);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MovieDto dto = new MovieDto();
				dto.setMidx(rs.getInt("mIdx"));
				dto.setZidx(rs.getInt("zIdx"));
				dto.setZdate(rs.getDate("zDate"));
				dto.setmName(rs.getString("mName"));
				dto.setMfUrl(rs.getString("mUrl"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			resClose();
		}
		
		return list;
	}
	
	//마이페이지 찜목록 보여주기2
	public void myPageM(ArrayList<MovieDto> list) {
		String sql ="SELECT mName, mGenre FROM movie WHERE uidx = ?";
	}
	
}
