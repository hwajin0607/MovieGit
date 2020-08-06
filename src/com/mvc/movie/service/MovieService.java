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

}
