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
		try {
			list = dao.movieList();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			req.setAttribute("movieList", list);
			RequestDispatcher dis = req.getRequestDispatcher("movieList.jsp");
			dis.forward(req, resp);
			dao.resClose();
		}
		
	}
	
	//장르별 영화 목록
	public void movieListG(String mGenre) throws ServletException, IOException {
		System.out.println(mGenre);
		ArrayList<MovieDto> list = null;
		MovieDao dao = new MovieDao();
		try {
			list = dao.movieListG(mGenre);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			req.setAttribute("movieList", list);
			RequestDispatcher dis = req.getRequestDispatcher("movieList.jsp");
			dis.forward(req, resp);
			dao.resClose();
		}
	}

	
	
	//영화 목록 정렬
	public void movieListS(String sqlb, String genre) throws ServletException, IOException {
		System.out.println(sqlb);
		ArrayList<MovieDto> list = null;
		MovieDao dao = new MovieDao();
		try {
			list = dao.movieListS(sqlb,genre);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			req.setAttribute("movieList", list);
			RequestDispatcher dis = req.getRequestDispatcher("movieList.jsp");
			dis.forward(req, resp);
			dao.resClose();
		}
	}

	

	public void zzim() throws ServletException, IOException {
		MovieDao dao = new MovieDao();
		String uidx = "61"; 
		System.out.println("유저 idx" + uidx);
		req.setAttribute("list", dao.list(uidx));
		dis = req.getRequestDispatcher("zzim.jsp");
		dis.forward(req, resp);
		
	}


	public void searchResult() throws ServletException, IOException {
		MovieDao dao = new MovieDao();
		//String mName = req.getParameter("mName");
		//String mGenre = req.getParameter("mGenre");
		String mName ="testDate3";
		String mGenre = "애니메이션";
		System.out.println(mName+mGenre);
		req.setAttribute("srlist", dao.srlist(mName, mGenre));
		dis = req.getRequestDispatcher("searchResult.jsp");
		dis.forward(req, resp);
	}


	public void delete() {
		String uidx = req.getParameter("uidx");
		System.out.println("uidx" + uidx);
		MovieDao dao = new MovieDao();
		
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

	public void selectGrade() {
		MovieDao dao = new MovieDao();
		dao.selectGrade();
	}

	public void selectBhit() {
		MovieDao dao = new MovieDao();
		dao.selectBhit();
	}

}
