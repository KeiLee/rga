package com.rga.customer.dao;

import java.util.List;

import com.rga.customer.bean.Customer;
import com.rga.customer.bean.SystemUser;
 

public interface UserDAO {
	public List<Customer> getAllCustomers();
 
	public Customer getCustomerByEmail(String email);

	public Customer getCustomerById(long id);

	public Customer createCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer(long id);
	
	public SystemUser getSystemUserByEmail(String email);
}
