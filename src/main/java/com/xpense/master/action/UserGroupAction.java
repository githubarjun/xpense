package com.xpense.master.action;

import java.util.List;

import com.xpense.commons.action.BaseOperationAction;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.login.Ticket;
import com.xpense.master.dto.UserDTO;
import com.xpense.master.dto.UserGroupDTO;
import com.xpense.master.service.UserGroupService;
import com.xpense.master.service.UserService;
import com.xpense.master.service.impl.UserGroupServiceImpl;
import com.xpense.master.service.impl.UserServiceImpl;

public class UserGroupAction extends BaseOperationAction{

	public BaseFieldsDTO getDTO(){
		return new UserGroupDTO();
	}

	public void saveObject(BaseFieldsDTO baseFieldsDTO)throws Exception {
		
		Ticket ticket = getTicket();
		Long userId = ticket.getUserId();
		//UserService userService = new UserServiceImpl();
		//UserDTO userDTO = userService.findById(userId);
		
		UserGroupDTO userGroupDTO = (UserGroupDTO)baseFieldsDTO;
		//userGroupDTO.setCreator(userDTO);
		userGroupDTO.setUserId(userId.toString());
		
		UserGroupService userGroupService = new UserGroupServiceImpl();
		if(baseFieldsDTO.getId() == null || "".equals(baseFieldsDTO.getId())){
			userGroupService.create(userGroupDTO);
		}else{
			userGroupService.update(userGroupDTO);
		}
	}

	public String getActionForward() {
		return "UserGroupForm";
	}
	
	public String getActionViewForward(){
		return "UserGroupView";
	}
	@Override
	public String getActionListingForward() {
		return "UserGroupList";
	}

	@Override
	public BaseFieldsDTO getDtoById(String id) throws Exception {
		UserGroupService userGroupService = new UserGroupServiceImpl();
		List<UserGroupDTO> userGroupDtos = userGroupService.findBySpec(" id = "+id);
		if(userGroupDtos != null && userGroupDtos.size() > 0){
			return userGroupDtos.get(0);
		}else{
			return null;
		}
	}

	
}
