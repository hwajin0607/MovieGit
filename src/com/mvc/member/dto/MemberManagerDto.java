package com.mvc.member.dto;

import java.sql.Date;

public class MemberManagerDto {


	private int uIdx;
	private String uName;
	private Date uBirth;
	private String uGender;
	private String uIden;
	private String uPw;
	private String uEmail;
	private Date uDate;
	public int getuIdx() {
		return uIdx;
	}
	public void setuIdx(int uIdx) {
		this.uIdx = uIdx;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public Date getuBirth() {
		return uBirth;
	}
	public void setuBirth(Date uBirth) {
		this.uBirth = uBirth;
	}
	public String getuGender() {
		return uGender;
	}
	public void setuGender(String uGender) {
		this.uGender = uGender;
	}
	public String getuIden() {
		return uIden;
	}
	public void setuIden(String uIden) {
		this.uIden = uIden;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public Date getuDate() {
		return uDate;
	}
	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}
	
	
	
	
}
