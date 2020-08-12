package com.mvc.content.dto;

import java.sql.Date;

public class Dto {


	private int conIdx;
	private int mIdx;
	private String conContent;
	private Date conDate;
	private Date conRedate;
	private String uIden;
	
	
	
	public String getuIden() {
		return uIden;
	}
	public void setuIden(String uIden) {
		this.uIden = uIden;
	}
	public int getConIdx() {
		return conIdx;
	}
	public void setConIdx(int conIdx) {
		this.conIdx = conIdx;
	}
	public int getmIdx() {
		return mIdx;
	}
	public void setmIdx(int mIdx) {
		this.mIdx = mIdx;
	}
	public String getConContent() {
		return conContent;
	}
	public void setConContent(String conContent) {
		this.conContent = conContent;
	}
	public Date getConDate() {
		return conDate;
	}
	public void setConDate(Date conDate) {
		this.conDate = conDate;
	}
	public Date getConRedate() {
		return conRedate;
	}
	public void setConRedate(Date conRedate) {
		this.conRedate = conRedate;
	}
	
	
	
}
