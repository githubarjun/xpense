package com.xpense.commons.bo;

import java.io.Serializable;

import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.utils.BODTOFiller;

public abstract class BaseFieldsBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -366835200423206686L;
	private Long id;
	private Integer version;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public final BaseFieldsDTO toDTO() {
		BaseFieldsDTO dto = createDTO();
		BODTOFiller.fillDTO(dto, this);
		return dto;
	}
	
	protected abstract BaseFieldsDTO createDTO();


}
