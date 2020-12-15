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

@WebServlet({"/login","/logout","/join","/overlay","/info","/changing","/infoc","/like","/conDel"})


public class MemberController extends HttpServlet {

	
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
		
		//내가 한 부분 - 로그인
	      case "/login":
		  	System.out.println("로그인 요청");
            String id = req.getParameter("id");
            String pw = req.getParameter("pw");
            System.out.println(id+"/"+pw);
            String page = "login.jsp";
            String msg = "아이디와 패스워드를 확인해 주세요.";
            
            int login = 0;
            
            if(id==null || pw ==null) {
            	msg = "로그인이 필요한 서비스 입니다.";
            }
        	login = ms.login(id,pw);

            if(login != 0) {
            	msg = "로그인에 성공 하였습니다.";
                page = "like";
                if(id.equals("manager")){
                	msg = "관리자 페이지 입니다.";
                	page="manager.jsp";	
                } 
            }
            req.getSession().setAttribute("loginId", id);
            req.getSession().setAttribute("loginPw", pw);
            req.getSession().setAttribute("uIdx", login);
            req.getSession().setAttribute("sort","0");

            System.out.println("loginId=="+req.getSession().getAttribute("loginId"));
            req.setAttribute("msg", msg);
            dis = req.getRequestDispatcher(page);
            dis.forward(req, resp);
            break;
			
      //내가 한 부분 - 로그아웃
		case "/logout":
			req.getSession().removeAttribute("uIdx");
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
			
		//내가 한 부분 - 사용자의 취향에 맞춰 8개 추천영화 리스트 가져오기
		case "/like":
			System.out.println("취향 요청");
			 String pageParam = req.getParameter("page");
				int page1 = 1;
				page=null;
				if(pageParam != null) {
					page1 = Integer.parseInt(pageParam);
				}
				
				 if(req.getSession().getAttribute("loginId")=="manager") {
						page="manager.jsp";	 
					}
				 else if(req.getSession().getAttribute("uIdx") != "") {
					 ms.like(page1);		
					 page="main_top.jsp";
				}
				dis = req.getRequestDispatcher(page);
				dis.include(req, resp);
				req.setAttribute("currPage", page1);
			
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
			
		case "/conDel":
			System.out.println("댓글 삭제");
			ms.conDel();

			break;
			

		}
	}


}


	
	
	
	



	



