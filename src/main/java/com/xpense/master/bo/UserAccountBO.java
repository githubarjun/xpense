package com.xpense.master.bo;

import com.xpense.commons.bo.MasterFieldsBO;
import com.xpense.commons.dto.BaseFieldsDTO;

public class UserAccountBO extends MasterFieldsBO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3814112525319339451L;
	private UserBO user;
	private Double totalPayableAmount;
	private Double totaReceivableAmount;
	
	public UserAccountBO() {
		super();
	}
	
	public UserAccountBO(UserBO user, Double totalPayableAmount,
			Double totaReceivableAmount) {
		super();
		this.user = user;
		this.totalPayableAmount = totalPayableAmount;
		this.totaReceivableAmount = totaReceivableAmount;
	}

	public UserBO getUser() {
		return user;
	}
	public void setUser(UserBO user) {
		this.user = user;
	}
	public Double getTotalPayableAmount() {
		return totalPayableAmount;
	}
	public void setTotalPayableAmount(Double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}
	public Double getTotaReceivableAmount() {
		return totaReceivableAmount;
	}
	public void setTotaReceivableAmount(Double totaReceivableAmount) {
		this.totaReceivableAmount = totaReceivableAmount;
	}

	@Override
	protected BaseFieldsDTO createDTO() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
