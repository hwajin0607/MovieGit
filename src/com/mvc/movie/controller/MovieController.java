package com.mvc.movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.movie.service.MovieService;



@WebServlet({"/","/zzim","/searchResult","/delete","/random","/a","/movieList","/movieListG","/movieListS","/movieDetail","/selectBhit","/selectGrade"})


public class MovieController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Process(req,resp);
		req.setCharacterEncoding("UTF-8");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Process(req,resp);
		req.setCharacterEncoding("UTF-8");
	}

	private void Process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		String con = req.getContextPath();
		String addr = uri.substring(con.length());
		System.out.println(addr);
		RequestDispatcher dis = null;
		MovieService ms = new MovieService(req,resp);
		
		switch (addr) {
		
		case "/selectBhit":
			ms.selectBhit();
			break;
			
		case "/selectGrade":
			ms.selectGrade();
			break;
			
		case "/movieList":
			System.out.println("전체 영화목록 보여주기");
			ms.movieList();
			break;
			
		case "/movieListG":
			System.out.println("장르별 영화 보여주기");
			String mGenre = req.getParameter("mGenre");
			req.getSession().setAttribute("mGenre", mGenre);
			System.out.println(mGenre);
			ms.movieListG(mGenre);
			break;
			
		case "/movieListS":
			System.out.println("정렬 하기");
			String mSort = req.getParameter("mSort");
			String sqlb = " ";
			if(mSort.equals("내림차")) {
				sqlb="DESC";
			}
			String genre = (String) req.getSession().getAttribute("mGenre");
			if(genre==null) {
				genre="";
			}
			System.out.println(sqlb+genre);
			ms.movieListS(sqlb,genre);
			break;
			
		case "/movieDetail":
			System.out.println("상세페이지 요청");
			String mIdx = req.getParameter("mIdx");
			//req.getSession().setAttribute("mIdx", mIdx);
			System.out.println(mIdx);
			ms.movieDetail(mIdx);
			break;
			
			
		case "/zzim":
			ms.zzim();
			break;
			
		case "/searchResult":
			ms.searchResult();
			System.out.println("1차 확인");
			break;
			
		case "/delete":
			ms.delete();
			System.out.println("1차 확인");
			break;

		case "/random" :
			System.out.println("랜덤으로 가져오기");
			ms.random();
			break;
			
		
		}
		
		
		
	}
}
