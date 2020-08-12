package com.mvc.member.dto;

import java.sql.Date;

public class MemberDto {


	private String uiden;
	private String uname;
	private Date uBirth;
	private String ugender;
	private String uemail;
	public String getUiden() {
		return uiden;
	}
	public void setUiden(String uiden) {
		this.uiden = uiden;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getuBirth() {
		return uBirth;
	}
	public void setuBirth(Date uBirth) {
		this.uBirth = uBirth;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	
	
	

	
	
}
