package com.xpense.transaction.bo;

import com.xpense.commons.bo.MakerCheckerFieldsBO;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.master.bo.UserBO;

public class UserEventNotificationBO extends MakerCheckerFieldsBO{

	private static final long serialVersionUID = 3666358001995748591L;

	private UserGroupEventBO userGroupEvent;
	private UserBO userToNotify;
	private Boolean notificationResult;
	private String notificationDesc;
	
	public UserEventNotificationBO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserGroupEventBO getUserGroupEvent() {
		return userGroupEvent;
	}
	public void setUserGroupEvent(UserGroupEventBO userGroupEvent) {
		this.userGroupEvent = userGroupEvent;
	}
	public UserBO getUserToNotify() {
		return userToNotify;
	}
	public void setUserToNotify(UserBO userToNotify) {
		this.userToNotify = userToNotify;
	}
	public Boolean getNotificationResult() {
		return notificationResult;
	}
	public void setNotificationResult(Boolean notificationResult) {
		this.notificationResult = notificationResult;
	}
	public String getNotificationDesc() {
		return notificationDesc;
	}
	public void setNotificationDesc(String notificationDesc) {
		this.notificationDesc = notificationDesc;
	}

	@Override
	protected BaseFieldsDTO createDTO() {
		return null;
	}
	
}
