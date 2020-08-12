package com.mvc.movie.service;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mvc.movie.dao.MovieDao;
import com.mvc.movie.dto.MovieDto;


public class MovieService {
		HttpServletRequest req = null;
	    HttpServletResponse resp = null;
	    RequestDispatcher dis = null;


	   public MovieService(HttpServletRequest req, HttpServletResponse resp) {
	      this.req =req;
	      this.resp =resp;
	   }
	   
	 //전체영화목록	
	public void movieList() throws ServletException, IOException {
		ArrayList<MovieDto> list = null;
		MovieDao dao = new MovieDao();
		
		String pageParam = req.getParameter("page");
		int page = 1;
		if(pageParam != null) {
			page = Integer.parseInt(pageParam);
			
			if(page == 0) {
				page = 1;
			}
		}
		
		try {
			list = dao.movieList(page);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			req.setAttribute("currPage", page);
			req.setAttribute("movieList", list);
			RequestDispatcher dis = req.getRequestDispatcher("movieList.jsp");
			dis.forward(req, resp);
			dao.resClose();
		}
		
	}
	
	//장르별 영화 목록
	public void movieListG(String mGenre,int page) throws ServletException, IOException {
		System.out.println(mGenre);
		ArrayList<MovieDto> list = null;
		MovieDao dao = new MovieDao();
		
		String pageParam = req.getParameter("page");
		page = 1;
		if(pageParam != null) {
			page = Integer.parseInt(pageParam);
			
			if(page == 0) {
				page = 1;
			}
		}
		
		try {
			list = dao.movieListG(mGenre,page);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			req.setAttribute("currPage", page);
			req.setAttribute("movieList", list);
			RequestDispatcher dis = req.getRequestDispatcher("movieList.jsp");
			dis.forward(req, resp);
			dao.resClose();
		}
	}

	
	
	//영화 목록 정렬
	public void movieListS(String sqlb, String genre, int page) throws ServletException, IOException {
		System.out.println(sqlb);
		ArrayList<MovieDto> list = null;
		MovieDao dao = new MovieDao();
		
		String pageParam = req.getParameter("page");
		page = 1;
		if(pageParam != null) {
			page = Integer.parseInt(pageParam);
			
			if(page == 0) {
				page = 1;
			}
		}
		try {
			list = dao.movieListS(sqlb,genre,page);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			req.setAttribute("movieList", list);
			req.setAttribute("currPage", page);
			RequestDispatcher dis = req.getRequestDispatcher("movieList.jsp");
			dis.forward(req, resp);
			dao.resClose();
		}
	}

	
	//찜한 영화 목록
	public void zzim() throws ServletException, IOException {
		MovieDao dao = new MovieDao();
		System.out.println("값 확인");
		String idx = String.valueOf(req.getSession().getAttribute("uIdx"));
		System.out.println("유저 idx : " + idx );
		req.setAttribute("list", dao.list(idx));
		dis = req.getRequestDispatcher("zzim.jsp");
		dis.forward(req, resp);
	}

	//검색한 영화 불러오기
	public void searchResult() throws ServletException, IOException {
		MovieDao dao = new MovieDao();
		String mName = req.getParameter("searchTxt");
		System.out.println(mName);
		req.setAttribute("srlist", dao.srlist(mName));
		dis = req.getRequestDispatcher("searchResult.jsp");
		dis.forward(req, resp);
	}

