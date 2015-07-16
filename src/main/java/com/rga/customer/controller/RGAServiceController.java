package com.rga.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rga.customer.bean.Customer;
import com.rga.customer.service.CustomerService;

@Controller
@RequestMapping("/service/rest/")
public class RGAServiceController {
	// Handle all JSON request and response
	
	
	private static final Logger logger = LoggerFactory.getLogger(RGAServiceController.class);
	
	@Autowired
	private CustomerService customerService;
	
 	@RequestMapping(value = "all", method = RequestMethod.GET )
	@ResponseBody
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = customerService.getCustomerList();
		
		return allCustomers;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST, headers="Accept=application/json" )
	@ResponseBody
	public Customer createCustomer(@RequestBody Customer customer) {
 		logDebug("begin createCustomer(). customer="+customer.getEmail());
		 
 		customerService.createCustomer(customer);
		
		return customer;
	}
	
	
	  

	private void logDebug(String message){
		logger.debug(message);
	}

}
