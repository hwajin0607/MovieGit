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
		String sql ="SELECT DISTINCT mo.mName, z.uidx, z.midx, m.mfurl FROM movie mo,zzim z,(SELECT m.midx, f.mfidx,f.mfurl FROM movie m, moviefoster f WHERE m.midx = f.midx) m WHERE mo.midx = z.midx and z.uidx =?";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uidx);
			rs = ps.executeQuery();
			while(rs.next()) {
				MovieDto dto = new MovieDto();
				dto.setUidx(rs.getInt("uidx"));
				dto.setMidx(rs.getInt("midx"));
				dto.setMfUrl(rs.getString("mfurl"));
				dto.setmName(rs.getString("mName"));
				list.add(dto);
				
				System.out.println(dto.getmName());
				System.out.println(dto.getMidx());
				System.out.println(dto.getMfUrl());
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
	public ArrayList<MovieDto> srlist(String mName) {
		ArrayList<MovieDto> srlist = new ArrayList<MovieDto>();
		String sql ="SELECT distinct m.midx, m.mName, m.mGenre, d.mdDirector, a.maActor, m.mUrl, m.mAge, m.mOpen" 
					+"FROM movie m, movieDirector d, movieActor a"
					+"where m.midx = d.midx and d.midx = a.midx and a.maActor = ? or d.mdDirector = ? or m.mName = ?  or m.mGenre = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,mName);
			ps.setString(2, mName);
			ps.setString(3, mName);
			ps.setString(4, mName);
			rs = ps.executeQuery();
			System.out.println("2차 확인");
			
			while(rs.next()) {
				MovieDto dto = new MovieDto();
				dto.setMidx(rs.getInt("midx"));
				dto.setmaActor(rs.getString("maActor"));
				dto.setmName(rs.getString("mName"));
				dto.setmOpen(rs.getDate("mOpen"));
				dto.setmGenre(rs.getString("mGenre"));
				dto.setmUrl(rs.getString("mUrl"));
				dto.setmAge(rs.getInt("mAge"));
				dto.setmdDirector(rs.getString("mdDirector"));
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
	public ArrayList<MovieDto> slist(String mName, String mGenre, String mdDirector, String maActor) {
		boolean result = false;
		String sql = "SELECT mName,mOpen,mGenre,mUrl,mBhit,mContent,mdDirector,mfUrl FROM Movie, movieDirector, movieActor, movieFoster"
						+"WHERE mName=? OR mGenre=? OR mdDirector=? OR maActor=?";
		ArrayList<MovieDto> slist = new ArrayList<MovieDto>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, mName);
			ps.setString(2, mGenre);
			ps.setString(3, mdDirector);
			ps.setString(4, maActor);
			rs=ps.executeQuery();
			result = rs.next();
			while(result) {
				MovieDto dto = new MovieDto();	
				dto.setmName(rs.getString("mName"));
				dto.setmGenre(rs.getString("mGenre"));
				dto.setmdDirector(rs.getString("mdDirector"));
				dto.setmaActor(rs.getString("maActor"));
				result = false;
				System.out.println("점검 : " + dto.getmName()+ dto.getmGenre()+ dto.getmdDirector()+ dto.getmaActor());
				slist.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return slist;
	}
	public boolean del(String uidx) {
		String sql = "DELETE FROM zzim WHERE uidx=?";
		boolean result = false;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, uidx);
			int success =ps.executeUpdate();
			if(success>0) {
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			resClose();
		}
		return result;
	}
	
	
}
