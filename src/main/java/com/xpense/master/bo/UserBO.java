package com.xpense.master.bo;

import java.sql.Blob;
import java.util.LinkedHashSet;
import java.util.Set;

import com.xpense.commons.bo.MasterFieldsBO;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.master.dto.UserDTO;

public class UserBO extends MasterFieldsBO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1257466736087875877L;
	private String userName;
	private String password;
	private Blob userImage;
	private Set<UserGroupBO> userGroups = new LinkedHashSet<UserGroupBO>();
	
	//private UserGroupBO userGroupBO;
	//private UserRestrictionBO userRestriction;
	//private UserAccountBO userAccount;
	
	
	public UserBO() {
		super();
		//this.userRestriction = new UserRestrictionBO(this,true,true);
		//this.userAccount = new UserAccountBO(this,new Double(0),new Double(0));
	}

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

	public Blob getUserImage() {
		return userImage;
	}

	public void setUserImage(Blob userImage) {
		this.userImage = userImage;
	}

	public Set<UserGroupBO> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(Set<UserGroupBO> userGroups) {
		this.userGroups = userGroups;
	}

	@Override
	protected BaseFieldsDTO createDTO() {
		// TODO Auto-generated method stub
		return new UserDTO();
	}


/*	public UserRestrictionBO getUserRestriction() {
		return userRestriction;
	}

	public void setUserRestriction(UserRestrictionBO userRestriction) {
		this.userRestriction = userRestriction;
	}
*/
	/*public UserAccountBO getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccountBO userAccount) {
		this.userAccount = userAccount;
	}*/
	
	
}