	//보고 싶은 영화 검색하기
	public void search() throws ServletException, IOException {
		MovieDao dao = new MovieDao();
		//req.getParameter("mGenre");
		String mName = "testDate2";
		String mGenre = "호러";
		String mdDirector = "더미데이터";
		String maActor = "더미데이터 배우";
		System.out.println("파라메터 점검 : " +mName+ mGenre+ mdDirector+ maActor);
		req.setAttribute("slist", dao.slist(mName, mGenre, mdDirector, maActor));
		dis = req.getRequestDispatcher("searchResult.jsp");
		dis.forward(req, resp);
		
		
	}

	
	   //랜덤으로 영화 한개 불러오기
	   public void random() throws IOException, ServletException {
	      MovieDao dao = new MovieDao();
	      MovieDto list = dao.random();
	      System.out.print(list);
	      //랜덤처리가 끝난뒤 페이지를 이동시켜주는 것이 아니라 데이터를 내려줘야함
	      // 데이터 타입의 경우 처리하기 편한 방식으로 변경해서 내려주면 됨
	      resp.setContentType("text/html;charset=UTF-8");
	      
	      HashMap<String, Object> map = new HashMap<String, Object>();
	       map.put("movie",list);
	      Gson json = new Gson();
	      String obj = json.toJson(map);
	      resp.getWriter().print(obj);
	      dao.resClose();
	   }
	
	//마이페이지 찜목록
	public void myPageZ() throws ServletException, IOException {
		ArrayList<MovieDto> list = null;
		String uIdx = "61";
		MovieDao dao = new MovieDao();
		try {
			list = dao.myPageZ(uIdx);
			dao.myPageM(list);
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			req.setAttribute("myPageZ", list);
			RequestDispatcher dis = req.getRequestDispatcher("myPage.jsp");
			dis.forward(req, resp);
			dao.resClose();
		}
	}

	public void selectGrade() throws SQLException, ServletException, IOException {	
		MovieDao dao = new MovieDao();
		ArrayList<MovieDto>list =dao.selectGrade();
		dao.grademName(list);
		req.setAttribute("list", list);
		RequestDispatcher dis = req.getRequestDispatcher("select.jsp");
		dis.forward(req, resp);
		dao.resClose();
	}

	public void selectBhit() throws SQLException, ServletException, IOException {
		MovieDao dao = new MovieDao();
		ArrayList<MovieDto>list = dao.selectBhit();
		req.setAttribute("list", list);
		RequestDispatcher dis = req.getRequestDispatcher("select.jsp");
		dis.forward(req, resp);
		dao.resClose();

	}

	//영화 상세페이지에 내용 띄우기
	public void movieDetail(String mIdx) throws ServletException, IOException {
		System.out.println("서비스에게 일을 시킨다.");
		MovieDao dao = new MovieDao();
		ArrayList<MovieDto>list = dao.movieDetail(mIdx);
		System.out.println(list);
		req.setAttribute("list", list);
		RequestDispatcher dis = req.getRequestDispatcher("movie_detail.jsp");
		dis.forward(req, resp);
		dao.resClose();
	}
	
	//찜목록에 보내기
	public void zzimadd(String midx) {
		System.out.println("찜목록에보내기 서비스");
		MovieDao dao = new MovieDao();
		String uIdx = (String) req.getSession().getAttribute("uIdx");
	}

	// 평점 넣기
	public void writeRating(String mIdx) {
		System.out.println("서비스에게 일 시킨다.");
		String pjpoint = req.getParameter("pjpoint");
		mIdx = req.getParameter("mIdx");
		System.out.println(pjpoint+"/"+mIdx);
		
	}
				
	public void del() throws ServletException, IOException {
		System.out.println("찜 목록 삭제 요청");
		String zidx = req.getParameter("zidx"); //해당 유저의 하나의 찜 목록 리스트를 삭제
		System.out.println("zidx 출력 확인 : " + zidx);//zidx 출력확인
		MovieDao dao = new MovieDao();
		dao.del(zidx);
		String page = "/zzim";
		RequestDispatcher dis =req.getRequestDispatcher(page);
		dis.forward(req, resp);
	}

	public void Alldel(String uidx) throws ServletException, IOException {
		System.out.println("찜 목록 전체 삭제 요청");
		System.out.println("uidx 출력 : " + uidx);
		MovieDao dao = new MovieDao();
		dao.Alldel(uidx);
		String page = "/zzim";
		RequestDispatcher dis = req.getRequestDispatcher(page);
		dis.forward(req, resp);
		
	}

}
