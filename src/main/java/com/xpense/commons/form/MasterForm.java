package com.xpense.commons.form;

import java.util.Date;

import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.commons.dto.MasterFieldsDTO;
import com.xpense.utils.DateUtils;

public abstract class MasterForm extends MakerCheckerForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4933942271681736999L;
	private Boolean active;
	private Boolean enabled;
	private String effectiveFrom;
	private String effectiveTill;
	public static final String DATE_FORMAT = "dd-MMM-yyyy";
	
	public MasterForm() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public String getEffectiveTill() {
		return effectiveTill;
	}

	public void setEffectiveTill(String effectiveTill) {
		this.effectiveTill = effectiveTill;
	}

	public void fillForm(BaseFieldsDTO fieldsDTO){
		super.fillForm(fieldsDTO);
		MasterFieldsDTO masterFieldsDTO = (MasterFieldsDTO)fieldsDTO;
		this.setActive(masterFieldsDTO.getActive());
		this.setEnabled(masterFieldsDTO.getEnabled());
		this.setEffectiveFrom(DateUtils.toString(masterFieldsDTO.getEffectiveFrom(),DATE_FORMAT));
		this.setEffectiveTill(DateUtils.toString(masterFieldsDTO.getEffectiveTill(),DATE_FORMAT));
	}
	
	public void fillDTO(BaseFieldsDTO fieldsDTO){
		super.fillDTO(fieldsDTO);
		MasterFieldsDTO masterFieldsDTO = (MasterFieldsDTO)fieldsDTO;
		masterFieldsDTO.setActive(this.getActive());
		masterFieldsDTO.setEnabled(this.getEnabled());
		masterFieldsDTO.setEffectiveFrom(DateUtils.toDate(this.getEffectiveFrom(),DATE_FORMAT));
		masterFieldsDTO.setEffectiveTill(DateUtils.toDate(this.getEffectiveTill(),DATE_FORMAT));
	}
}
