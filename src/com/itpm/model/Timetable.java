package com.itpm.model;
/**
 * This is the Doctor model class
 */
public class Timetable {
	
	
	public String getTimetableId() {
		return TimetableId;
	}


	public void setTimetableId(String timetableId) {
		TimetableId = timetableId;
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

	public String getFirstSubject() {
		return firstSubject;
	}

	public void setFirstSubject(String firstSubject) {
		this.firstSubject = firstSubject;
	}

	public String getFirstLecturer() {
		return firstLecturer;
	}

	public void setFirstLecturer(String firstLecturer) {
		this.firstLecturer = firstLecturer;
	}


	public String getSecondSubject() {
		return secondSubject;
	}


	public void setSecondSubject(String secondSubject) {
		this.secondSubject = secondSubject;
	}

	public String getSecondLecturer() {
		return secondLecturer;
	}

	public void setSecondLecturer(String secondLecturer) {
		this.secondLecturer = secondLecturer;
	}


	public String getThirdSubject() {
		return thirdSubject;
	}


	public void setThirdSubject(String thirdSubject) {
		this.thirdSubject = thirdSubject;
	}

	public String getThirdLecturer() {
		return thirdLecturer;
	}

	public void setThirdLecturer(String thirdLecturer) {
		this.thirdLecturer = thirdLecturer;
	}
	public String getFourthSubject() {
		return fourthSubject;
	}

	public void setFourthSubject(String fourthSubject) {
		this.fourthSubject = fourthSubject;
	}

	public String getFourthLecturer() {
		return fourthLecturer;
	}

	public void setFourthLecturer(String fourthLecturer) {
		this.fourthLecturer = fourthLecturer;
	}
	private String TimetableId;
	private String name;
	private String year;
	private String firstSubject;
	private String firstLecturer;
	private String secondSubject;
	private String secondLecturer;
	private String thirdSubject;
	private String thirdLecturer;
	private String fourthSubject;
	private String fourthLecturer;


	

	
	public String toString() {
		return "Timetable ID ID = " + TimetableId + "\n" + "Name = " + name + "\n" + "Year = " + year + "\n"
				+ "First Subject = " + firstSubject + "\n" + "First Lecturer = " + firstLecturer + "\n" + "Second Subject = " + secondSubject +
				"\n" + "Second Lecturer = " + secondLecturer + "\n" + "Third Subject = " + thirdSubject + "\n" + "Third Lecturer = " + thirdLecturer + "\n" + "Fourth Subject = " + fourthSubject +
				"\n" + "Fourth Lecturer = " + fourthLecturer;
	}
}
