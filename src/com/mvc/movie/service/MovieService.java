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

	HttpServletRequest req =null;
	HttpServletResponse resp = null;
	
	public MovieService(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
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

}
