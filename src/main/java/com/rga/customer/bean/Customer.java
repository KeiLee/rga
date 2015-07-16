package com.rga.customer.bean;

public class Customer extends User {

	private String phone;
	private String address;
	
	public Customer() {
		
	}
	
	public Customer(long id, String name, String email, String password, String phone, String address) {
		this.setUserType(User.USER_TYPE_CUSTOMER);
		this.setId(id); 
		this.setName(name); 
		this.setEmail(email); 
		this.setPassword(password);
		this.phone = phone;
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
