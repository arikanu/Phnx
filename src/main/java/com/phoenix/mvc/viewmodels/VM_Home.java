package com.phoenix.mvc.viewmodels;

import com.phoenix.mvc.db.entities.User;

public class VM_Home {

	private boolean validLogin;
	private String formattedDate;
	private User user;
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isValidLogin() {
		return validLogin;
	}
	public void setValidLogin(boolean validLogin) {
		this.validLogin = validLogin;
	}
	public String getFormattedDate() {
		return formattedDate;
	}
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}

	
	
	
}
