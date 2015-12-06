package com.xpense.master.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.xpense.commons.dto.MasterFieldsDTO;

public class UserGroupDTO extends MasterFieldsDTO{

	private static final long serialVersionUID = -346398766419402169L;
	private String groupCode;
	private String groupName;
	private Long noOfUsers;
	private String userId;
	//private UserDTO creator;
	private Set<UserGroupDtlsDTO> groupDtls = new LinkedHashSet<UserGroupDtlsDTO>();
	
	public UserGroupDTO() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Long getNoOfUsers() {
		return noOfUsers;
	}
	public void setNoOfUsers(Long noOfUsers) {
		this.noOfUsers = noOfUsers;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Set<UserGroupDtlsDTO> getGroupDtls() {
		return groupDtls;
	}
	public void setGroupDtls(Set<UserGroupDtlsDTO> groupDtls) {
		this.groupDtls = groupDtls;
	}

	@Override
	public String getBOClassName() {
		return "com.xpense.master.bo.UserGroupBO";
	}
	
}
