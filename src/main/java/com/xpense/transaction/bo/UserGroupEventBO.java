package com.xpense.transaction.bo;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import com.xpense.commons.bo.MakerCheckerFieldsBO;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.transaction.dto.UserGroupEventDTO;

public class UserGroupEventBO extends MakerCheckerFieldsBO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3027847044648648730L;
	private Long groupId;
	private String groupName;
	private Long createrId;
	private String createrName;
	private Date eventCreatedOn;
	private String eventDescription;
	private Double totalTransactionAmount;
	private Set<UserTransactionDtlsBO> userTransactionsDtls = new LinkedHashSet<UserTransactionDtlsBO>();

	public UserGroupEventBO() {
		super();
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getCreaterId() {
		return createrId;
	}
	public void setCreaterId(Long createrId) {
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
	public Set<UserTransactionDtlsBO> getUserTransactionsDtls() {
		return userTransactionsDtls;
	}
	public void setUserTransactionsDtls(
			Set<UserTransactionDtlsBO> userTransactionsDtls) {
		this.userTransactionsDtls = userTransactionsDtls;
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
	protected BaseFieldsDTO createDTO() {
		return new UserGroupEventDTO();
	}
	
}
