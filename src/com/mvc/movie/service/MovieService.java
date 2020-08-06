package com.mvc.movie.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.movie.dao.MovieDao;

public class MovieService {
	HttpServletRequest req = null;
	HttpServletResponse resp = null;
	RequestDispatcher dis = null;
	
	public MovieService(HttpServletRequest req,HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
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

}
