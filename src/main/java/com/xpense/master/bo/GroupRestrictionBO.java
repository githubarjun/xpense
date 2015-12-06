package com.xpense.master.bo;

import java.util.Date;
import com.xpense.commons.bo.MasterFieldsBO;
import com.xpense.commons.dto.BaseFieldsDTO;

public class GroupRestrictionBO extends MasterFieldsBO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1743240407667862413L;
	private UserGroupBO group;
	private Integer noOfUsers;
	private Date effectiveFrom;
	private Date effectiveTill;

	public GroupRestrictionBO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupRestrictionBO(UserGroupBO group, Integer noOfUsers,
			Date effectiveFrom, Date effectiveTill) {
		super();
		this.group = group;
		this.noOfUsers = noOfUsers;
		this.effectiveFrom = effectiveFrom;
		this.effectiveTill = effectiveTill;
	}

	public UserGroupBO getGroup() {
		return group;
	}

	public void setGroup(UserGroupBO group) {
		this.group = group;
	}

	public Integer getNoOfUsers() {
		return noOfUsers;
	}

	public void setNoOfUsers(Integer noOfUsers) {
		this.noOfUsers = noOfUsers;
	}

	public Date getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public Date getEffectiveTill() {
		return effectiveTill;
	}

	public void setEffectiveTill(Date effectiveTill) {
		this.effectiveTill = effectiveTill;
	}

	@Override
	protected BaseFieldsDTO createDTO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
