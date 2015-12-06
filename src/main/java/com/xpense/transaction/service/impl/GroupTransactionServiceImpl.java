package com.xpense.transaction.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.xpense.HibernateSessionFactory;
import com.xpense.commons.dao.CommonsDAO;
import com.xpense.commons.service.MakerCheckerService;
import com.xpense.transaction.bo.UserGroupEventBO;
import com.xpense.transaction.dto.UserGroupEventDTO;
import com.xpense.transaction.dto.UserTransactionDtlsDTO;
import com.xpense.transaction.service.GroupTransactionService;

public class GroupTransactionServiceImpl implements GroupTransactionService{

	MakerCheckerService<UserGroupEventBO, UserGroupEventDTO> eventService = new MakerCheckerService<UserGroupEventBO, UserGroupEventDTO>(UserGroupEventBO.class);
	
	@Override
	public void create(UserGroupEventDTO eventDTO) throws Exception {
		
		eventService.setFields(eventDTO, "CREATE");
		for(UserTransactionDtlsDTO transactionDtlsDTO : eventDTO.getUserTransactionsDtls()){
			double differenceAmount = 0;
			double paidAmount = 0;
			double contriAmount = 0;
			paidAmount = transactionDtlsDTO.getPaidAmount();
			contriAmount = transactionDtlsDTO.getContributionAmount();
			differenceAmount = paidAmount - contriAmount;
			transactionDtlsDTO.setDifferenceAmount(differenceAmount);
			
			eventService.setFields(transactionDtlsDTO, "CREATE");
		}
		eventService.create(eventDTO);
	}
	
	@Override
	public void 
	delete(UserGroupEventDTO eventDTO) throws Exception {
		
	}
	
	@Override
	public void update(UserGroupEventDTO eventDTO) throws Exception {
		eventService.setFields(eventDTO, "CREATE");
		for(UserTransactionDtlsDTO transactionDtlsDTO : eventDTO.getUserTransactionsDtls()){
			
			double differenceAmount = 0;
			double paidAmount = 0;
			double contriAmount = 0;
			if(transactionDtlsDTO.getPaidAmount() != null && !"".equals(transactionDtlsDTO.getPaidAmount())){
				paidAmount = transactionDtlsDTO.getPaidAmount();
			}
			if(transactionDtlsDTO.getContributionAmount() != null && !"".equals(transactionDtlsDTO.getContributionAmount())){
				contriAmount = transactionDtlsDTO.getContributionAmount();
			}
			
			differenceAmount = paidAmount - contriAmount;
			transactionDtlsDTO.setDifferenceAmount(differenceAmount);
			
			if(transactionDtlsDTO.getId() == null || "".equals(transactionDtlsDTO.getId())){
				eventService.setFieldsUpdate(transactionDtlsDTO, "UPDATE");
			}else{
				eventService.setFields(transactionDtlsDTO, "CREATE");
			}
		}
		eventService.update(eventDTO);
	}

	@Override
	public List<UserGroupEventDTO> findAllAuthorized(String spec) throws Exception {
		List<UserGroupEventDTO> eventDTOs = new ArrayList<UserGroupEventDTO>();
		Session session = null;
		
		try{
			session = HibernateSessionFactory.getSession();
			CommonsDAO<UserGroupEventBO> dao = new CommonsDAO<UserGroupEventBO>(session,UserGroupEventBO.class);
			List<UserGroupEventBO> list = dao.findBySpec(spec);
			
			for(UserGroupEventBO eventBO : list){
				eventDTOs.add((UserGroupEventDTO) eventBO.toDTO());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return eventDTOs;
	}

	@Override
	public UserGroupEventDTO findById(String id) throws Exception {

		UserGroupEventDTO eventDTOs = null;
		Session session = null;
		
		try{
			session = HibernateSessionFactory.getSession();
			CommonsDAO<UserGroupEventBO> dao = new CommonsDAO<UserGroupEventBO>(session,UserGroupEventBO.class);
			List<UserGroupEventBO> list = dao.findBySpec(" id = "+id);
			
			for(UserGroupEventBO eventBO : list){
				eventDTOs= (UserGroupEventDTO) eventBO.toDTO();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return eventDTOs;
		
	}

	@Override
	public List<UserGroupEventDTO> findBySpec(String specification)
			throws Exception {
		
		Session session = null;
		List<UserGroupEventDTO> eventDTOs = new ArrayList<UserGroupEventDTO>();
		try{
			session = HibernateSessionFactory.getSession();
			CommonsDAO<UserGroupEventBO> commonsDAO = new CommonsDAO<UserGroupEventBO>(session,UserGroupEventBO.class);
			
			List<UserGroupEventBO> groupEventBOs = commonsDAO.findBySpec(specification);
			
			for(UserGroupEventBO groupBO : groupEventBOs){
				eventDTOs.add((UserGroupEventDTO) groupBO.toDTO());
			}
			
		}catch (Exception e) {
			e.printStackTrace();	
		}finally{
			session.close();
		}
		return eventDTOs;
		
	}

}
