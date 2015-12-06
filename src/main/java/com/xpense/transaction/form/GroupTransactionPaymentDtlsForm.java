package com.xpense.transaction.form;

import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.commons.form.MakerCheckerForm;
import com.xpense.transaction.dto.UserTransactionDtlsDTO;

public class GroupTransactionPaymentDtlsForm extends MakerCheckerForm{

	private static final long serialVersionUID = 4524879346943133297L;

	private String txnsUserId;
	private String txnsUserName;
	private String txnsUserPayAmount;
	private String txnsUserContriAmount;
	private Boolean isTranUser;

	public String getTxnsUserId() {
		return txnsUserId;
	}
	public void setTxnsUserId(String txnsUserId) {
		this.txnsUserId = txnsUserId;
	}
	public String getTxnsUserName() {
		return txnsUserName;
	}
	public void setTxnsUserName(String txnsUserName) {
		this.txnsUserName = txnsUserName;
	}
	public String getTxnsUserPayAmount() {
		return txnsUserPayAmount;
	}
	public void setTxnsUserPayAmount(String txnsUserPayAmount) {
		this.txnsUserPayAmount = txnsUserPayAmount;
	}
	public String getTxnsUserContriAmount() {
		return txnsUserContriAmount;
	}
	public void setTxnsUserContriAmount(String txnsUserContriAmount) {
		this.txnsUserContriAmount = txnsUserContriAmount;
	}
	public Boolean getIsTranUser() {
		return isTranUser;
	}
	public void setIsTranUser(Boolean isTranUser) {
		this.isTranUser = isTranUser;
	}

	@Override
	public void fillForm(BaseFieldsDTO fieldsDTO) {
		super.fillForm(fieldsDTO);
		UserTransactionDtlsDTO transactionDtlsDTO = (UserTransactionDtlsDTO)fieldsDTO;
		this.setTxnsUserId(transactionDtlsDTO.getGroupUserId());
		//this.setTxnsUserName(transactionDtlsDTO.get);
		this.setTxnsUserPayAmount(transactionDtlsDTO.getPaidAmount()+"");
		this.setTxnsUserContriAmount(transactionDtlsDTO.getContributionAmount()+"");
		//this.setIsTranUser(isTranUser);
		
	}
	
	@Override
	public void fillDTO(BaseFieldsDTO fieldsDTO) {
		super.fillDTO(fieldsDTO);
		UserTransactionDtlsDTO transactionDtlsDTO = (UserTransactionDtlsDTO)fieldsDTO;
		
		transactionDtlsDTO.setGroupUserId(this.getTxnsUserId());
		if(this.getTxnsUserPayAmount() != null && !"".equals(this.getTxnsUserPayAmount())){
			transactionDtlsDTO.setPaidAmount(Double.parseDouble(this.getTxnsUserPayAmount()));
		}else{
			transactionDtlsDTO.setPaidAmount(0d);
		}
		if(this.getTxnsUserContriAmount() != null && !"".equals(this.getTxnsUserContriAmount())){
			transactionDtlsDTO.setContributionAmount(Double.parseDouble(this.getTxnsUserContriAmount()));
		}else{
			transactionDtlsDTO.setContributionAmount(0d);
		}
		
	}
	@Override
	public void fillED(String mode) {
		// TODO Auto-generated method stub
		
	}
	
	
}
