package com.mvc.movie.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.service.MemberService;
import com.mvc.movie.service.MovieService;






@WebServlet({"/conup","/page","/zzim","/zzimadd","/searchResult","/Alldel","/del","/random","/movieList","/movieListG","/movieListS","/movieDetail","/selectBhit","/selectGrade","/writeRating","/showRating","/myPageZ","/search","/movieconten","/randomDetail"})



public class MovieController extends HttpServlet {



		@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			Process(req,resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Process(req,resp);
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
			try {
				ms.selectBhit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "/selectGrade":
			try {
				ms.selectGrade();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "/movieList":
			System.out.println("전체 영화목록 보여주기");
			String genre = String.valueOf(req.getSession().getAttribute("mGenre"));
			System.out.println("장르 값 확인 용"+genre);
			String cPage = req.getParameter("page");
			System.out.println("cPage 값 : "+cPage);
			int page = 1;
			if(cPage!=null) {
				page = Integer.parseInt(cPage);
			}
			System.out.println("cPager 값 : "+cPage);
			System.out.println("page 값 : " +page);
			if(genre == null || genre =="null") {
				System.out.println("2차");
				ms.movieList(page);
			}else {
				ms.movieListG(genre,page);
			}
			
			break;
			
		case "/movieListG":
			String mGenre = req.getParameter("mGenre");
			req.getSession().setAttribute("mGenre", mGenre);
			page = 1;
			System.out.println(mGenre);
			ms.movieListG(mGenre,page);
			req.getSession().setAttribute("sort", "1");
			break;
			
		case "/movieListS":
			System.out.println("정렬 하기");
			String mSort = req.getParameter("mSort");
			String sqlb = " ";
			page = 0;
			if(mSort.equals("내림차")) {
				sqlb="DESC";
				req.getSession().setAttribute("sqlb", " DESC");
			}else {
				req.getSession().setAttribute("sqlb", " ");
			}
			//genre = (String) req.getSession().getAttribute("mGenre");
			//if(genre==null) {
			//	genre="";
			//}
			// System.out.println(sqlb+genre);
			//ms.movieListS(sqlb,genre,page);
			ms.test();
			break;
			
			//상세페이지 띄우기
		case "/movieDetail":
			System.out.println("상세페이지 요청");
			String mIdx = req.getParameter("mIdx");
			req.getSession().setAttribute("mIdx", mIdx);
			System.out.println(mIdx);
			try {
				ms.movieDetail(mIdx);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;
			
			
		case "/zzim":
			System.out.println("찜한 목록 가져오기");
			ms.zzim();
			break;
			
		case "/zzimadd":
			System.out.println("찜목록에 보내기");
			String midx = req.getParameter("midx");
			System.out.println(midx);
			ms.zzimadd(midx);
			break;
			
		case "/searchResult":
			System.out.println("1차 확인");
			ms.searchResult();
			break;
			
		case "/search":
			System.out.println("1차 검색확인");
			ms.search();
			break;
		
		//찜 목록 삭제
		case "/del":
			System.out.println("찜 목록에서 삭제 요청");
			String zidx = req.getParameter("zidx");
			System.out.println("DEL zidx : " + zidx);
			ms.del();

			// 랜덤으로 가져오기
		case "/random" :
			System.out.println("랜덤으로 가져오기");
			ms.random();
			break;
			
			//평점 매기기
		case "/writeRating" :
			System.out.println("평점 넣기");
			mIdx = req.getParameter("mIdx");
			System.out.println(mIdx);
			ms.writeRating(mIdx);
			break;
			
		case "/myPageZ":
			System.out.println("마이페이지 찜목록 두개 보여주기");
			ms.myPageZ();
			
		case "/page" :
			
			req.getSession().removeAttribute("mGenre");
			page = 1;
			ms.movieList(page);
			/*System.out.println("페이지 이동");
			//mSort = req.getParameter("mSort");
			//System.out.println("mSort : "+mSort2);
			sqlb = " ";
			page = 1;
			/*
			 * if(mSort.equals("내림차")) { sqlb="DESC"; };


			mGenre = req.getParameter("mGenre");
			String mgenre = (String) req.getSession().getAttribute("mGenre");
			System.out.println(mgenre+"/"+page+"/"+sqlb);
			if(mgenre==null) {
				mgenre="";
			}
			System.out.println(mgenre);
			ms.page(mgenre,page,sqlb);
			*/
			break;
			
		case "/Alldel":
			System.out.println("모든 찜 목록 리스트 삭제");
			String uidx = String.valueOf(req.getSession().getAttribute("uIdx"));
			System.out.println("Alldel uidx : " + uidx);
			ms.Alldel(uidx);
			break;

			

		case "/randomDetail":
			System.out.println("randomDetail");
			ms.randomDetail();
			break;	
			

		case "/movieconten":
			System.out.println("댓글추가");
			uidx = String.valueOf(req.getSession().getAttribute("uIdx"));
			String cont = req.getParameter("contentTxt");
			String contmidx = String.valueOf(req.getSession().getAttribute("mIdx"));
			try {
				ms.conten(uidx,cont,contmidx);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		
		case "/conup":
			System.out.println("댓글수정");
			String coment = req.getParameter("coment");
			String conidx = req.getParameter("conIdx");
			String cmidx = req.getParameter("midx");
			String uIdx = String.valueOf(req.getSession().getAttribute("uIdx"));
			System.out.println(coment+conidx+cmidx);
			try {
				ms.conup(coment,conidx,cmidx,uIdx);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			
		}

		
		
		
	}



		
}
