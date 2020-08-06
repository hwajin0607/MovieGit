package com.mvc.movie.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.movie.dao.MovieDao;

public class MovieService {

	HttpServletRequest req = null;
	HttpServletResponse resp = null;

	public MovieService(HttpServletRequest req, HttpServletResponse resp) {
		this.req =req;
		this.resp =resp;
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
