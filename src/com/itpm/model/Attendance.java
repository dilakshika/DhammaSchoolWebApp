package com.itpm.model;
/**
 * This is the Doctor model class
 */
public class Attendance {
	


	private String AttendanceId;
	private String stdId;
	private String stdGrade;
	private String stdArrivesTime;
	private String stdArrivesDate;





	public String getAttendanceId() {
		return AttendanceId;
	}





	public void setAttendanceId(String attendanceId) {
		AttendanceId = attendanceId;
	}





	public String getStdId() {
		return stdId;
	}





	public void setStdId(String stdId) {
		this.stdId = stdId;
	}





	public String getStdGrade() {
		return stdGrade;
	}





	public void setStdGrade(String stdGrade) {
		this.stdGrade = stdGrade;
	}





	public String getStdArrivesTime() {
		return stdArrivesTime;
	}





	public void setStdArrivesTime(String stdArrivesTime) {
		this.stdArrivesTime = stdArrivesTime;
	}





	public String getStdArrivesDate() {
		return stdArrivesDate;
	}





	public void setStdArrivesDate(String stdArrivesDate) {
		this.stdArrivesDate = stdArrivesDate;
	}





	public String toString() {
		return "Student Attendance ID = " + AttendanceId + "\n" + "Student ID = " + stdId + "\n" + "Student Grade = " + stdGrade + "\n"
				+ "Student Arrives Time = " + stdArrivesTime + "\n" + "Student Arrives date = " + stdArrivesDate;
	}
}
