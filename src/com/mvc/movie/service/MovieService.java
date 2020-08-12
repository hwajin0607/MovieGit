package com.mvc.movie.service;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.movie.dao.MovieDao;
import com.mvc.movie.dto.MovieDto;


public class MovieService {
		HttpServletRequest req = null;
	    HttpServletResponse resp = null;
	    RequestDispatcher dis = null;


	   public MovieService(HttpServletRequest req, HttpServletResponse resp) {
	      this.req =req;
	      this.resp =resp;
	   }
	   
	 //전체영화목록	
	public void movieList() throws ServletException, IOException {
		ArrayList<MovieDto> list = null;
		MovieDao dao = new MovieDao();
		
		String pageParam = req.getParameter("page");
		int page = 1;
		if(pageParam != null) {
			page = Integer.parseInt(pageParam);
			
			if(page == 0) {
				page = 1;
			}
		}
		
		try {
			list = dao.movieList(page);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			req.setAttribute("currPage", page);
			req.setAttribute("movieList", list);
			RequestDispatcher dis = req.getRequestDispatcher("movieList.jsp");
			dis.forward(req, resp);
			dao.resClose();
		}
		
	}
	
	//장르별 영화 목록
	public void movieListG(String mGenre,int page) throws ServletException, IOException {
		System.out.println(mGenre);
		ArrayList<MovieDto> list = null;
		MovieDao dao = new MovieDao();
		
		String pageParam = req.getParameter("page");
		page = 1;
		if(pageParam != null) {
			page = Integer.parseInt(pageParam);
			
			if(page == 0) {
				page = 1;
			}
		}
		
		try {
			list = dao.movieListG(mGenre,page);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			req.setAttribute("currPage", page);
			req.setAttribute("movieList", list);
			RequestDispatcher dis = req.getRequestDispatcher("movieList.jsp");
			dis.forward(req, resp);
			dao.resClose();
		}
	}

	
	
	//영화 목록 정렬
	public void movieListS(String sqlb, String genre, int page) throws ServletException, IOException {
		System.out.println(sqlb);
		ArrayList<MovieDto> list = null;
		MovieDao dao = new MovieDao();
		
		String pageParam = req.getParameter("page");
		page = 1;
		if(pageParam != null) {
			page = Integer.parseInt(pageParam);
			
			if(page == 0) {
				page = 1;
			}
		}
		try {
			list = dao.movieListS(sqlb,genre,page);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			req.setAttribute("movieList", list);
			req.setAttribute("currPage", page);
			RequestDispatcher dis = req.getRequestDispatcher("movieList.jsp");
			dis.forward(req, resp);
			dao.resClose();
		}
	}

	
	//찜한 영화 목록
	public void zzim() throws ServletException, IOException {
		MovieDao dao = new MovieDao();
		String uidx = "61";
		System.out.println("유저 idx : " + uidx );
		req.setAttribute("list", dao.list(uidx));
		dis = req.getRequestDispatcher("zzim.jsp");
		dis.forward(req, resp);
		
	}

	//검색한 영화 불러오기
	public void searchResult() throws ServletException, IOException {
		MovieDao dao = new MovieDao();
		String mName = req.getParameter("searchTxt");
		System.out.println(mName);
		req.setAttribute("srlist", dao.srlist(mName));
		dis = req.getRequestDispatcher("searchResult.jsp");
		dis.forward(req, resp);
	}

	//보고 싶은 영화 검색하기
	public void search() throws ServletException, IOException {
		MovieDao dao = new MovieDao();
		String mName = "testDate3";
		String mGenre = "호러";
		String mdDirector = "더미데이터";
		String maActor = "더미데이터 배우";
		System.out.println("파라메터 점검 : " +mName+ mGenre+ mdDirector+ maActor);
		req.setAttribute("slist", dao.slist(mName, mGenre, mdDirector, maActor));
		dis = req.getRequestDispatcher("searchResult.jsp");
		dis.forward(req, resp);
		
		
	}

	
	//랜덤으로 영화 한개 불러오기
	public void random() throws IOException, ServletException {
		MovieDao dao = new MovieDao();
		ArrayList<MovieDto>list = dao.random();
		System.out.println(list);
			req.setAttribute("list", list);
			RequestDispatcher dis = req.getRequestDispatcher("main_bottom.jsp");
			dis.forward(req, resp);
			dao.resClose();
	}
	
	//마이페이지 찜목록
	public void myPageZ() throws ServletException, IOException {
		ArrayList<MovieDto> list = null;
		String uIdx = "61";
		MovieDao dao = new MovieDao();
		try {
			list = dao.myPageZ(uIdx);
			dao.myPageM(list);
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			req.setAttribute("myPageZ", list);
			RequestDispatcher dis = req.getRequestDispatcher("myPage.jsp");
			dis.forward(req, resp);
			dao.resClose();
		}
	}

	public void selectGrade() throws SQLException, ServletException, IOException {	
		MovieDao dao = new MovieDao();
		ArrayList<MovieDto>list2 =dao.selectGrade();
		ArrayList<MovieDto> list = dao.grademName(list2);
		System.out.println("평점순" + list.get(0).getmName());
		System.out.println("평점순" + list.get(0).getMfUrl());
		req.setAttribute("list", list);
		RequestDispatcher dis = req.getRequestDispatcher("select.jsp");
		dis.forward(req, resp);
		dao.resClose();
	}

	public void selectBhit() throws SQLException, ServletException, IOException {
		MovieDao dao = new MovieDao();
		ArrayList<MovieDto>list = dao.selectBhit();
		System.out.println("123"+list);
		System.out.println("조회순" + list.get(0).getmName());
		System.out.println("조회순" + list.get(0).getMfUrl());
		req.setAttribute("list", list);
		RequestDispatcher dis = req.getRequestDispatcher("select.jsp");
		dis.forward(req, resp);
		dao.resClose();

	}

	//영화 상세페이지에 내용 띄우기
	public void movieDetail(String mIdx) throws ServletException, IOException {
		System.out.println("서비스에게 일을 시킨다.");
		MovieDao dao = new MovieDao();
		ArrayList<MovieDto>list = dao.movieDetail(mIdx);
		System.out.println(list);
		req.setAttribute("list", list);
		RequestDispatcher dis = req.getRequestDispatcher("movie_detail.jsp");
		dis.forward(req, resp);
		dao.resClose();
	}
	
	//찜목록에 보내기
	public void zzimadd(String midx) {
		System.out.println("찜목록에보내기 서비스");
		MovieDao dao = new MovieDao();
		String uIdx = (String) req.getSession().getAttribute("uIdx");
	}

	// 평점 넣기
	public void writeRating(String mIdx) {
		System.out.println("서비스에게 일 시킨다.");
		String pjpoint = req.getParameter("pjpoint");
		mIdx = req.getParameter("mIdx");
		System.out.println(pjpoint+"/"+mIdx);
		
	}
				
	public void del() throws ServletException, IOException {
		String uidx = req.getParameter("uidx");
		System.out.println("점검 : " + uidx);
		
		MovieDao dao = new MovieDao();
		dao.del(uidx);
		String page = "/zzim";
		RequestDispatcher dis =req.getRequestDispatcher(page);
		dis.forward(req, resp);
	}

}
