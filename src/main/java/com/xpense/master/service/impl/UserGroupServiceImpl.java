package com.xpense.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.xpense.HibernateSessionFactory;
import com.xpense.commons.dao.CommonsDAO;
import com.xpense.commons.service.MasterService;
import com.xpense.master.bo.UserGroupBO;
import com.xpense.master.dto.UserGroupDTO;
import com.xpense.master.dto.UserGroupDtlsDTO;
import com.xpense.master.service.UserGroupService;

public class UserGroupServiceImpl implements UserGroupService{

	MasterService<UserGroupBO, UserGroupDTO> masterService = new MasterService<UserGroupBO, UserGroupDTO>(UserGroupBO.class);
	
	@Override
	public void create(UserGroupDTO groupDTO)throws Exception {
		
		masterService.setFields(groupDTO, "CREATE");
		for(UserGroupDtlsDTO groupDtlsDTO : groupDTO.getGroupDtls()){
			masterService.setFields(groupDtlsDTO, "CREATE");
		}
		masterService.create(groupDTO);
	}

	@Override
	public void delete(UserGroupDTO groupDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disable(UserGroupDTO groupDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enable(UserGroupDTO groupDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserGroupDTO groupDTO) throws Exception {
		masterService.setFieldsUpdate(groupDTO, "UPDATE");
		for(UserGroupDtlsDTO groupDtlsDTO : groupDTO.getGroupDtls()){
			if(groupDtlsDTO.getId() == null || "".equals(groupDtlsDTO.getId())){
				masterService.setFields(groupDtlsDTO, "CREATE");
			}else{
				masterService.setFieldsUpdate(groupDtlsDTO, "UPDATE");
			}
		}
		masterService.update(groupDTO);
	}
	
	public List<UserGroupDTO> findBySpec(String specification) throws Exception{
		Session session = null;
		List<UserGroupDTO> groupDTOs = new ArrayList<UserGroupDTO>();
		try{
			session = HibernateSessionFactory.getSession();
			CommonsDAO<UserGroupBO> commonsDAO = new CommonsDAO<UserGroupBO>(session,UserGroupBO.class);
			
			List<UserGroupBO> groupBOs = commonsDAO.findBySpec(specification);
			
			for(UserGroupBO groupBO : groupBOs){
				groupDTOs.add((UserGroupDTO) groupBO.toDTO());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			session.close();
		}
		return groupDTOs;
	}

	public UserGroupDTO findById(String id) throws Exception{
		Session session = null;
		UserGroupBO groupBO = null;
		try{
			session = HibernateSessionFactory.getSession();
			CommonsDAO<UserGroupBO> commonsDAO = new CommonsDAO<UserGroupBO>(session,UserGroupBO.class);
			
			groupBO = commonsDAO.findById(Long.parseLong(id));
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			session.close();
		}
		return (UserGroupDTO) groupBO.toDTO();
	}

	@Override
	public List<UserGroupDTO> findAllAuthorized(String spec) throws Exception {

		List<UserGroupDTO> groupDTOs = new ArrayList<UserGroupDTO>();
		Session session = null;
		try{
			session = HibernateSessionFactory.getSession();
			CommonsDAO<UserGroupBO> commonsDAO = new CommonsDAO<UserGroupBO>(session,UserGroupBO.class);
			
			List<UserGroupBO> groupBOs = commonsDAO.findBySpec(spec);
			
			for(UserGroupBO groupBO : groupBOs){
				groupDTOs.add((UserGroupDTO) groupBO.toDTO());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			session.close();	
		}
		
		return groupDTOs;
	}

	@Override
	public Object findById(String id, String column) throws Exception {
		return null;
	}

}
