package com.xpense.master.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.xpense.commons.dto.MasterFieldsDTO;

public class UserDTO extends MasterFieldsDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3345756635303586262L;
	private String userName;
	private String password;
	//private Set<UserGroupDTO> userGroups = new LinkedHashSet<UserGroupDTO>();
	
	//private byte[] userImage;
	//private String userImageName;
	//private String userImageId;
	//private UserRestrictionDTO userRestriction;
	//private UserAccountBO userAccount;
	
	public UserDTO() {
		super();
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getBOClassName() {
		return "com.xpense.master.bo.UserBO";
	}

}
