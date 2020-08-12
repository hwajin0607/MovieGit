package com.mvc.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.service.MemberManagerService;

@WebServlet("/member")
public class MemberManagerController extends HttpServlet {

	
	
	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("DD");
		String search = req.getParameter("search"); // 검색어 값 , 검색어가 존재하면 검색기능 //검색어가 없으면 전체검색
		String pageparam = req.getParameter("page");

		System.out.println("SS");
		int page = 1;
		if(pageparam != null ) {
			page = Integer.parseInt(pageparam);
			MemberManagerService service = new MemberManagerService();
			Object ss = service.list(page,search);
			System.out.println("SS11");
			req.setAttribute("list", ss);
			req.setAttribute("currPage", page);
			RequestDispatcher dis = req.getRequestDispatcher("member.jsp");
			dis.forward(req, resp);
		}
	}
}
