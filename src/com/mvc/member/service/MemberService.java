package com.mvc.member.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mvc.member.dao.MemberDao;
import com.mvc.member.dto.MemberDto;
import com.mvc.movie.dto.MovieDto;

import oracle.net.ns.SessionAtts;

public class MemberService {
	HttpServletRequest req = null;
	HttpServletResponse resp = null;

	public MemberService(HttpServletRequest req, HttpServletResponse resp) {
		this.req =req;
		this.resp =resp;
	}
	
	public int login(String id, String pw) throws Exception {
		MemberDao dao = new MemberDao();
		int useridx = dao.login(id,pw);
		 if(useridx != 0) {
			 System.out.println(id+" 의 로그인 결과 : "+useridx); 
		 }
		 dao.resClose();
		 return useridx;

	}
	
	
	public void join() throws IOException {
		boolean success = false;
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String day = req.getParameter("day");
		String month = req.getParameter("month");
		String year = req.getParameter("year");
		String birth = year+"-"+month+"-"+day;
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
	public void like() throws SQLException, ServletException, IOException {
		String uIdx =  Integer.toString((int) req.getSession().getAttribute("uIdx"));
		System.out.println("고유번호 : "+uIdx);
		ArrayList<MovieDto> list = null;
		MemberDao dao = new MemberDao();

		try {
			list = dao.like(uIdx);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dao.resClose();
			req.setAttribute("list", list);
			RequestDispatcher dis = req.getRequestDispatcher("main_top.jsp");
			dis.forward(req, resp);
		}
		
		
	}

	public void info() {
		String uidx = String.valueOf(req.getSession().getAttribute("uIdx"));
		System.out.println(uidx);
		//String uidx = "61";
		MemberDto info = null;
		ArrayList<String> infoG = null;
		MemberDao dao = new MemberDao();
		try {
			info = dao.info(uidx);
			infoG =  dao.genre(uidx);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.resClose();
			req.setAttribute("info", info);
			req.setAttribute("infoG", infoG);
			req.getSession().setAttribute("infoG", infoG);
			RequestDispatcher dis = req.getRequestDispatcher("MemberInfo.jsp");
			try {
				dis.forward(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}

	public void changing() {
		String uidx = String.valueOf(req.getSession().getAttribute("uIdx"));
		//String uidx = "61";
		MemberDto info = null;
		ArrayList<String> infoG = null;
		MemberDao dao = new MemberDao();
		try {
			String str = String.valueOf(req.getSession().getAttribute("infoG"));
			System.out.println(str);
			info = dao.info(uidx);
			infoG =  dao.genre(uidx);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.resClose();
			req.setAttribute("info", info);
			req.setAttribute("infoG", infoG);
			RequestDispatcher dis = req.getRequestDispatcher("MemberChanging.jsp");
			try {
				dis.forward(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void infoc() throws IOException {
		// String uidx = (String) req.getSession().getAttribute("idx"); 나중에 세션값 저장되면 사용할것
		boolean success = false;
		String uidx = "61";
		String pw = req.getParameter("pw");
		String birth = req.getParameter("birth");
		String email = req.getParameter("email");
		String[] ugenre = req.getParameterValues("ugenre[]");
		System.out.println(pw+birth+email);
		MemberDao dao = new MemberDao();
		int sc = 0;
		try {
			sc = dao.infoc(uidx,pw,birth,email);
			
			if(ugenre.length > 0) {
				dao.genrec(uidx,ugenre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dao.resClose();
			HashMap<String, Object> map = new HashMap<String, Object>();
			if(sc>0) {
				success = true;
			}
			map.put("overlay", success);
			Gson gson = new Gson();
			String obj =  gson.toJson(map);
			System.out.println("result : " + obj);
			resp.getWriter().println(obj);
		}
			
		
		
	}
	



}
