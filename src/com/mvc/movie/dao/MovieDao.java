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

	public ArrayList<MovieDto> selectGrade() throws SQLException {
		String sql = "select z.rnum, m.midx, z.mravg from (SELECT ROW_NUMBER() OVER(ORDER BY ROUND(avg(r.mrrating),2) DESC) \r\n" + 
				"AS rnum, m.midx, ROUND(avg(r.mrrating),2) mravg FROM movie m \r\n" + 
				",movieRating r where m.midx = r.midx GROUP by m.midx ORDER by mravg DESC) z, movie m where m.midx = z.midx  AND z.rnum BETWEEN 1 AND 10";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			MovieDto dto = new MovieDto();
			dto.setmIdx(rs.getInt("mIdx"));
			dto.setMravg(rs.getString("mravg"));
			list.add(dto);
		}
		return list;
		
	}
	public ArrayList<MovieDto> grademName(ArrayList<MovieDto> list) throws SQLException {
		String sql = "SELECT m.midx, m.mName, f.mfurl FROM movie m, moviefoster f WHERE m.midx = f.midx AND m.midx = ?";
		ArrayList<MovieDto> grade = new ArrayList<MovieDto>();
		for(int i = 0; i<list.size(); i++) {
			ps=conn.prepareStatement(sql);
			String st = String.valueOf(list.get(i).getmIdx());
			System.out.println("으어어어"+st);
			ps.setString(1, st);
			rs = ps.executeQuery();
			while(rs.next()) {
				MovieDto dto = new MovieDto();
				dto.setmName(rs.getString("mName"));
				dto.setMfUrl(rs.getString("MfUrl"));
				grade.add(dto);
			}
		}
		return grade;
	}

	public ArrayList<MovieDto> selectBhit() throws SQLException {
		String sql = "SELECT m.mName, m.mBhit, m.midx, f.mfURL FROM "
				+ "(SELECT ROW_NUMBER() OVER (ORDER by midx DESC) rnum, mName, mBhit, midx FROM movie) m "
				+ ", moviefoster f WHERE m.midx = f.midx AND rnum BETWEEN 1 AND 10 ORDER by mBhit DESC";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			MovieDto dto = new MovieDto();
			dto.setmName(rs.getString("mName"));
			dto.setMfUrl(rs.getString("MfUrl"));
			list.add(dto);
		}
		return list;
	}
	
	public ArrayList<MovieDto> img(ArrayList<MovieDto> list) throws SQLException {
		String sql = "SELECT mfURL FROM moviefoster WHERE midx = ?";
		ArrayList<MovieDto> movieimg = new ArrayList<MovieDto>();
		for(int i = 0; i<list.size(); i++) {
			ps=conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(list.get(i).getmIdx()));
			System.out.println(String.valueOf(list.get(0).getmIdx()));
			rs = ps.executeQuery();
			while(rs.next()) {
				MovieDto dto = new MovieDto();
				dto.setMfUrl(rs.getString("mfURL"));
				movieimg.add(dto);
			}
		}
		return movieimg;
	}
	
    //전체영화목록	
	public ArrayList<MovieDto> movieList(int page) throws SQLException {
		int pagePerCnt = 4; //페이지당 보여줄 게시물의 수
		int end = page*pagePerCnt;
		int start = (end-pagePerCnt)+1;
		System.out.println(start);
		String sql = "SELECT DISTINCT m.rnum, m.mIdx, m.mName, m.mOpen, m.mGenre, m.mUrl, m.mBhit, m.mDate, m.mAge, m.mContent, f.mfURL FROM (SELECT ROW_NUMBER() OVER(ORDER BY m.mIdx DESC) AS rnum, m.mIdx, m.mName, m.mOpen, m.mGenre, m.mUrl, m.mBhit, m.mDate, m.mAge, m.mContent, f.mfURL FROM movie m, movieFoster f WHERE m.mIdx = f.midx) m, movieFoster f WHERE m.rnum BETWEEN ? AND ? ORDER BY m.rnum";
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
		String sql = "SELECT DISTINCT m.rnum, m.mIdx, m.mName, m.mOpen, m.mGenre, m.mUrl, m.mBhit, m.mDate, m.mAge, m.mContent, f.mfURL FROM (SELECT ROW_NUMBER() OVER(ORDER BY m.mIdx DESC) AS rnum, m.mIdx, m.mName, m.mOpen, m.mGenre, m.mUrl, m.mBhit, m.mDate, m.mAge, m.mContent, f.mfURL FROM movie m, movieFoster f WHERE m.mIdx = f.midx and m.mgenre =?) m, movieFoster f WHERE m.rnum BETWEEN ? AND ? ORDER BY m.rnum";
		/*String sql = "SELECT mIdx, mName, mOpen, mGenre, mUrl, mBhit, mDate, mAge, mContent FROM Movie "
				+ "WHERE mGenre = ? ORDER BY mName DESC";*/
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		ps = conn.prepareStatement(sql);
		ps.setString(1, mGenre);
		ps.setInt(2, start);
		ps.setInt(3, end);
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
	public ArrayList<MovieDto> movieListS(String sqlb, String genre, int page) throws SQLException {
		int pagePerCnt = 4; //페이지당 보여줄 게시물의 수
		int end = page*pagePerCnt;
		int start = (end-pagePerCnt)+1;
		
		if(genre.equals("")||genre==null) {
			String sql = "SELECT DISTINCT m.rnum, m.mIdx, m.mName, m.mOpen, m.mGenre, m.mUrl, m.mBhit, m.mDate, m.mAge, m.mContent, f.mfURL FROM (SELECT ROW_NUMBER() OVER(ORDER BY m.mIdx DESC) AS rnum, m.mIdx, m.mName, m.mOpen, m.mGenre, m.mUrl, m.mBhit, m.mDate, m.mAge, m.mContent, f.mfURL FROM movie m, movieFoster f WHERE m.mIdx = f.midx) m, movieFoster f WHERE m.rnum BETWEEN ? AND ? ORDER BY m.mOpen "+sqlb;
			System.out.println(sqlb);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
		}else {
			String sql = "SELECT DISTINCT m.rnum, m.mIdx, m.mName, m.mOpen, m.mGenre, m.mUrl, m.mBhit, m.mDate, m.mAge, m.mContent, f.mfURL FROM (SELECT ROW_NUMBER() OVER(ORDER BY m.mIdx DESC) AS rnum, m.mIdx, m.mName, m.mOpen, m.mGenre, m.mUrl, m.mBhit, m.mDate, m.mAge, m.mContent, f.mfURL FROM movie m, movieFoster f WHERE m.mIdx = f.midx and m.mgenre =?) m, movieFoster f WHERE m.rnum BETWEEN ? AND ? ORDER BY m.mOpen "+sqlb;
			ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
			ps.setInt(2, start);
			ps.setInt(3, end);
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
		String sql ="SELECT DISTINCT mo.mName, z.uidx, z.midx, m.mfurl FROM movie mo,zzim z,(SELECT m.midx, f.mfidx,f.mfurl FROM movie m, moviefoster f WHERE m.midx = f.midx) m WHERE mo.midx = z.midx and z.uidx =?";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uidx);
			rs = ps.executeQuery();
			while(rs.next()) {
				MovieDto dto = new MovieDto();
				dto.setUidx(rs.getInt("uidx"));
				dto.setMfUrl(rs.getString("mfurl"));
				dto.setmName(rs.getString("mName"));
				dto.setmIdx(rs.getInt("midx"));
				dto.setZidx(rs.getInt("zidx"));
				dto.setZdate(rs.getDate("zdate"));
				list.add(dto);
				
				System.out.println(dto.getmName());
				System.out.println(dto.getmIdx());
				System.out.println(dto.getMfUrl());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			resClose();
		}
		
		return list;
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
				dto.setmIdx(rs.getInt("midx"));
				dto.setMaActor(rs.getString("maActor"));
				dto.setmName(rs.getString("mName"));
				dto.setmOpen(rs.getDate("mOpen"));
				dto.setmGenre(rs.getString("mGenre"));
				dto.setmUrl(rs.getString("mUrl"));
				dto.setmAge(rs.getInt("mAge"));
				dto.setMdDirector(rs.getString("mdDirector"));
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
				dto.setMdDirector(rs.getString("mdDirector"));
				dto.setMaActor(rs.getString("maActor"));
				result = false;
				System.out.println("점검 : " + dto.getmName()+ dto.getmGenre()+ dto.getMdDirector()+ dto.getMaActor());
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
				dto.setmIdx(rs.getInt("mIdx"));
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
	
	public ArrayList<MovieDto> movieDetail(String mIdx) {
		System.out.println("dao 일 시키기");
		String sql = "select DISTINCT m.mIdx, m.mName, m.mGenre, m.mUrl, m.mAge, m.mContent, d.mddirector, a.maactor, f.mfurl,"
				+ "(select ROUND(AVG(mrRating),1) from movierating where midx = ?)as mrRating from Movie m, moviedirector d, movieactor a, moviefoster f where m.mIdx = ?";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mIdx);
			ps.setString(2, mIdx);
			rs = ps.executeQuery();
			boolean su = rs.next();
			while(su) {
				MovieDto dto = new MovieDto();
				dto.setmIdx(rs.getInt("mIdx"));
				dto.setmName(rs.getString("mName"));
				dto.setmGenre(rs.getString("mGenre"));
				dto.setmUrl(rs.getString("mUrl"));
				dto.setmAge(rs.getInt("mAge"));
				dto.setmContent(rs.getString("mContent"));
				dto.setMdDirector(rs.getString("mddirector"));
				dto.setMaActor(rs.getString("maactor"));
				dto.setMfUrl(rs.getString("mfurl"));
				System.out.println(rs.getDouble("mrRating"));
				dto.setMrRating(rs.getDouble("mrRating"));
				System.out.println(dto.getmIdx()+"/"+dto.getmName()+"/"+dto.getmGenre()+"/"+dto.getmUrl()+"/"+dto.getmAge()+"/"+dto.getmContent()+"/"
						+dto.getMdDirector() +"/"+ dto.getMaactor() +"/"+ dto.getMfUrl()+"/"+dto.getMrRating());
				System.out.println(dto.getmIdx()+"/"+dto.getmName()+"/"+dto.getmGenre()+"/"+dto.getmUrl()+"/"+dto.getmAge()+"/"+dto.getmContent()+"/"
						+dto.getMdDirector() +"/"+ dto.getMaactor() +"/"+ dto.getMfUrl());
				su = false;
				list.add(dto);
			}
			System.out.println("값을 가져오기");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return list;
	}	

}
