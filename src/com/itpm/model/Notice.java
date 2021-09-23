package com.itpm.model;
/**
 * This is the Doctor model class
 */
public class Notice {
	
	private String NoticeId;
	private String nname;
	private String ndate;
	private String nowner;
	private String notice;


	public String getNoticeId() {
		return NoticeId;
	}


	public void setNoticeId(String noticeId) {
		NoticeId = noticeId;
	}

	public String getNname() {
		return nname;
	}


	public void setNname(String nname) {
		this.nname = nname;
	}


	public String getNdate() {
		return ndate;
	}


	public void setNdate(String ndate) {
		this.ndate = ndate;
	}

	public String getNowner() {
		return nowner;
	}


	public void setNowner(String nowner) {
		this.nowner = nowner;
	}
	public String getNotice() {
		return notice;
	}


	public void setNotice(String notice) {
		this.notice = notice;
	}


	public String toString() {
		return "Notice ID = " + NoticeId + "\n" + "Notice Name = " + nname + "\n" + "Notice date = " + ndate + "\n"
				+ "Notice Owner = " + nowner+ "\n"  + "Notice = " + notice;
	}
}
