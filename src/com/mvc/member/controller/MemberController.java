package com.mvc.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.member.service.MemberService;


@WebServlet({"/login","/logout","/join","/overlay"})
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
			ms.login();
			break;
			
		case "/logout":
			System.out.println("로그아웃 요청");
			ms.logout();
			break;
		
		case "/join":
			ms.join();

			break;
		
		case "/overlay":
			ms.overlay();
//			dis = req.getRequestDispatcher('location.href = "Memberjoin.jsp"');
			//dis.forward(req, resp);
			break;
			
		}
		
	}

	
}
