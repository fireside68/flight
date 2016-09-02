package com.cooksys.model;

public class UserResponseModel {
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	public UserResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserResponseModel(String username, String password, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
