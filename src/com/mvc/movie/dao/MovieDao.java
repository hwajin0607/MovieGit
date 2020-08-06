package com.mvc.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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

	public void selectGrade() {
		String sql = "SELECT uidx FROM movie WHERE uiden = ? AND uPw = ?";
		
	}

	public void selectBhit() {
		String sql = "SELECT mName, mBhit FROM (SELECT ROW_NUMBER() OVER (ORDER by midx DESC) rnum,"
				+ " mName, mBhit FROM movie) WHERE rnum BETWEEN 1 AND 10 ORDER by mBhit DESC";
		
	}
}
