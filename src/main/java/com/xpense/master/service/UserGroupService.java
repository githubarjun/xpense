package com.xpense.master.service;

import java.util.List;

import com.xpense.master.dto.UserGroupDTO;

public interface UserGroupService {

	public void create(UserGroupDTO groupDTO)throws Exception;
	public void update(UserGroupDTO groupDTO)throws Exception;
	public void delete(UserGroupDTO groupDTO)throws Exception;
	public void enable(UserGroupDTO groupDTO)throws Exception;
	public void disable(UserGroupDTO groupDTO)throws Exception;
	public List<UserGroupDTO> findBySpec(String specification) throws Exception;
	public UserGroupDTO findById(String id) throws Exception;
	public Object findById(String id,String column) throws Exception;
	public List<UserGroupDTO> findAllAuthorized(String spec)throws Exception;
}
