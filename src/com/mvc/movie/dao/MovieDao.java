package com.mvc.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		String sql = "SELECT m.midx, ROUND(avg(r.mrrating),2) mravg FROM (SELECT ROW_NUMBER() OVER (ORDER by m.midx DESC) rnum, midx FROM movie m) m ,"
				+ "movieRating r where m.midx = r.midx AND r.midx BETWEEN 1 AND 10 GROUP by m.midx ORDER by mravg DESC";
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

	public ArrayList<MovieDto> selectBhit() throws SQLException {
		String sql = "SELECT mName, mBhit FROM (SELECT ROW_NUMBER() OVER (ORDER by midx DESC) rnum,"
				+ " mName, mBhit FROM movie) WHERE rnum BETWEEN 1 AND 10 ORDER by mBhit DESC";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			MovieDto dto = new MovieDto();
			dto.setmName(rs.getString("mName"));
			list.add(dto);
		}
		return list;
	}
	
    //전체영화목록	
	public ArrayList<MovieDto> movieList(int page) throws SQLException {
		int pagePerCnt = 4; //페이지당 보여줄 게시물의 수
		int end = page*pagePerCnt;
		int start = (end-pagePerCnt)+1;
		System.out.println(start);
		String sql ="SELECT DISTINCT mName, uidx, midx, mfurl , zidx, zdate FROM"
						+ " (SELECT DISTINCT ROW_NUMBER() OVER(ORDER BY uidx DESC) AS rnum, m.mName, z.uidx, z.midx, m.mfurl , z.zidx, z.zdate FROM"
						+ " (SELECT m.midx,m.mname ,f.mfidx,f.mfurl FROM movie m, moviefoster f WHERE m.midx = f.midx) m,"
						+ " zzim z where m.midx = z.midx)"
						+ " WHERE uidx =? BETWEEN ? AND ? ORDER BY uidx";
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
	public ArrayList<MovieDto> list(int page, String uidx) throws SQLException {
		int pagePerCnt =4;//페이지당 보여줄 게시물 갯수
		int end = page*pagePerCnt;
		int start = 1;
		System.out.println("start : " + start);
		System.out.println("uidx : "+ uidx);
		System.out.println("end : "+end);
		
		String sql ="SELECT DISTINCT mName, uidx, midx, mfurl , zidx, zdate FROM (SELECT DISTINCT ROW_NUMBER() OVER(ORDER BY uidx DESC) AS rnum, m.mName, z.uidx, z.midx, m.mfurl , z.zidx, z.zdate FROM (SELECT m.midx,m.mname ,f.mfidx,f.mfurl FROM movie m, moviefoster f WHERE m.midx = f.midx) m, zzim z where m.midx = z.midx) WHERE uidx =? and rnum BETWEEN ? AND ? ORDER BY zdate";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, uidx);
			ps.setInt(2, start);
			ps.setInt(3, end);
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
			}
			return list;
	}
	
	
	
	//검색 목록 리스트
	public ArrayList<MovieDto> srlist(int page, String mName) throws SQLException {
					int pagePerCnt =4;//페이지당 보여줄 게시물 갯수
					int end = page*pagePerCnt;
					int start = (end-pagePerCnt)+1;
		
		String sql ="SELECT DISTINCT rnum, mIdx,mopen, mName, mGenre, mfUrl FROM "
						+" (SELECT DISTINCT ROW_NUMBER() OVER(ORDER BY m.mopen) AS rnum,m.mIdx,m.mopen, m.mName, m.mGenre, f.mfUrl FROM movie m" 
						+"JOIN moviefoster f on m.midx = f.midx where mName LIKE ? or mgenre LIKE ?) WHERE  rnum BETWEEN 1 AND 4 ORDER BY rnum";
				
		ArrayList<MovieDto> srlist = new ArrayList<MovieDto>();
		
				/*"SELECT DISTINCT m.midx, m.mName, m.mGenre, d.mdDirector, a.maActor, m.mUrl, m.mAge, m.mOpen" 
					+" FROM movie m, movieDirector d, movieActor a"
					+" where m.midx = d.midx and d.midx = a.midx and a.maActor = ? or d.mdDirector = ? or m.mName = ?  or m.mGenre = ?";*/
		
		
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
		
		return srlist;
}
	// 랜덤으로 값 가져오기 
	public MovieDto random() {
		String sql = "SELECT m.mIdx, m.mName, f.mfUrl "
				+ "FROM Movie m, movieFoster f "
				+ "WHERE m.midx = f.midx "
				+ "ORDER BY SYS.dbms_random.VALUE";
		MovieDto dto = new MovieDto();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setmIdx(rs.getInt("mIdx"));
				dto.setmName(rs.getString("mName"));
				dto.setMfUrl(rs.getString("mfUrl"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	//
	public void grademName(ArrayList<MovieDto> list) {
		// TODO Auto-generated method stub
		
	}

	
	public ArrayList<MovieDto> slist(int page, String gen) throws SQLException {
		int pagePerCnt =4;//페이지당 보여줄 게시물 갯수
		int end = page*pagePerCnt;
		int start = 1;
	
		String str ="%"+gen+"%";
		String sql = "SELECT DISTINCT rnum, mIdx,mopen, mName, mGenre, mfUrl FROM "
						+" (SELECT DISTINCT ROW_NUMBER() OVER(ORDER BY m.mopen) AS rnum,m.mIdx,m.mopen, m.mName, m.mGenre, f.mfUrl FROM movie m" 
						+" JOIN moviefoster f on m.midx = f.midx where mName LIKE ? or mgenre LIKE ?) WHERE  rnum BETWEEN ? AND ? ORDER BY rnum";
		ArrayList<MovieDto> slist = new ArrayList<MovieDto>();

			ps=conn.prepareStatement(sql);
			ps.setString(1, str);
			ps.setString(2, str);
			ps.setInt(3, start);
			ps.setInt(4, end);
			rs=ps.executeQuery();
			while(rs.next()) {
				MovieDto dto = new MovieDto();	
				dto.setmName(rs.getString("mName"));
				dto.setmGenre(rs.getString("mGenre"));
				dto.setmIdx(rs.getInt("mIdx"));
				dto.setMfUrl(rs.getString("mfUrl"));
				slist.add(dto);
			}
			System.out.println(slist);
		return slist;
	}

	public boolean del(String uidx,String zidx) {
		System.out.println("uidx 점검 : " + uidx);
		String sql = "DELETE FROM zzim WHERE uidx=? AND zidx=?";
		boolean result = false;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, uidx);
			ps.setString(2, zidx);
			int success =ps.executeUpdate();
			if(success>0) {
				result=true;
			}
		} catch (SQLException e) {
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
	
	//영화 상세페이지 보여주기
	public ArrayList<MovieDto> movieDetail(String mIdx) {
		System.out.println("dao 일 시키기");
		String sql = "select DISTINCT m.mIdx, m.mName, m.mGenre, m.mUrl, m.mAge, m.mContent, d.mddirector, a.maactor, f.mfurl,"
				+ "(select ROUND(AVG(mrRating),1) from movierating where midx = ?)as mrRating, "
				+ "(select COUNT(uidx) from movierating where midx = ?) as uIdx "
				+ "from Movie m, moviedirector d, movieactor a, moviefoster f where m.mIdx = ?";
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mIdx);
			ps.setString(2, mIdx);
			ps.setString(3, mIdx);
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
				dto.setMrRating(rs.getDouble("mrRating"));
				dto.setUidx(rs.getInt("uidx"));
				System.out.println(rs.getInt("uidx"));
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

	public boolean Alldel(String uidx) {
		System.out.println("전체 삭제 해라");
		String sql ="DELETE FROM zzim WHERE uidx=?";
		boolean Alldel = false;
		System.out.println("uidx : "+uidx);
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, uidx);
			int success =ps.executeUpdate();
			if(success>0) {
				Alldel=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			resClose();
		}
		return Alldel;
	}

	// 평점 매기기
	public boolean writeRating(String mIdx, String pjpoint, String uIdx) {
		System.out.println("dao 일 시키기");
		boolean result = false;
		String sql = "SELECT * FROM movieRating where uidx = ? and midx = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uIdx);
			ps.setString(2, mIdx);
			rs = ps.executeQuery();
			System.out.println(rs);
			if(rs.next() == false) {
				String sql2 ="INSERT INTO movierating(mridx, uidx, midx, mrrating) VALUES(movieRating_seq.NEXTVAL,?,?,?)";
				System.out.println("한번도 평점을 매기지않은 회원이 평점을 매길 경우");
				try {
					ps = conn.prepareStatement(sql2);
					ps.setString(1, uIdx);
					ps.setString(2, mIdx);
					ps.setString(3, pjpoint);
					if(ps.executeUpdate()>0) {
						result = true;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
	
			}else {
				result = false;
				System.out.println("한번이라도 평점을 매긴 회원이 평점을 매길 경우");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			result = false;
		}

		return result;

	}

	

}
