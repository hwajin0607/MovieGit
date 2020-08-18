package com.mvc.movieupload.all;

import java.io.File;
import java.io.IOException;
import com.oreilly.servlet.MultipartRequest;

import javax.servlet.http.HttpServletRequest;

public class UploadService {
	
	HttpServletRequest req = null;
	
	public UploadService(HttpServletRequest req) {
		this.req = req;
	}

	public DTO regist() {

	      //저장경로
	      String savePath = "C:/upload/"; 
	      //용량제한
	      int maxSize = 10*1024*1024;
	      
	      String oriFileName = "";
	      String newFileName = "";
	      DTO dto = new DTO();

	      try {
	         MultipartRequest muti = new MultipartRequest(req,savePath,maxSize,"UTF-8"); //파일저장
	         
	         //cos에서는 일반적인 내용도 그냥 추출 할 수 있음 -> common은 안됨
	         //어짜피 반환할 DTO이기 때문에 한번에 담아서 반환 시키려고 함
	         int age = Integer.parseInt(muti.getParameter("age"));
	         //System.out.println(muti.getParameter("movieName"));
	         dto.setmName(muti.getParameter("movieName"));
	         dto.setmOpen(muti.getParameter("openDate"));
	         dto.setmGenre(muti.getParameter("genre"));
	         dto.setmUrl(muti.getParameter("url"));
	         dto.setmAge(age);
	         dto.setmContent(muti.getParameter("story"));
	         //System.out.println(age);
	         //System.out.println(muti.getParameter("story"));
	         System.out.println(muti.getParameter("openDate"));
	         //파일명 변경
	         oriFileName = muti.getFilesystemName("photo"); //원본파일명 추출
	         if(oriFileName != null) { //업로드 한 파일이 있다면...
	            String ext = oriFileName.substring(oriFileName.lastIndexOf("."));
	            newFileName = System.currentTimeMillis()+ext; //새파일명 생성
	            
	            File oldFile = new File(savePath+oriFileName);
	            File newFile = new File(savePath+newFileName);
	            oldFile.renameTo(newFile); //파일명 변경
	            dto.setMfOri(oriFileName);
	            dto.setMfNew(newFileName);
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      return dto;
	   }
}
