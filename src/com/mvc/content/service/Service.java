package com.mvc.content.service;

import com.mvc.content.dao.Dao;

public class Service {
	Dao dao = new Dao();
	
	//댓글 목록
	public Object list(int page, int midx) {
		
		
		
		return dao.getComment(page, midx);
	}

	//해당영화에 사용자 기존 댓글이 존재하는지 (사용자당 1번만 댓글을 작성할수있다.)
	/*public int istrue(int member, int movie) {
		
		return dao.isExistContent(member, movie);
	}*/
	
	//댓글 등록
	public int newContent(int member, String content, int movie) {
		
		
		return dao.insertContent(member, content, movie);
		
	}
	//댓글 수정
	public int reContent(int member, String content, int conIdx) {
		
		
		return dao.updateContent(member, content, conIdx);
		
	}
	
	//신고 하기
	/*public int count(int cId, int uId) {
		
		return 0;
		
	}*/
	
}
