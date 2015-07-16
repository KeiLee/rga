package com.rga.customer.bean;

public class SystemUser extends User {
	
	private String level;
	private String title;
	
	public SystemUser(){
		
	}
	
	public SystemUser(long id, String name, String email, String password, String level, String title) {
		this.setUserType(User.USER_TYPE_SYSTEM_USER);
		this.setId(id); 
		this.setName(name); 
		this.setEmail(email); 
		this.setPassword(password);
		this.level = level;
		this.title = title;
	}
	

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
