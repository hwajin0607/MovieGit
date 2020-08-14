package com.mvc.movieupload.all;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/movieTest")
public class Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		proccess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		proccess(req, resp);
	}
	
	private void proccess(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//URI - Context => reqAddr
		String uri = req.getRequestURI();
		String ctx = req.getContextPath();
		String reqAddr = uri.substring(ctx.length());
		Service service = new Service(req,resp);
		req.setCharacterEncoding("utf-8");
		switch(reqAddr) {
		
		case "/movieTest":
			System.out.println("여기로 잘 들어왔어??");
			//System.out.println(req.getParameter("movieName"));
			service.movieTest();
			
		break;
		
		}
	}
	

}
