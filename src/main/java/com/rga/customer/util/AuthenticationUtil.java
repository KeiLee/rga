package com.rga.customer.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.rga.customer.bean.SystemUser;
import com.rga.customer.dao.UserDAO;

public class AuthenticationUtil {
	
	@Autowired
	UserDAO userDAO;
	
	
	@Transactional
	public SystemUser getUserByEmail(String email) {
		  
		return userDAO.getSystemUserByEmail(email);
 	}

}
