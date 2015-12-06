package com.xpense.commons.dto;

import java.util.Date;

public abstract class MakerCheckerFieldsDTO extends BaseFieldsDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 41069211737122807L;
	private String lastStatus;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;

	public MakerCheckerFieldsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getLastStatus() {
		return lastStatus;
	}
	public void setLastStatus(String lastStatus) {
		this.lastStatus = lastStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
