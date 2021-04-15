package com.example.security.model;

public class User {

	private String firstName;
	private String lastName;
	private String fullName;
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		this.fullName = firstName + " " + lastName;
		return this.fullName;
	}
	
}
