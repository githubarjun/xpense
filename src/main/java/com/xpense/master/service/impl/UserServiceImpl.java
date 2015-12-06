package com.xpense.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.xpense.HibernateSessionFactory;
import com.xpense.commons.dao.CommonsDAO;
import com.xpense.commons.service.MasterService;
import com.xpense.master.bo.UserBO;
import com.xpense.master.dto.UserDTO;
import com.xpense.master.service.UserService;

public class UserServiceImpl implements UserService{

	MasterService<UserBO, UserDTO> masterService = new MasterService<UserBO, UserDTO>(UserBO.class);
	
	@Override
	public void create(UserDTO userDTO) throws Exception {
		
		List<UserDTO> list = findBySpec(" username = '"+userDTO.getUserName()+"'");
		if(list != null && list.size() > 0){
			throw new Exception("User Already Exists");
		}else{
			masterService.setFields(userDTO, "CREATE");
			masterService.create(userDTO);
		}
	}

	@Override
	public void delete(UserDTO userDTO) throws Exception {
		masterService.delete(userDTO);		
	}

	@Override
	public void disable(UserDTO userDTO) throws Exception {

	}

	@Override
	public void enable(UserDTO userDTO) throws Exception {

	}

	@Override
	public void update(UserDTO userDTO) throws Exception {
		masterService.update(userDTO);		
	}

	@Override
	public UserDTO findById(Long id) throws Exception {
		Session session = null;
		UserBO userBO = null;
		try{
			session = HibernateSessionFactory.getSession();
			CommonsDAO<UserBO> commonsDAO = new CommonsDAO<UserBO>(session,UserBO.class);
			
			userBO = commonsDAO.findById(id);
			
		}catch (Exception e) {
			throw e;
		}finally{
			session.close();
		}
		return (UserDTO) userBO.toDTO();
	}

	@Override
	public List<UserDTO> findBySpec(String specification) throws Exception {
		Session session = null;
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		try{
			session = HibernateSessionFactory.getSession();
			CommonsDAO<UserBO> commonsDAO = new CommonsDAO<UserBO>(session,UserBO.class);
			
			List<UserBO> userBOs = commonsDAO.findBySpec(specification);
			
			for(UserBO userBO : userBOs){
				userDTOs.add((UserDTO) userBO.toDTO());
			}
			
		}catch (Exception e) {
			throw e;
		}finally{
			session.close();
		}
		return userDTOs;
	}

	@Override
	public Object findById(String id, String column) throws Exception {
		Session session = null;
		Object returnValue = null;
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		try{
			session = HibernateSessionFactory.getSession();
			CommonsDAO<UserBO> commonsDAO = new CommonsDAO<UserBO>(session,UserBO.class);
			List<Object[]> list = commonsDAO.getProjectionById(" id = "+id, column);
			
			if(list != null && list.size() > 0){
				for(Object[] object : list){
					returnValue = object[0];
					break;
				}
			}
			
		}catch (Exception e) {
			throw e;
		}finally{
			session.close();
		}
		return returnValue;
	}

}
