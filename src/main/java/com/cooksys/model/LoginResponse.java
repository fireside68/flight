package com.cooksys.model;

public class LoginResponse {
	
	private String username;
	private Boolean loggedIn;
	private Boolean isAdmin;
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginResponse(String username, Boolean loggedIn, Boolean isAdmin) {
		this.username = username;
		this.loggedIn = loggedIn;
		this.isAdmin = isAdmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
