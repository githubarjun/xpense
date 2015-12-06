package com.xpense.master.dto;

import com.xpense.commons.dto.MakerCheckerFieldsDTO;
import com.xpense.master.bo.UserBO;

public class UserRestrictionDTO extends MakerCheckerFieldsDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4158602098321776360L;
	private UserBO user;
	private Boolean canCreateEvent;
	private Boolean canInvite;
	
	public UserRestrictionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	public Boolean getCanCreateEvent() {
		return canCreateEvent;
	}

	public void setCanCreateEvent(Boolean canCreateEvent) {
		this.canCreateEvent = canCreateEvent;
	}

	public Boolean getCanInvite() {
		return canInvite;
	}

	public void setCanInvite(Boolean canInvite) {
		this.canInvite = canInvite;
	}

	@Override
	public String getBOClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
