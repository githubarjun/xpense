package com.xpense.transaction.dto;

import com.xpense.commons.dto.MakerCheckerFieldsDTO;
import com.xpense.transaction.bo.UserGroupEventBO;

public class UserTransactionDtlsDTO extends MakerCheckerFieldsDTO{

	private static final long serialVersionUID = -5588958483758239720L;

	private String groupUserId;
	private Double paidAmount;
	private Double contributionAmount;
	private Double differenceAmount;
	private UserGroupEventBO userGroupEvent;

	public UserTransactionDtlsDTO() {
		super();
	}

	public Double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Double getContributionAmount() {
		return contributionAmount;
	}
	public void setContributionAmount(Double contributionAmount) {
		this.contributionAmount = contributionAmount;
	}
	public String getGroupUserId() {
		return groupUserId;
	}
	public void setGroupUserId(String groupUserId) {
		this.groupUserId = groupUserId;
	}
	public Double getDifferenceAmount() {
		return differenceAmount;
	}
	public void setDifferenceAmount(Double differenceAmount) {
		this.differenceAmount = differenceAmount;
	}
	public UserGroupEventBO getUserGroupEvent() {
		return userGroupEvent;
	}
	public void setUserGroupEvent(UserGroupEventBO userGroupEvent) {
		this.userGroupEvent = userGroupEvent;
	}

	@Override
	public String getBOClassName() {
		return "com.xpense.transaction.bo.UserTransactionDtlsBO";
	}
	
}
