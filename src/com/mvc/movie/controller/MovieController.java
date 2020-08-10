package com.mvc.movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.movie.service.MovieService;


@WebServlet({"/zzim","/searchResult","/search","/random","/del"})

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
		
		case "/login":
//			dis = req.getRequestDispatcher(page);
//			dis.forward(req, resp);
			break;
			
		case "/zzim":
			ms.zzim();
			break;
			
		case "/searchResult":
			ms.searchResult();
			System.out.println("1차 확인");
			break;
			
		case "/search":
			ms.search();
			System.out.println("1차 검색확인");
			break;

		case "/random":
			System.out.println("뷰에서 랜덤 요청 받음");
			ms.random();
			break;
		
		//찜 목록 삭제
		case "/del":
			System.out.println("찜 목록에서 삭제 요청");
			String idx = req.getParameter("idx");
			System.out.println("DEL idx : " + idx);
			ms.del();
			break;
			
		
		}
		
	}
}
