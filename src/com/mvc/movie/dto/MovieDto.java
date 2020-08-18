package com.mvc.movie.dto;

import java.sql.Date;




	


import com.google.gson.JsonObject;

public class MovieDto {

	private int conIdx;

	private String conContent;
	private Date conDate;
	private Date conRedate;
	private String uIden;
	private int mIdx;
	private String mName;
	private Date mOpen;
	private String mGenre;
	private String mUrl;
	private int mBhit;
	private Date mDate;
	private int mAge;
	private String mdDirector;
	private String maActor;
	private String mContent;
	private String mfUrl;
	private String mravg;
	private int mfIdx;
	private String mfOri;
	private String mfNew;
	private int zidx;
	private int uidx;
	private Date zdate;
	private String maactor;
	private double mrRating;
	private int conidx;

	private String uiden;
	
	
	
	
	public int getConIdx() {
		return conIdx;
	}

	public Date getConDate() {
		return conDate;
	}
	public Date getConRedate() {
		return conRedate;
	}
	public String getuIden() {
		return uIden;
	}
	public void setuIden(String uIden) {
		this.uIden = uIden;
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
	public String getMdDirector() {
		return mdDirector;
	}
	public void setMdDirector(String mdDirector) {
		this.mdDirector = mdDirector;
	}
	public String getMaActor() {
		return maActor;
	}
	public void setMaActor(String maActor) {
		this.maActor = maActor;
	}
	public String getmContent() {
		return mContent;
	}
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}
	public String getMfUrl() {
		return mfUrl;
	}
	public void setMfUrl(String mfUrl) {
		this.mfUrl = mfUrl;
	}
	public String getMravg() {
		return mravg;
	}
	public void setMravg(String mravg) {
		this.mravg = mravg;
	}
	public int getMfIdx() {
		return mfIdx;
	}
	public void setMfIdx(int mfIdx) {
		this.mfIdx = mfIdx;
	}
	public String getMfOri() {
		return mfOri;
	}
	public void setMfOri(String mfOri) {
		this.mfOri = mfOri;
	}
	public String getMfNew() {
		return mfNew;
	}
	public void setMfNew(String mfNew) {
		this.mfNew = mfNew;
	}
	public int getZidx() {
		return zidx;
	}
	public void setZidx(int zidx) {
		this.zidx = zidx;
	}
	public int getUidx() {
		return uidx;
	}
	public void setUidx(int uidx) {
		this.uidx = uidx;
	}
	public Date getZdate() {
		return zdate;
	}
	public void setZdate(Date zdate) {
		this.zdate = zdate;
	}
	public String getMaactor() {
		return maactor;
	}
	public void setMaactor(String maactor) {
		this.maactor = maactor;
	}
	public double getMrRating() {
		return mrRating;
	}
	public void setMrRating(double mrRating) {
		this.mrRating = mrRating;
	}
	public void setConIdx(int int1) {
		// TODO Auto-generated method stub
		
	}
	public void setConContent(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setConDate(Date date) {
		// TODO Auto-generated method stub
		
	}
	public void setConRedate(Date date) {
		// TODO Auto-generated method stub
		
	}

	public int getConidx() {
		return conidx;
	}
	public void setConidx(int conidx) {
		this.conidx = conidx;
	}
	public String getConContent() {
		return conContent;
	}

	public String getUiden() {
		return uiden;
	}
	public void setUiden(String uiden) {
		this.uiden = uiden;
	}

	@Override
	public String toString() {
		return "{mIdx:" + mIdx + ", mName:" + mName + ", mOpen:" + mOpen + ", mGenre:" + mGenre + ", mUrl:"
				+ mUrl + ", mBhit:" + mBhit + ", mDate:" + mDate + ", mAge:" + mAge + ", mdDirector:" + mdDirector
				+ ", maActor:" + maActor + ", mContent:" + mContent + ", mfUrl:" + mfUrl + ", mravg:" + mravg
				+ ", mfIdx:" + mfIdx + ", mfOri:" + mfOri + ", mfNew:" + mfNew + ", zidx:" + zidx + ", uidx:" + uidx
				+ ", zdate:" + zdate + ", maactor:" + maactor + ", mrRating:" + mrRating + "}";
	}

		//	public String toJSON () {
		//		Gson obj = new JsonObject();
		//		obj.add("mIdx", this.mIdx);
		//		return "";
		//	}
			//

}
