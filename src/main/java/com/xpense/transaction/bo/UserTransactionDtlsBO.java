package com.xpense.transaction.bo;

import com.xpense.commons.bo.MakerCheckerFieldsBO;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.transaction.dto.UserTransactionDtlsDTO;

public class UserTransactionDtlsBO extends MakerCheckerFieldsBO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4088170355967554890L;
	
	private Long groupUserId;
	private Double paidAmount;
	private Double contributionAmount;
	private Double differenceAmount;
	
	public UserTransactionDtlsBO() {
		super();
	}

	public Double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Double getContributionAmount() {
		return contributionAmount;
	}
	public void setContributionAmount(Double contributionAmount) {
		this.contributionAmount = contributionAmount;
	}

	public Long getGroupUserId() {
		return groupUserId;
	}

	public void setGroupUserId(Long groupUserId) {
		this.groupUserId = groupUserId;
	}

	public Double getDifferenceAmount() {
		return differenceAmount;
	}

	public void setDifferenceAmount(Double differenceAmount) {
		this.differenceAmount = differenceAmount;
	}

	@Override
	protected BaseFieldsDTO createDTO() {
		return new UserTransactionDtlsDTO();
	}
	
}
