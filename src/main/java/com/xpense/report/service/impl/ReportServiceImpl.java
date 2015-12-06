package com.xpense.report.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.xpense.HibernateSessionFactory;
import com.xpense.commons.dao.CommonsDAO;
import com.xpense.report.service.ReportService;
import com.xpense.transaction.bo.UserGroupEventBO;
import com.xpense.transaction.dto.UserGroupEventDTO;

public class ReportServiceImpl implements ReportService{

	@Override
	public List<UserGroupEventDTO> getSpendingReport(String groupCode)
			throws Exception {

		List<UserGroupEventDTO> eventDTOs = new ArrayList<UserGroupEventDTO>();
		Session session;
		try{
			session = HibernateSessionFactory.getSession();
			
			CommonsDAO<UserGroupEventBO> dao =  new CommonsDAO<UserGroupEventBO>(session,UserGroupEventBO.class);
			List<UserGroupEventBO> eventBos = dao.findBySpec(" groupId = '"+groupCode+"'");
			
			for(UserGroupEventBO eventBO : eventBos){
				eventDTOs.add((UserGroupEventDTO)eventBO.toDTO());
			}
			
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}finally{
			
			HibernateSessionFactory.closeSession();
		}
		
		return eventDTOs;
	}

	@Override
	public List<UserGroupEventDTO> getSettlementReport(String groupCode)
			throws Exception {
		List<UserGroupEventDTO> eventDTOs = new ArrayList<UserGroupEventDTO>();
		Session session;
		try{
			session = HibernateSessionFactory.getSession();
			
			CommonsDAO<UserGroupEventBO> dao =  new CommonsDAO<UserGroupEventBO>(session,UserGroupEventBO.class);
			List<UserGroupEventBO> eventBos = dao.findBySpec(" groupId = '"+groupCode+"'");
			
			for(UserGroupEventBO eventBO : eventBos){
				eventDTOs.add((UserGroupEventDTO)eventBO.toDTO());
			}
			
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}finally{
			
			HibernateSessionFactory.closeSession();
		}
		
		return eventDTOs;
	}

	

}
