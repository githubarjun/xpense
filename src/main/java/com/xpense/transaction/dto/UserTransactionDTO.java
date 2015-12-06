package com.xpense.transaction.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.xpense.commons.dto.MakerCheckerFieldsDTO;
import com.xpense.transaction.enums.ContributionType;

public class UserTransactionDTO extends MakerCheckerFieldsDTO{

	private static final long serialVersionUID = -8660358051587596870L;
	
	private UserGroupEventDTO userGroupEvent;
	
	private ContributionType contributionType;
	
	public UserGroupEventDTO getUserGroupEvent() {
		return userGroupEvent;
	}
	public void setUserGroupEvent(UserGroupEventDTO userGroupEvent) {
		this.userGroupEvent = userGroupEvent;
	}
	public ContributionType getContributionType() {
		return contributionType;
	}
	public void setContributionType(ContributionType contributionType) {
		this.contributionType = contributionType;
	}
	@Override
	public String getBOClassName() {
		return "";
	}

}
