package com.rga.customer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rga.customer.bean.Customer;
import com.rga.customer.service.CustomerService;

 
@Controller
public class CustomerController{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	private static final String CUSTOMER_PARAM_ID = "id";
	private static final String CUSTOMER_PARAM_EMAIL = "email";
	private static final String CUSTOMER_PARAM_NAME = "customerName";
	private static final String CUSTOMER_PARAM_PHONE = "phone";
	private static final String CUSTOMER_PARAM_ADDRESS = "address";
	
	@Autowired
	private CustomerService customerService;
	 
	@RequestMapping("/customerList")
	public ModelAndView getAllCustomer(HttpServletRequest req, HttpServletResponse res) {
		logDebug("getAllCustomer");
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		List< Customer> list = customerService.getCustomerList();
		if(list != null){
			result.put("customer", list);
		}
		 
		return new ModelAndView("customerInfo", "result", result);
	}
	
	@RequestMapping("/getCustomer")
	public ModelAndView getCustomerByEmail(HttpServletRequest req, HttpServletResponse res) {

		String email = req.getParameter(CUSTOMER_PARAM_EMAIL);

		logDebug(String.format("Get Customer by email [%s]", email));
		HashMap<String, Object> result = new HashMap<String, Object>();

		if (StringUtils.isEmpty(email)) {
			result.put("message", "Input email is empty");
		} else {
			 Customer customer = customerService.getCustomerByEmail(email.trim());
			if (customer != null) {
				List customerList = new ArrayList();
				customerList.add(customer);
				result.put("customer", customerList);
			} else {
				result.put("message", String.format("Cannot get customer by email [%s]", email));
			}
		}

		return new ModelAndView("customerInfo", "result", result);
	}
	
	@RequestMapping("/createCustomer")
	public ModelAndView createCustomer(HttpServletRequest req, HttpServletResponse res) {
		
		String email = req.getParameter(CUSTOMER_PARAM_EMAIL);
		String name = req.getParameter(CUSTOMER_PARAM_NAME);
		String phone = req.getParameter(CUSTOMER_PARAM_PHONE);
		String address = req.getParameter(CUSTOMER_PARAM_ADDRESS);
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("workflow", "create");
		
		//simple validation
		if(StringUtils.isEmpty(email) || StringUtils.isEmpty(name)){
			result.put("message", "Invalid input value!");
			 
			return new ModelAndView("createUser", "result", result);
		}
		
		Customer customer = new  Customer(0, name, email, "", phone, address);
		customer = customerService.createCustomer(customer);
		
		if(customer == null){
			result.put("message", "Create failed!");
		} else {
			List customerList = new ArrayList();
			customerList.add(customer);
			result.put("customer", customerList);
		} 
		  
		return new ModelAndView("customerInfo", "result", result);
	}
	
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCustomer(HttpServletRequest req, HttpServletResponse res) {
		
		String id = req.getParameter("id");
 		HashMap<String, Object> result = new HashMap<String, Object>();
 		
 		if(!StringUtils.isEmpty(id) ){
 			try {
 				Customer customer = customerService.delete(Long.parseLong(id));
 				
  				if(customer == null){
  					result.put("message", String.format("Customer id[%s] was not deleted !", id));
  				} else {
  					result.put("message", String.format("Customer [%s] was deleted !", customer.getEmail()));
  				} 
 				
			} catch (NumberFormatException e) {
				logError(e.getMessage());
			}
 		}
 		 
 		
		return new ModelAndView("home", "result", result);
	}
	 
	@RequestMapping("/updateCustomer")
	public ModelAndView enterEditCustomerPage(HttpServletRequest req, HttpServletResponse res) {
		
		String id = req.getParameter("id"); 
		
 		HashMap<String, Object> result = new HashMap<String, Object>();
 		
 		Customer customer = customerService.getCustomerById(Long.parseLong(id));
		if (customer == null) {
			result.put("message", String.format("Customer is not found for id[%s]!", id));
		} else {
			result.put("customer", customer);
		}
		  
		return new ModelAndView("updateUser", "result", result);
	}
	
	@RequestMapping("/updateCustomerInfo")
	public ModelAndView updateCustomerInfo(HttpServletRequest req, HttpServletResponse res) {
		
		String id = req.getParameter(CUSTOMER_PARAM_ID);
		String name = req.getParameter(CUSTOMER_PARAM_NAME);
		String email = req.getParameter(CUSTOMER_PARAM_EMAIL);
		String phone = req.getParameter(CUSTOMER_PARAM_PHONE);
		String address = req.getParameter(CUSTOMER_PARAM_ADDRESS);
		
 		HashMap<String, Object> result = new HashMap<String, Object>();
 		result.put("message","Customer is not updated !");
 		//simple validation
		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(name)) {
			result.put("message", "Invalid input value!");

		}else{
			Customer customer = customerService.getCustomerById(Long.parseLong(id));
			
			customer.setName(name);
			customer.setEmail(email);
			customer.setPhone(phone);
			customer.setAddress(address);
			
			customer = customerService.update(customer);
			
			if (customer != null) { 
				result.put("message","Customer is updated !");
				result.put("customer", customer);
			}
			
			result.put("message", "Customer was updated!");
			result.put("customer", customer);
		}
 		
		  
		return new ModelAndView("updateUser", "result", result);
	}
	 
	
	
	private void logDebug(String message){
		logger.debug(message);
	} 
	private void logError(String message){
		logger.error(message);
	}
	
}
