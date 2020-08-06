package com.mvc.content.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.content.service.Service;


@WebServlet("/content")
public class MainController extends HttpServlet {
	Service service = new Service(); 
	//댓글 목록
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String parm = req.getParameter("page");
		String midx = req.getParameter("mIdx");
		
		int movie = Integer.parseInt(midx);
		
		
		int page = 1;
		if(parm != null ) {
			page = Integer.parseInt(parm);
		}
		req.setAttribute("list", service.list(page, movie));
		req.setAttribute("currPage", page);
		RequestDispatcher dis = req.getRequestDispatcher("content.jsp");
		dis.forward(req, resp);
		
		
	}
	
	
	
	//댓글 생성 및 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 0; //0이면 false
		String uIdx = req.getParameter("uIdx"); 
		String content = req.getParameter("conContent");
		String conIdx = req.getParameter("conIdx");
		String mIdx = req.getParameter("mIdx");
		
		int member = Integer.parseInt(uIdx);
		int movie = Integer.parseInt(mIdx);
		
		// 댓글번호가 비였으면 신규 댓글 작성 // 있으면 댓글수정 (
		if(conIdx == null || conIdx.equals("")) {
			// 신규
			result = service.newContent(member,content,movie); // 리설트를 리턴 할고얌
		}else {
			// 수정\
		int cIdx = Integer.parseInt(conIdx);
			result = service.reContent(member, content, cIdx); // 리설트를 리턴 할고얌
		}
		
		
	}
	
	

	
	
	

}
