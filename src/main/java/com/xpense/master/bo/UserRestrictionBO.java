package com.xpense.master.bo;

import com.xpense.commons.bo.MasterFieldsBO;
import com.xpense.commons.dto.BaseFieldsDTO;

public class UserRestrictionBO extends MasterFieldsBO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7586158943804325168L;
	private UserBO user;
	private Boolean canCreateEvent;
	private Boolean canInvite;
	
	public UserRestrictionBO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRestrictionBO(UserBO user, boolean canCreateEvent, boolean canInvite) {
		super();
		this.user = user;
		this.canCreateEvent = canCreateEvent;
		this.canInvite = canInvite;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	public Boolean isCanCreateEvent() {
		return canCreateEvent;
	}

	public void setCanCreateEvent(Boolean canCreateEvent) {
		this.canCreateEvent = canCreateEvent;
	}

	public Boolean isCanInvite() {
		return canInvite;
	}

	public void setCanInvite(Boolean canInvite) {
		this.canInvite = canInvite;
	}

	@Override
	protected BaseFieldsDTO createDTO() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
