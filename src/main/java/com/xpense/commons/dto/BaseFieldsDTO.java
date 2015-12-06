package com.xpense.commons.dto;

import java.io.Serializable;

public abstract class BaseFieldsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1512197310678091918L;
	private String id;
	private Integer version;
	
	public BaseFieldsDTO() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public abstract String getBOClassName();
	
}
