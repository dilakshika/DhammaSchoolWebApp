package com.itpm.model;
/**
 * This is the Doctor model class
 */
public class User {
	



	private String UserId;
	private String FName;
	private String LName;
	private String Email;
	private String ContactNumber;
	private String UserType;
	private String Username;
	private String Password;

	
	public String getUserId() {
		return UserId;
	}




	public void setUserId(String userId) {
		UserId = userId;
	}




	public String getFName() {
		return FName;
	}




	public void setFName(String fName) {
		FName = fName;
	}




	public String getLName() {
		return LName;
	}




	public void setLName(String lName) {
		LName = lName;
	}




	public String getEmail() {
		return Email;
	}




	public void setEmail(String email) {
		Email = email;
	}




	public String getContactNumber() {
		return ContactNumber;
	}




	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}




	public String getUserType() {
		return UserType;
	}




	public void setUserType(String userType) {
		UserType = userType;
	}




	public String getUsername() {
		return Username;
	}




	public void setUsername(String username) {
		Username = username;
	}




	public String getPassword() {
		return Password;
	}




	public void setPassword(String password) {
		Password = password;
	}


	
	

	
	public String toString() {
		return "User ID = " + UserId + "\n" + "First Name = " + FName + "\n" + "Last Name = " + LName + "\n"
				+ "Email = " + Email + "\n" + "Contact Number = " + ContactNumber + "\n" + "User Type = " + UserType +
				"\n" + "Username = " + Username + "\n" + "Password = " + Password;
	}
}
