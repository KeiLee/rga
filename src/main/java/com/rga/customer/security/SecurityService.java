package com.rga.customer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rga.customer.bean.SystemUser;
import com.rga.customer.util.AuthenticationUtil;

public class SecurityService implements UserDetailsService {
	
	@Autowired
	AuthenticationUtil authenticationUtil;
	
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
         
    	//get user from DB 
    	SystemUser systemUser = authenticationUtil.getUserByEmail(username);
    	if(systemUser != null){
    		UserCredentials user = new UserCredentials(systemUser.getEmail(), systemUser.getPassword());
    		return user;
    	}
    	 
        throw new UsernameNotFoundException("User " + username + " has no GrantedAuthority");
          
    }
}
