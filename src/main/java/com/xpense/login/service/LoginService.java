package com.xpense.login.service;

import com.xpense.login.Ticket;

public interface LoginService {

	public Ticket authenticateUser(String userName,String password)throws Exception;
	
}
