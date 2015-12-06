package com.xpense.master.bo;

import java.util.LinkedHashSet;
import java.util.Set;

import com.xpense.commons.bo.MasterFieldsBO;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.master.dto.UserGroupDTO;

public class UserGroupBO extends MasterFieldsBO{

	private static final long serialVersionUID = 6165235401337542496L;
	private String groupCode;
	private String groupName;
	private Long noOfUsers;
	private Long userId;
	//private UserBO creator;
	private Set<UserGroupDtlsBO> groupDtls = new LinkedHashSet<UserGroupDtlsBO>();
	
	//private Set<UserBO> users = new LinkedHashSet<UserBO>();
	//private GroupRestrictionBO groupRestriction;

	public UserGroupBO() {
		super();
		//this.groupRestriction = new GroupRestriction(this,5);
	}
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public Long getNoOfUsers() {
		return noOfUsers;
	}
	public void setNoOfUsers(Long noOfUsers) {
		this.noOfUsers = noOfUsers;
	}
	public Set<UserGroupDtlsBO> getGroupDtls() {
		return groupDtls;
	}
	public void setGroupDtls(Set<UserGroupDtlsBO> groupDtls) {
		this.groupDtls = groupDtls;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	protected BaseFieldsDTO createDTO() {
		return new UserGroupDTO();
	}
}
