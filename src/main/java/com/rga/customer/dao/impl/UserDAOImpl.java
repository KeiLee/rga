package com.rga.customer.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rga.customer.bean.Customer;
import com.rga.customer.bean.SystemUser;
import com.rga.customer.bean.User;
import com.rga.customer.dao.UserDAO;



public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	
	@Autowired
    private SessionFactory sessionFactory;
	 
	@Override
	public SystemUser getSystemUserByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		String queryString = String.format("SELECT new SystemUser(user.id, user.name, user.email, user.password, user.level, user.title) FROM SystemUser as user WHERE user.email = '%s' ", email);
		Query query = session.createQuery(queryString);
		
		List users = query.list();
		if(users != null && !users.isEmpty()){
			return (SystemUser)users.get(0);
		}
		  
		return null;
	}
     
	@Override
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		//String queryString = String.format("SELECT new Customer(customer.id, customer.name, customer.email) FROM Customer as customer WHERE customer.email = '%s' ", email);
		String queryString = String.format("FROM Customer as customer WHERE customer.userType = '%s' ", User.USER_TYPE_CUSTOMER);

		Query query = session.createQuery(queryString);

		List<Customer> resultList = query.list();
		  
		return resultList;
	}

	@Override 
	public Customer getCustomerByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		String queryString = String.format("SELECT new Customer(customer.id, customer.name, customer.email, customer.password, customer.phone, customer.address) FROM Customer as customer WHERE customer.email = '%s' ", email);
		Query query = session.createQuery(queryString);
		
		List customers = query.list();
		if(customers != null && !customers.isEmpty()){
			return (Customer)customers.get(0);
		}
		  
		return null;
	}
	
	@Override 
	public Customer getCustomerById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer)session.get(Customer.class, id);
		
		return customer;
	}

	@Override 
	public Customer createCustomer(Customer customer) {
 		Session session = sessionFactory.getCurrentSession();

		try {
			session.save(customer);
		} catch (Exception e) {
			logError(e.getMessage());
			return null;
		} 
		
		return customer;
	}

	@Override 
	public Customer updateCustomer(Customer customer) {
 		Session session = sessionFactory.getCurrentSession();

		try {
			session.update(customer);
		} catch (Exception e) {
			logError(e.getMessage());
			return null;
		}
		return customer;
	}

	@Override
	public Customer deleteCustomer(long id) {
		Session session = sessionFactory.getCurrentSession();

		Customer customer = (Customer) session.get(Customer.class, id);

		if (customer != null) {
			try {
				session.delete(customer);
				 
			} catch (HibernateException e) {
				logError(e.getMessage());
				return null;
			}
		}

		return customer;
	}

	private void logDebug(String message){
		logger.debug(message);
	}
	private void logError(String message){
		logger.error(message);
	}


	  
	
}
