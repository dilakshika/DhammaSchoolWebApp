package com.itpm.model;


public class Student {


	private String InNo;
	private String Fname;
	private String IName;
	private String Birthday;
	private String Gender;
	private String Address;
	private String Guardian;
	private String Mobile;	
	private String ADate;
	private String Comment;
	private String position;
	
	
	public String getInNo() {
		return InNo;
	}


	public void setInNo(String inNo) {
		InNo = inNo;
	}


	public String getFname() {
		return Fname;
	}


	public void setFname(String fname) {
		Fname = fname;
	}


	public String getIName() {
		return IName;
	}


	public void setIName(String iName) {
		IName = iName;
	}


	public String getBirthday() {
		return Birthday;
	}


	public void setBirthday(String birthday) {
		Birthday = birthday;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getGuardian() {
		return Guardian;
	}


	public void setGuardian(String guardian) {
		Guardian = guardian;
	}


	public String getMobile() {
		return Mobile;
	}


	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	
	public String getADate() {
		return ADate;
	}


	public void setADate(String aDate) {
		ADate = aDate;
	}


	public String getComment() {
		return Comment;
	}


	public void setComment(String comment) {
		Comment = comment;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		
		return "Student ID = " + InNo + "\n" + "Student Name = " + Fname + "\n" + "IName = " + IName + "\n"
				+ "Birthday = " + Birthday + "\n" + "Gender = " + Gender + "\n" + "Address = "
				+ Address + "\n" + "Guardian = " + Guardian + "\n" + "Mobile = " + Mobile + "\n" + "ADate = " + ADate + "\n" + "Comment = " + Comment + "\n" + "position = " + position;
	}
}
