package com.xpense.master.form;

import java.util.LinkedHashSet;
import java.util.Set;

import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.commons.form.MasterForm;
import com.xpense.master.dto.UserDTO;
import com.xpense.master.dto.UserGroupDTO;
import com.xpense.master.dto.UserGroupDtlsDTO;

public class UserGroupForm extends MasterForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 607839672287980960L;
	private String groupCode;
	private String groupCodeED = "false";
	private String groupName;
	private String groupNameED = "false";
	private Long noOfUsers;
	private String noOfUsersED = "false";
	
	//private UserForm creator;
	private String userId;
	
	private Set<UserGroupDtlsForm> userDtls = new LinkedHashSet<UserGroupDtlsForm>();
	
	public UserGroupForm() {
		super();
	}

	public UserGroupDTO createDTO(){
		return new UserGroupDTO();
	}
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Long getNoOfUsers() {
		return noOfUsers;
	}
	public void setNoOfUsers(Long noOfUsers) {
		this.noOfUsers = noOfUsers;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public Set<UserGroupDtlsForm> getUserDtls() {
		return userDtls;
	}
	public void setUserDtls(Set<UserGroupDtlsForm> userDtls) {
		this.userDtls = userDtls;
	}

	public String getGroupCodeED() {
		return groupCodeED;
	}

	public void setGroupCodeED(String groupCodeED) {
		this.groupCodeED = groupCodeED;
	}

	public String getGroupNameED() {
		return groupNameED;
	}

	public void setGroupNameED(String groupNameED) {
		this.groupNameED = groupNameED;
	}

	public String getNoOfUsersED() {
		return noOfUsersED;
	}

	public void setNoOfUsersED(String noOfUsersED) {
		this.noOfUsersED = noOfUsersED;
	}

	public void fillForm(BaseFieldsDTO dto){
		super.fillForm(dto);
		UserGroupDTO userGroupDTO = (UserGroupDTO)dto;
		this.setGroupCode(userGroupDTO.getGroupCode());
		this.setGroupName(userGroupDTO.getGroupName());
		this.setNoOfUsers(userGroupDTO.getNoOfUsers());
		this.setUserId(userGroupDTO.getUserId());
	
		for(UserGroupDtlsDTO dtlsDTO : userGroupDTO.getGroupDtls()){
			UserGroupDtlsForm dtlsForm = new UserGroupDtlsForm();
			dtlsForm.fillForm(dtlsDTO);
			userDtls.add(dtlsForm);
		}
		
	}
	
	public void fillDTO(BaseFieldsDTO dto){
		super.fillDTO(dto);
		UserGroupDTO userGroupDTO = (UserGroupDTO)dto;
		userGroupDTO.setGroupCode(this.getGroupCode());
		userGroupDTO.setGroupName(this.getGroupName());
		userGroupDTO.setNoOfUsers(this.getNoOfUsers());

		for(UserGroupDtlsForm dtlsForm : this.getUserDtls()){
			UserGroupDtlsDTO dtlsDTO = new UserGroupDtlsDTO();
			dtlsForm.fillDTO(dtlsDTO);
			userGroupDTO.getGroupDtls().add(dtlsDTO);
		}
	}

	@Override
	public void fillED(String mode) {
		if("add".equals(mode)){
			groupCodeED = "false";
			groupNameED = "false";
			noOfUsersED = "false";
		}else if("edit".equals(mode)){
			groupCodeED = "true";
			groupNameED = "true";
			//noOfUsersED = "true";
		}
	}
	
}
