package com.xpense.commons.bo;

import java.util.Date;

public abstract class MakerCheckerFieldsBO extends BaseFieldsBO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8807178858699710787L;
	private String lastStatus;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
	
	public MakerCheckerFieldsBO() {
		super();
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
