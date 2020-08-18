package com.mvc.movieupload.all;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public DAO() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");		
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resClose() {
		try {
			if(rs!=null) {rs.close();}
			if(ps!=null) {ps.close();}
			if(conn!=null) {conn.close();}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public long movieTest(DTO dto) {
		String sql="INSERT INTO movie(mIdx, mName, mOpen, mGenre, mUrl, mAge, mContent,mBhit) "
				+ "VALUES (Movie_seq.NEXTVAL, ?, ?, ?,?,?,?,0)";
		long pk=0;
		System.out.println("dao 에서 일하는 중");
		try {
			ps=conn.prepareStatement(sql, new String[] {"mIdx"});
			ps.setString(1, dto.getmName());
			ps.setString(2, dto.getmOpen());
			ps.setString(3, dto.getmGenre());
			ps.setString(4, dto.getmUrl());
			ps.setInt(5, dto.getmAge());
			ps.setString(6, dto.getmContent());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			System.out.println("첫 번째 sql 문");
			if(rs.next()) {
				pk = rs.getLong(1);
				System.out.println("성공 했으면 : mIdx = " + pk);
				if(dto.getMfOri() != null) {
					sql="INSERT INTO movieFoster(mfIdx, mIdx, mfOri, mfNew, mfUrl) "
							+ "VALUES (movieFoster_seq.NEXTVAL,?,?,?,?)";
					ps=conn.prepareStatement(sql);
					ps.setLong(1, pk);
					ps.setString(2, dto.getMfOri());
					ps.setString(3, dto.getMfNew());
					ps.setString(4, "포스터파일URL");
					ps.executeUpdate();
					System.out.println("두 번째 sql 문 ");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			resClose();
		}
		return pk;
	}

}


