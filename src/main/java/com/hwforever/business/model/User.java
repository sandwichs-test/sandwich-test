package com.hwforever.business.model;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Integer status;
	private String loginstr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLoginstr() {
		return loginstr;
	}

	public void setLoginstr(String loginstr) {
		this.loginstr = loginstr;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", status=" + status +
				", loginstr='" + loginstr + '\'' +
				'}';
	}
}
