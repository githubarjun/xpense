package com.xpense.transaction.dto;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import com.xpense.commons.dto.MakerCheckerFieldsDTO;

public class UserGroupEventDTO extends MakerCheckerFieldsDTO{

	private static final long serialVersionUID = 3208868859740220901L;

	private String groupId;
	private String groupName;
	private String createrId;
	private String createrName;
	private Date eventCreatedOn;
	private String eventDescription;
	private Double totalTransactionAmount;
	private Set<UserTransactionDtlsDTO> userTransactionsDtls = new LinkedHashSet<UserTransactionDtlsDTO>();

	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getCreaterId() {
		return createrId;
	}
	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	public Date getEventCreatedOn() {
		return eventCreatedOn;
	}
	public void setEventCreatedOn(Date eventCreatedOn) {
		this.eventCreatedOn = eventCreatedOn;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public Double getTotalTransactionAmount() {
		return totalTransactionAmount;
	}
	public void setTotalTransactionAmount(Double totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}
	public Set<UserTransactionDtlsDTO> getUserTransactionsDtls() {
		return userTransactionsDtls;
	}
	public void setUserTransactionsDtls(
			Set<UserTransactionDtlsDTO> userTransactionsDtls) {
		this.userTransactionsDtls = userTransactionsDtls;
	}
	public void addUserTransactionsDtls(UserTransactionDtlsDTO transactionDtlsDTO){
		this.userTransactionsDtls.add(transactionDtlsDTO);
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	@Override
	public String getBOClassName() {
		return null;
	}

}
