package com.xpense.commons.bo;

import java.util.Date;

public abstract class MasterFieldsBO extends MakerCheckerFieldsBO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5254476410637284836L;
	private Boolean active;
	private Boolean enabled;
	private Date effectiveFrom;
	private Date effectiveTill;
	
	public MasterFieldsBO() {
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
