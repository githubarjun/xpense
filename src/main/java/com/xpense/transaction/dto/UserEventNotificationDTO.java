package com.xpense.transaction.dto;

import com.xpense.commons.dto.MakerCheckerFieldsDTO;
import com.xpense.master.dto.UserDTO;

public class UserEventNotificationDTO extends MakerCheckerFieldsDTO{

	private static final long serialVersionUID = -8325567188472248922L;

	private UserGroupEventDTO userGroupEvent;
	private UserDTO userToNotify;
	private Boolean notificationResult;
	private String notificationDesc;
	public UserGroupEventDTO getUserGroupEvent() {
		return userGroupEvent;
	}
	public void setUserGroupEvent(UserGroupEventDTO userGroupEvent) {
		this.userGroupEvent = userGroupEvent;
	}
	public UserDTO getUserToNotify() {
		return userToNotify;
	}
	public void setUserToNotify(UserDTO userToNotify) {
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
	public String getBOClassName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
