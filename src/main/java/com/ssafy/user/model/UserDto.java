package com.ssafy.user.model;

public class UserDto {
	private String id;
	
	private String password;
	
	private String name;
	
	private String email;
	
	private boolean isAdmin;
	
	public UserDto() {
		super();
	}
	public UserDto(String id, String password, String name, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	public UserDto(String id, String password, String name, String email, boolean isAdmin) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.isAdmin = isAdmin;
	}

	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public boolean getIsAdmin() {
		return isAdmin;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", isAdmin="
				+ isAdmin + "]";
	}
}
