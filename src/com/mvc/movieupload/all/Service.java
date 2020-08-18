package com.mvc.movieupload.all;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Service {

	HttpServletRequest req = null;
	HttpServletResponse resp = null;
	RequestDispatcher dis = null;

	public Service(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}

	public void movieTest() throws ServletException, IOException {
		UploadService svc = new UploadService(req);
		DAO dao = new DAO();
		DTO dto = svc.regist();
		System.out.println("서비스에서 일 하는 중");
		long pk = dao.movieTest(dto);
		String page ="gustmdtest.jsp";
		String msg = "업로드 실패";
		if(pk>0) {
			page = "manager.jsp";
			msg = "업로드 성공";
		}
		req.setAttribute("msg", msg);
		dis = req.getRequestDispatcher(page);
		dis.forward(req, resp);
	}

}
