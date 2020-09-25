package com.infosys.infyshop.signup.dto;

public class LoginDTO {
	
	String email;
	String password;
	String guestId;
	
	public LoginDTO() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGuestId() {
		return guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + ", guestId=" + guestId + "]";
	}
}
