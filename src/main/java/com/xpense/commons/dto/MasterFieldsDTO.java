package com.xpense.commons.dto;

import java.util.Date;


public abstract class MasterFieldsDTO extends MakerCheckerFieldsDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 769776767240754313L;
	private Boolean active;
	private Boolean enabled;
	private Date effectiveFrom;
	private Date effectiveTill;

	public MasterFieldsDTO() {
		super();
	}
	
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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
	
}
