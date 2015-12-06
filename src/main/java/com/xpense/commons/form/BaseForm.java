package com.xpense.commons.form;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts.action.ActionForm;

import com.xpense.commons.dto.BaseFieldsDTO;

public abstract class BaseForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1136210308231046340L;
	private String id;
	private Integer version;
	
	public static final String DATE_FORMAT = "dd-MMM-yyyy";
	public DateFormat dateFormat;
	
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
	
	public void fillForm(BaseFieldsDTO fieldsDTO){
		this.setId(fieldsDTO.getId());
		this.setVersion(fieldsDTO.getVersion());
	}
	
	public void fillDTO(BaseFieldsDTO fieldsDTO){
		fieldsDTO.setId(this.getId());
		fieldsDTO.setVersion(this.getVersion());
	}
	
	public String formatDate(Date date,String format){
		String strDate = null;
		if(dateFormat == null){
			dateFormat = new SimpleDateFormat(format);
		}
		if(date != null){
			strDate = dateFormat.format(date);
			return strDate;
		}else{
			return null;
		}
	}
	
	public Date parseDate(String strDate,String format){
		Date date = null;
		if(dateFormat == null){
			dateFormat = new SimpleDateFormat(format);
		}
		if(strDate != null){
			try {
				date = dateFormat.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		}else{
			return null;
		}
	}
	
	
	public abstract void fillED(String mode);
}
