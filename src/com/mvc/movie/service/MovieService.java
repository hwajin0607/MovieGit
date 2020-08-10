package com.mvc.movie.service;

import java.io.IOException;

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
	
	public MovieService(HttpServletRequest req,HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
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

	public void del() throws ServletException, IOException {
		String uidx = req.getParameter("uidx");
		System.out.println("정검 : " + uidx);
		
		MovieDao dao = new MovieDao();
		dao.del(uidx);
		String page = "/zzim";
		RequestDispatcher dis =req.getRequestDispatcher(page);
		dis.forward(req, resp);
	}

}
