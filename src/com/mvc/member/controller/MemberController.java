package com.mvc.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.dao.MemberDao;
import com.mvc.member.service.MemberService;




@WebServlet({"/login","/logout","/join","/overlay","/info","/changing","/infoc","/like"})

public class MemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			Process(req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			Process(req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void Process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String uri = req.getRequestURI();
		String con = req.getContextPath();
		String addr = uri.substring(con.length());
		System.out.println(addr);
		RequestDispatcher dis = null;
		MemberService ms = new MemberService(req,resp);
		
		switch (addr) {
		
		case "/login":
	         System.out.println("로그인 요청");
	         String id = req.getParameter("id");
	         String pw = req.getParameter("pw");
	         System.out.println(id+"/"+pw);
	         String page = "login.jsp";
	         String msg = "로그인에 실패 하였습니다.";
	         int login = ms.login(id,pw);
	         if(login != 0) {
	             msg = "로그인에 성공 하였습니다.";
	             req.getSession().setAttribute("uIdx", login);
	             req.getSession().setAttribute("loginId", id);
	             
	          }
	         String uidx = String.valueOf(req.getSession().getAttribute("uIdx"));
	         System.out.println(uidx);
	         req.setAttribute("msg", msg);
	         dis = req.getRequestDispatcher("like");
	         dis.forward(req, resp);
	         break;
			
		case "/logout":
			req.getSession().removeAttribute("loginId");
			
			resp.sendRedirect("login.jsp");
			break;
		
		case "/join":
			ms.join();

			break;
		
		case "/overlay":
			ms.overlay();
//			dis = req.getRequestDispatcher('location.href = "Memberjoin.jsp"');
			//dis.forward(req, resp);
			break;
			

		case "/like":
			System.out.println("취향 요청");
			ms.like();
			break;

		case "/info":
			System.out.println("정보");
			ms.info();

			break;
			
		case "/changing":
			System.out.println("회원상세정보");
			ms.changing();

			break;
			
		case "/infoc":
			System.out.println("정보수정");
			ms.infoc();

			break;


			
		}
		
	}

	
}
