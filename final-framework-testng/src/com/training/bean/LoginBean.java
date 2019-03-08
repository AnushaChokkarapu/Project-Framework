package com.training.bean;

public class LoginBean {
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private String confirmPassword;
	private String phone;

	public LoginBean() {
	}

	public LoginBean(String firstName, String lastName, String email, String userName, String password, String confirmPassword, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.phone = phone;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
	    this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "LoginBean [firstName=" + firstName + ", lastName" +lastName + ", email" + email + ", userName" + userName + ", password=" + password + ", confirmPassword" + confirmPassword + ", phone" + phone + "]";
	}

}
