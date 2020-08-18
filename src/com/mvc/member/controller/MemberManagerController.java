package com.mvc.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.service.MemberManagerService;
import com.mvc.movie.service.MovieManagerService;
import com.mvc.movie.service.MovieService;

@WebServlet({"/member","/memberComment"})
public class MemberManagerController extends HttpServlet {
	MemberManagerService service= null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uri = req.getRequestURI();
		String con = req.getContextPath();
		String addr = uri.substring(con.length());
		System.out.println(addr);
		RequestDispatcher dis = null;
		MovieService ms = new MovieService(req,resp);
		
		switch (addr) {
		case "/member":
			String search = req.getParameter("search"); // 검색어 값 , 검색어가 존재하면 검색기능 //검색어가 없으면 전체검색
			String pageparam = req.getParameter("page");
			System.out.println(search+":"+pageparam);
			
			int page = 1; // 명시 해준 부분
			if(pageparam != null) { 
				System.out.println("if 절 들어오기");
				page = Integer.parseInt(pageparam);
			}
			/*
			 * count = ms.count();
			 * listPage = 10;
			 *  totalPage = count / 10 ;
			 *  if( count % listPage > 0 }
			 * 	 	totalPage++;
			 * totalPage  << 총 페이지
			 * 
			 */
			
			
			MemberManagerService service = new MemberManagerService();
			Object ss = service.list(page,search);
			System.out.println("SS11");
			req.setAttribute("list", ss);
			req.setAttribute("currPage", page);
			//req.setAttribute("endPage", totalPage);
			dis = req.getRequestDispatcher("member.jsp");
			dis.forward(req, resp);
			break;
			
		case "/memberComment":
			String uidx = req.getParameter("uidx"); 
			service = new MemberManagerService();
			ss = service.conlist(uidx);
			System.out.println("SS22");
			req.setAttribute("list", ss);
			req.setAttribute("uidx", uidx);
			dis = req.getRequestDispatcher("memberComment.jsp");
			dis.forward(req, resp);
			break;
		}
	}
	//
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("_method");
		if(method.equals("delete")) {
			doDelete(req, resp);
		}
	}
	//delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String conIdxStr = req.getParameter("conIdxList");
		String uIdx = req.getParameter("uidx");
		if(conIdxStr != null && !conIdxStr.equals("")){
			service = new MemberManagerService();
			String conIdx = conIdxStr;
			try {
				service.delComment(conIdx);
				resp.sendRedirect("memberComment?uidx="+uIdx);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

	
	
}
	

	
	
	

