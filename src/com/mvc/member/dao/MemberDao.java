package com.mvc.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mvc.member.dto.MemberDto;


public class MemberDao {

	Connection conn = null ;
	PreparedStatement ps= null;
	ResultSet rs = null;
	
	public MemberDao() {
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");		
				conn = ds.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public int login(String id, String pw) throws SQLException {
		int useridx = 0;
		String sql = "SELECT uIdx FROM Member WHERE uIden=? AND uPw=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		rs = ps.executeQuery();
		while (rs.next()) {
			useridx = rs.getInt("uIdx");			
		}
		System.out.println("아이디 고유번호: "+useridx);
		return useridx;	
	}

	public boolean overlay(String id) throws SQLException {
		boolean success = false;
		String sql = "SELECT uiden FROM member WHERE uiden=?";
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			success = rs.next();
			System.out.println("success : " + success);
		
		
		return success;
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

	public boolean join(String id, String pw, String name, String birth, String gender, String email) throws SQLException {
		boolean success = false;
		System.out.println("TO_DATE('"+birth+"','YYYY-MM-DD')");
		Date d = Date.valueOf(birth);
		String sql = "INSERT INTO Member(uIdx, uName, uBirth, uGender, uiden, uPw, uEmail)"
				+"VALUES(Membert_seq.NEXTVAL,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setDate(2, d);
		ps.setString(3, gender);
		ps.setString(4, id);
		ps.setString(5, pw);
		ps.setString(6, email);
		if(ps.executeUpdate()>0) {
			success = true;
		}
		System.out.println(success);
		return success;
		
	}

	public int genrejoin(String[] ugenre, int useridx) throws SQLException {
		String sql = "INSERT INTO userGenre(gIdx, uIdx, gGenre)"
				+ " VALUES(userGenre_seq.NEXTVAL,?,?)";
		int update = 0;
		System.out.println("cnt: "+ugenre.length);
		
		for(String genre : ugenre) {
			System.out.println("추가되는 장르 : " +genre);
			ps =conn.prepareStatement(sql);
			ps.setInt(1, useridx);
			ps.setString(2, genre);
			update += ps.executeUpdate();
		}
		
		System.out.println("장르에 추가된 갯수 : "+ update);
		
		return update;
		
	}

	public int uidx(String id, String pw) throws SQLException {
		System.out.println("확인");
		System.out.println(id+pw);
		int useridx = 0;
		String sql = "select uidx FROM member WHERE uiden = ? AND uPw = ?";
		ps =conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		rs = ps.executeQuery();
		while (rs.next()) {
			useridx = rs.getInt("uidx");			
		}
		System.out.println(useridx);
		return useridx;
	}

	public void like(String uIdx) throws SQLException {
		System.out.println("아이디 고유번호 2차 확인 : "+uIdx);
		String sql = "select gGenre from usergenre where uIdx=?";
		ps =conn.prepareStatement(sql);
		ps.setString(1, uIdx);
		rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.next());
		}
	}
	public MemberDto info(String uidx) throws SQLException {
		MemberDto dto = null;
		String sql = "select uiden, uname, ubirth, ugender, uemail  FROM member WHERE uidx = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, uidx);
		rs = ps.executeQuery();
		while(rs.next()) {
			dto = new MemberDto();
			dto.setUiden(rs.getString("uiden"));
			dto.setUname(rs.getString("uname"));
			dto.setuBirth(rs.getDate("ubirth"));
			dto.setUgender(rs.getString("ugender"));
			dto.setUemail(rs.getString("uemail"));
		}
		
		return dto;
	}

	public ArrayList<String> genre(String uidx) throws SQLException {
		String genre = "";
		String sql = "select gGenre  FROM userGenre WHERE uidx = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, uidx);
		rs = ps.executeQuery();
		ArrayList<String> list = new ArrayList<String>();
		while (rs.next()) {
			genre = rs.getString("gGenre");
			list.add(genre);
		}
		return list;
		

		
		
	}


	public int infoc(String uidx, String pw, String birth, String email) throws SQLException {
		Date d = Date.valueOf(birth);
		System.out.println(d);
		if(pw == null || pw.equals("")) {
			String sql = "UPDATE member SET ubirth = ?, uemail = ? WHERE uidx = ?";
			ps = conn.prepareStatement(sql);
			ps.setDate(1, d);
			ps.setString(2, email);
			ps.setString(3, uidx);
		}else {
			String sql = "UPDATE member SET upw = ?, ubirth = ?, uemail = ? WHERE uidx = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, pw);
			ps.setDate(2, d);
			ps.setString(3, email);
			ps.setString(4, uidx);
		}
		int sc =ps.executeUpdate();
		return sc;
	}

	public int genrec(String uidx, String[] ugenre) throws SQLException {
		int update = 0;
		String sql = "delete from userGenre WHERE uidx = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, uidx);
		if(ps.executeUpdate()>0) {
		
			String sql2 = "INSERT INTO userGenre(gIdx, uIdx, gGenre)"
					+ " VALUES(userGenre_seq.NEXTVAL,?,?)";
			
			System.out.println("cnt: "+ugenre.length);
			
			for(String genre : ugenre) {
				System.out.println("추가되는 장르 : " +genre);
				ps =conn.prepareStatement(sql2);
				ps.setString(1, uidx);
				ps.setString(2, genre);
				update += ps.executeUpdate();
			}
		}
		System.out.println("장르에 추가된 갯수 : "+ update);
		
		return update;
	}



}
