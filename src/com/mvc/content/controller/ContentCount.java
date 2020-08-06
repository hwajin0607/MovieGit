package com.mvc.content.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.content.service.Service;

@WebServlet("")
public class ContentCount extends HttpServlet {
	Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String conIdx = req.getParameter("conIdx");
		String uIdx = req.getParameter("uIdx");
		
		int cId = Integer.parseInt(conIdx);
		int uId = Integer.parseInt(uIdx);
		
		req.setAttribute("count", service.count(cId,uId));
		RequestDispatcher dis = req.getRequestDispatcher("");
		dis.forward(req, resp);
	}

	
}
