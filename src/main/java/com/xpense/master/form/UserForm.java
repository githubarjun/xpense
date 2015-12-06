package com.xpense.master.form;

import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.commons.form.BaseForm;
import com.xpense.master.dto.UserDTO;

public class UserForm extends BaseForm{

	private static final long serialVersionUID = -6742419337185482470L;
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void fillForm(BaseFieldsDTO fieldsDTO) {
		super.fillForm(fieldsDTO);
		UserDTO userDTO = (UserDTO)fieldsDTO;
		this.setUserName(userDTO.getUserName());
		this.setPassword(userDTO.getPassword());
	}
	
	@Override
	public void fillDTO(BaseFieldsDTO fieldsDTO) {
		super.fillDTO(fieldsDTO);
		UserDTO userDTO = (UserDTO)fieldsDTO;
		userDTO.setUserName(this.getUserName());
		userDTO.setPassword(this.getPassword());
	}

	@Override
	public void fillED(String mode) {
		// TODO Auto-generated method stub
		
	}
}
