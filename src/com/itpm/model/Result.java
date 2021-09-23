package com.itpm.model;

public class Result {
	

	private String ResultId;
	private String sid;
	private String name;
	private String year;
	private String grade;
	private String exam;
	private String result;
	private String password;


	public String getResultId() {
		return ResultId;
	}



	public void setResultId(String resultId) {
		ResultId = resultId;
	}



	public String getSid() {
		return sid;
	}



	public void setSid(String sid) {
		this.sid = sid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public String getExam() {
		return exam;
	}



	public void setExam(String exam) {
		this.exam = exam;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	
	
	
	public String toString() {
		return "Result ID = " + ResultId + "\n" + "Student ID = " + sid + "\n" + "Student Name = " + name + "\n"
				+ "Year = " + year + "\n" + "Grade = " + grade + "\n" + "Exam = " + exam +
				"\n" + "Result = " + result + "\n" + "Password = " + password;
	}
}
