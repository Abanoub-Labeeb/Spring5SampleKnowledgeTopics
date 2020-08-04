package org.spring5samples.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class User {

	private int userID;
	@Size(min = 3 , max = 10)
	private String name;
	@Email
	private String email;
	
	public User() {
		
	}

	public User(int userID, String name, String email) {
		this.userID = userID;
		this.name = name;
		this.email = email;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", email=" + email + "]";
	}
	
}
