package com.xpense.login.service.impl;

import java.util.List;

import org.hibernate.Session;

import com.xpense.HibernateSessionFactory;
import com.xpense.bootstrap.Main;
import com.xpense.commons.dao.CommonsDAO;
import com.xpense.login.Ticket;
import com.xpense.login.service.LoginService;
import com.xpense.master.bo.UserBO;

public class LoginServiceImpl implements LoginService{

	@Override
	public Ticket authenticateUser(String userName, String password)
			throws Exception {
		
		Ticket ticket = null;
		Session session = null;
		try{
			session = HibernateSessionFactory.getSession();
			CommonsDAO<UserBO> dao = new CommonsDAO<UserBO>(session,UserBO.class);
			List<UserBO> userList = dao.findBySpec("userName = '"+ userName+"'");
			UserBO bo = null;
			if(userList != null && userList.size() > 0){
				bo = userList.get(0);
				if(!password.equals(bo.getPassword())){
					return null;
				}
			}else{
				return null;
			}
			
			if(bo != null){
				Main main = Main.getInstance();
				ticket = new Ticket();
				ticket.setUserId(bo.getId());
				ticket.setUserName(bo.getUserName());
				main.addTicket(bo.getUserName(), ticket);
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}finally{
			
			if(!session.isOpen()){
				session.close();
			}
			
		}
		
		
		return ticket;
	}
	
}
