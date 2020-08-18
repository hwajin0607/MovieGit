package com.mvc.movie.dto;

import java.sql.Date;
public class MovieManagerDto {
	private int mIdx;
	private int conIdx;
	private String mName;
	private Date mOpen;
	private String mGenre;
	private String mUrl;
	private int mBhit;
	private Date mDate;
	private int mAge;
	private String mContent;
	private String conContent;
	
	
	public int getConIdx() {
		return conIdx;
	}
	public void setConIdx(int conIdx) {
		this.conIdx = conIdx;
	}
	public String getConContent() {
		return conContent;
	}
	public void setConContent(String conContent) {
		this.conContent = conContent;
	}
	public int getmIdx() {
		return mIdx;
	}
	public void setmIdx(int mIdx) {
		this.mIdx = mIdx;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public Date getmOpen() {
		return mOpen;
	}
	public void setmOpen(Date mOpen) {
		this.mOpen = mOpen;
	}
	public String getmGenre() {
		return mGenre;
	}
	public void setmGenre(String mGenre) {
		this.mGenre = mGenre;
	}
	public String getmUrl() {
		return mUrl;
	}
	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}
	public int getmBhit() {
		return mBhit;
	}
	public void setmBhit(int mBhit) {
		this.mBhit = mBhit;
	}
	public Date getmDate() {
		return mDate;
	}
	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}
	public int getmAge() {
		return mAge;
	}
	public void setmAge(int mAge) {
		this.mAge = mAge;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	@Override
	public String toString() {
		return "MovieManagerDto [mIdx=" + mIdx + ", conIdx=" + conIdx + ", mName=" + mName + ", mOpen=" + mOpen
				+ ", mGenre=" + mGenre + ", mUrl=" + mUrl + ", mBhit=" + mBhit + ", mDate=" + mDate + ", mAge=" + mAge
				+ ", mContent=" + mContent + ", conContent=" + conContent + "]";
	}
}
