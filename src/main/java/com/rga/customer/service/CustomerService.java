package com.rga.customer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rga.customer.bean.Customer;
import com.rga.customer.dao.UserDAO;


@Service
public class CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	 
	@Autowired
	UserDAO userDAO;
	
	@Transactional
	public  Customer createCustomer( Customer customer) {

		customer = userDAO.createCustomer(customer);
		return customer;
	}

	@Transactional
	public List< Customer> getCustomerList() {
		return userDAO.getAllCustomers();
	}

	@Transactional
	public  Customer getCustomerByEmail(String email) {
 		return userDAO.getCustomerByEmail(email);
	}
	
	@Transactional
	public Customer getCustomerById(long id) {
 		return userDAO.getCustomerById(id);
	}
	
	 

	@Transactional
	public Customer update(Customer customer) {
 		return userDAO.updateCustomer(customer);
	}

	@Transactional
	public Customer delete(long id) {
		return userDAO.deleteCustomer(id);
	}
	
 
	private void logDebug(String message){
		logger.debug(message);
	}
	private void logError(String message){
		logger.error(message);
	}

}
