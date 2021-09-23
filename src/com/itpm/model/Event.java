package com.itpm.model;
/**
 * This is the Doctor model class
 */
public class Event {
	
	private String  id;
	private String name;
	private String place;
	private String date;
	private String stime;
	private String duration;
	private String  incharg_id;
	private String  participants;
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}

	public String getStime() {
		return stime;
	}


	public void setStime(String stime) {
		this.stime = stime;
	}





	public String getDuration() {
		return duration;
	}





	public void setDuration(String duration) {
		this.duration = duration;
	}





	public String getIncharg_id() {
		return incharg_id;
	}





	public void setIncharg_id(String incharg_id) {
		this.incharg_id = incharg_id;
	}





	public String getParticipants() {
		return participants;
	}





	public void setParticipants(String participants) {
		this.participants = participants;
	}


	
	public String toString() {
		return "Event ID = " + id + "\n" + "Event Name = " + name + "\n" + "Place = " + place + "\n"
				+ "Date = " + date + "\n" + "Stime = " + stime + "\n" + "Duration = " + duration +
				"\n" + "Incharge ID = " + incharg_id + "\n" + "Participants = " + participants;
	}
}
