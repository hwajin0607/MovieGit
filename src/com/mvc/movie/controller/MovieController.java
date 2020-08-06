package com.mvc.movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.movie.service.MovieService;

@WebServlet({"/selectBhit","/selectGrade"})
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

	private void Process(HttpServletRequest req, HttpServletResponse resp) {
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
		}
		
	}
}
