package com.xpense.commons.form;

import java.util.Date;

import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.commons.dto.MakerCheckerFieldsDTO;

public abstract class MakerCheckerForm extends BaseForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7698283505787110586L;
	private String lastStatus;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;

	public MakerCheckerForm() {
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
	
	public void fillForm(BaseFieldsDTO fieldsDTO){
		super.fillForm(fieldsDTO);
		MakerCheckerFieldsDTO checkerFieldsDTO = (MakerCheckerFieldsDTO)fieldsDTO;
		this.setLastStatus(checkerFieldsDTO.getLastStatus());
		this.setCreatedBy(checkerFieldsDTO.getCreatedBy());
		this.setCreatedDate(checkerFieldsDTO.getCreatedDate());
		this.setModifiedBy(checkerFieldsDTO.getModifiedBy());
		this.setModifiedDate(checkerFieldsDTO.getModifiedDate());
	}
	
	public void fillDTO(BaseFieldsDTO fieldsDTO){
		super.fillDTO(fieldsDTO);
		MakerCheckerFieldsDTO checkerFieldsDTO = (MakerCheckerFieldsDTO)fieldsDTO;
		checkerFieldsDTO.setLastStatus(this.getLastStatus());
		checkerFieldsDTO.setCreatedBy(this.createdBy);
		checkerFieldsDTO.setCreatedDate(this.createdDate);
		checkerFieldsDTO.setModifiedBy(this.getModifiedBy());
		checkerFieldsDTO.setModifiedDate(this.getModifiedDate());
	}
	
}
