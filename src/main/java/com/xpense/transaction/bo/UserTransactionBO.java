package com.xpense.transaction.bo;

import java.util.LinkedHashSet;
import java.util.Set;

import com.xpense.commons.bo.MakerCheckerFieldsBO;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.transaction.enums.ContributionType;

public class UserTransactionBO extends MakerCheckerFieldsBO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6002797333390125820L;
	private UserGroupEventBO userGroupEvent;
	
	private ContributionType contributionType;
	
	public UserTransactionBO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserGroupEventBO getUserGroupEvent() {
		return userGroupEvent;
	}
	public void setUserGroupEvent(UserGroupEventBO userGroupEvent) {
		this.userGroupEvent = userGroupEvent;
	}
	public ContributionType getContributionType() {
		return contributionType;
	}
	public void setContributionType(ContributionType contributionType) {
		this.contributionType = contributionType;
	}

	@Override
	protected BaseFieldsDTO createDTO() {
		// TODO Auto-generated method stub
		return null;
	}
}
