package com.mvc.movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.movie.service.MovieService;


@WebServlet({"/zzim","/searchResult","/delete","/random","/a","/movieList","/movieListG","/movieListS","/movieDetail","/myPageZ"})


public class MovieController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Process(req,resp);
	}

	private void Process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		String con = req.getContextPath();
		String addr = uri.substring(con.length());
		System.out.println(addr);
		RequestDispatcher dis = null;

		MovieService ms = new MovieService(req, resp);

		
		switch (addr) {
			
		case "/movieList":
			System.out.println("전체 영화목록 보여주기");
			req.getSession().setAttribute("mGenre", "");
			ms.movieList();
			break;
			
		case "/movieListG":
			System.out.println("장르별 영화 보여주기");
			String mGenre = req.getParameter("mGenre");
			int page = 0;
			req.getSession().setAttribute("mGenre", mGenre);
			System.out.println(mGenre);
			ms.movieListG(mGenre,page);
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
			System.out.println("뷰에서 랜덤 요청 받음");
			ms.random();
			break;
			
		case "/myPageZ":
			System.out.println("마이페이지 찜목록 두개 보여주기");
			ms.myPageZ();

			break;
			
		
		}
		
		
		
	}
}
