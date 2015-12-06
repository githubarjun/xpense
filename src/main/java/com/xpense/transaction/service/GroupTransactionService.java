package com.xpense.transaction.service;

import java.util.List;

import com.xpense.transaction.dto.UserGroupEventDTO;

public interface GroupTransactionService {

	public void create(UserGroupEventDTO eventDTO)throws Exception;
	public void update(UserGroupEventDTO eventDTO)throws Exception;
	public void delete(UserGroupEventDTO eventDTO)throws Exception;
	
	public List<UserGroupEventDTO> findBySpec(String specification) throws Exception;
	public UserGroupEventDTO findById(String id) throws Exception;
	public List<UserGroupEventDTO> findAllAuthorized(String spec)throws Exception;

}
