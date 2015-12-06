package com.xpense.master.service;

import java.util.List;

import com.xpense.master.dto.UserDTO;

public interface UserService {

	public void create(UserDTO userDTO)throws Exception;
	public void update(UserDTO userDTO)throws Exception;
	public void delete(UserDTO userDTO)throws Exception;
	public void enable(UserDTO userDTO)throws Exception;
	public void disable(UserDTO userDTO)throws Exception;
	public List<UserDTO> findBySpec(String specification) throws Exception;
	public UserDTO findById(Long id) throws Exception;
	public Object findById(String id,String column) throws Exception;
}
