package com.infosys.infyshop.signup.dto;

import com.infosys.infyshop.signup.entity.SignUp;


public class SignUpDTO {
	String email;
	String name;
	String password;
	String accountType;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	@Override
	public String toString() {
		return "SignUpDTO [email=" + email + ", name=" + name + ", password=" + password + ", accountType="
				+ accountType + "]";
	}
	
	// Converts Entity into DTO
	public static SignUpDTO valueOf(SignUp signUp) {
		SignUpDTO signUpDTO = new SignUpDTO();
		signUpDTO.setEmail(signUp.getEmail());
		signUpDTO.setName(signUp.getName());
		signUpDTO.setPassword(signUp.getPassword());
		signUpDTO.setAccountType(signUp.getAccountType());
		return signUpDTO;
	}
	
	public SignUp createEntity() {
		SignUp signUp = new SignUp();
		signUp.setEmail(this.getEmail());
		signUp.setName(this.getName());
		signUp.setPassword(this.getPassword());
		signUp.setAccountType(this.getAccountType());
		return signUp;
	}
	
	
}
