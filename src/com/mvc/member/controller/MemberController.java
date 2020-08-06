package com.mvc.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.service.MemberService;




@WebServlet("/member")

public class MemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String search = req.getParameter("search"); // 검색어 값 , 검색어가 존재하면 검색기능 //검색어가 없으면 전체검색
		String pageparam = req.getParameter("page");


		int page = 1;
		if(pageparam != null ) {
			page = Integer.parseInt(pageparam);
		}
		MemberService service = new MemberService();
		req.setAttribute("list", service.list(page,search));
		req.setAttribute("currPage", page);
		RequestDispatcher dis = req.getRequestDispatcher("member.jsp");
		dis.forward(req, resp);

	}


	
	
	
	
}


	



