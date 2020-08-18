package com.mvc.movie.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.mvc.movie.service.MovieManagerService;

@WebServlet("/movie")
@MultipartConfig
public class MovieManagerController extends HttpServlet {
	
	MovieManagerService service = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		req.setCharacterEncoding("utf-8");
		String search = req.getParameter("search"); // 검색어 값 , 검색어가 존재하면 검색기능 //검색어가 없으면 전체검색
		String pageparam = req.getParameter("page");

		int page = 1;
		if(pageparam != null ) {
			page = Integer.parseInt(pageparam);
		}
		service = new MovieManagerService();
		req.setAttribute("list", service.list(page,search));
		req.setAttribute("currPage", page);
		RequestDispatcher dis = req.getRequestDispatcher("movie.jsp");
		dis.forward(req, resp);
	}
	// create
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("_method");
		if(method.equals("delete")) {
			doDelete(req, resp);
		}else if(method.equals("put")){
			doPut(req, resp);
		}else {// post
			
		}
	}
	
	//
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp){
		String movieName = req.getParameter("movieName");
		String openDate = req.getParameter("openDate");
		String genre = req.getParameter("genre");
		String url = req.getParameter("url");
		String age = req.getParameter("age");
		String story = req.getParameter("story");
		String director = req.getParameter("director");
		String actor = req.getParameter("actor");
		
		//System.out.println(movieName + "," + openDate + "," + "");
		
		
		
		//service.create();
		/*
		Part filePart;
		try {
			filePart = req.getPart("poster");
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			InputStream fileContent = filePart.getInputStream();
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Retrieves <input type="file" name="file">
		*/
	}
	
	// delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp){
		System.out.print("gggg");
		String mIdxStr = req.getParameter("mIdxList");
		if(mIdxStr != null && !mIdxStr.equals("")){
			service = new MovieManagerService();
			String mIdx = mIdxStr;
			try {
				service.deleteMovie(mIdx);
				resp.sendRedirect("movie");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
