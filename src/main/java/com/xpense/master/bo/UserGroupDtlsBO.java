package com.xpense.master.bo;

import com.xpense.commons.bo.MasterFieldsBO;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.master.dto.UserGroupDtlsDTO;

public class UserGroupDtlsBO extends MasterFieldsBO{

	private static final long serialVersionUID = 5543770995412060348L;
	private String name;
	private Long userId;
	
	public UserGroupDtlsBO() {
		super();
	}

	@Override
	protected BaseFieldsDTO createDTO() {
		return new UserGroupDtlsDTO();
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
	
}
