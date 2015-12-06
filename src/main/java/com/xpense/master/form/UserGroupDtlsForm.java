package com.xpense.master.form;

import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.commons.form.MasterForm;
import com.xpense.master.dto.UserGroupDtlsDTO;

public class UserGroupDtlsForm extends MasterForm{

	private static final long serialVersionUID = -7938144925459555819L;
	private String name;
	private Long userId;

	public UserGroupDtlsForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Override
	public void fillDTO(BaseFieldsDTO fieldsDTO) {
		super.fillDTO(fieldsDTO);
		UserGroupDtlsDTO dtlsDTO = (UserGroupDtlsDTO)fieldsDTO;
		dtlsDTO.setName(this.getName());
		dtlsDTO.setUserId(getUserId());
	}
	
	
	@Override
	public void fillForm(BaseFieldsDTO fieldsDTO) {
		super.fillForm(fieldsDTO);
		UserGroupDtlsDTO dtlsDTO = (UserGroupDtlsDTO)fieldsDTO;
		this.setName(dtlsDTO.getName());
		this.setUserId(dtlsDTO.getUserId());
	}

	@Override
	public void fillED(String mode) {
		// TODO Auto-generated method stub
		
	}
}
