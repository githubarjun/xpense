package com.xpense.master.dto;

import com.xpense.commons.dto.MasterFieldsDTO;

public class UserGroupDtlsDTO extends MasterFieldsDTO{

	private static final long serialVersionUID = 8042710890068334073L;
	private String name;
	private Long userId;
	
	public UserGroupDtlsDTO() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String getBOClassName() {
		return "com.xpense.master.bo.UserGroupDtlsBO";
	}
	
}
