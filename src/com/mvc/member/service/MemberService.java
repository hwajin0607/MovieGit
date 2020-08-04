package com.mvc.member.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mvc.member.dao.MemberDao;

public class MemberService {
	HttpServletRequest req = null;
	HttpServletResponse resp = null;

	public MemberService(HttpServletRequest req, HttpServletResponse resp) {
		this.req =req;
		this.resp =resp;
	}
	
	public void join() throws IOException {
		boolean success = false;
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String[] ugenre = req.getParameterValues("ugenre[]");
		System.out.println(id+"/"+pw+"/"+name+"/"+birth+"/"+gender+"/"+email+"/"+ugenre.length);
		String reid = req.getParameter("id");
		String repw = req.getParameter("pw");
		System.out.println(reid+"/"+repw);
		MemberDao dao = new MemberDao();
		try {
			if(dao.join(id,pw,name,birth,gender,email)) {
				int useridx = dao.uidx(reid,repw);
				if(dao.genrejoin(ugenre,useridx)==ugenre.length) {
					success = true;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dao.resClose();
			HashMap<String, Object> map = new HashMap<String, Object>();
			System.out.println("success");
			map.put("join", success);
			Gson gson = new Gson();
			String obj =  gson.toJson(map);
			System.out.println("result : " + obj);
			resp.getWriter().println(obj);
		}
		
		
	}

	public void overlay() throws IOException {
		String id = req.getParameter("id");
		boolean success = false;
		System.out.println("3차 확인 id : " + id);
		MemberDao dao = new MemberDao();
		try {
			success = dao.overlay(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dao.resClose();
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("overlay", success);
			Gson gson = new Gson();
			String obj =  gson.toJson(map);
			System.out.println("result : " + obj);
			resp.getWriter().println(obj);
		}
		
	}


}
