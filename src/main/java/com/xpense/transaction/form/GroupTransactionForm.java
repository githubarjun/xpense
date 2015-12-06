package com.xpense.transaction.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.commons.form.BaseForm;
import com.xpense.commons.form.MakerCheckerForm;
import com.xpense.transaction.dto.UserGroupEventDTO;
import com.xpense.transaction.dto.UserTransactionDtlsDTO;

public class GroupTransactionForm extends MakerCheckerForm{

	private static final long serialVersionUID = -5413397931370545854L;

	private String groupName;
	private String groupId;
	private String createrId;
	private String eventDate;
	private String eventDescription;
	private String eventAmount;
	private List<GroupTransactionPaymentDtlsForm> dtlsList = new ArrayList<GroupTransactionPaymentDtlsForm>();
	
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventAmount() {
		return eventAmount;
	}
	public void setEventAmount(String eventAmount) {
		this.eventAmount = eventAmount;
	}
	public List<GroupTransactionPaymentDtlsForm> getDtlsList() {
		return dtlsList;
	}
	public void setDtlsList(List<GroupTransactionPaymentDtlsForm> dtlsList) {
		this.dtlsList = dtlsList;
	}
	public void addList(GroupTransactionPaymentDtlsForm paymentDtlsForm){
		this.dtlsList.add(paymentDtlsForm);
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getCreaterId() {
		return createrId;
	}
	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public void fillForm(BaseFieldsDTO fieldsDTO) {
		super.fillForm(fieldsDTO);
		UserGroupEventDTO groupEventDTO = (UserGroupEventDTO)fieldsDTO; 
		this.setGroupId(groupEventDTO.getGroupId());
		this.setGroupName(groupEventDTO.getGroupName());
		this.setCreaterId(groupEventDTO.getCreaterId());
		this.setEventDate(this.formatDate(groupEventDTO.getEventCreatedOn(), BaseForm.DATE_FORMAT));
		this.setEventDescription(groupEventDTO.getEventDescription());
		this.setEventAmount(groupEventDTO.getTotalTransactionAmount()+"");
		
		if(groupEventDTO.getUserTransactionsDtls() != null && groupEventDTO.getUserTransactionsDtls().size() > 0){
			for(UserTransactionDtlsDTO transactionDtlsDTO : groupEventDTO.getUserTransactionsDtls()){
				GroupTransactionPaymentDtlsForm paymentDtlsForm = new GroupTransactionPaymentDtlsForm();
				paymentDtlsForm.fillForm(transactionDtlsDTO);
				this.addList(paymentDtlsForm);
			}
		}
	}

	@Override
	public void fillDTO(BaseFieldsDTO fieldsDTO) {
		super.fillDTO(fieldsDTO);
		UserGroupEventDTO groupEventDTO = (UserGroupEventDTO)fieldsDTO;
		groupEventDTO.setGroupId(this.getGroupId());
		groupEventDTO.setGroupName(this.getGroupName());
		groupEventDTO.setCreaterId(this.getCreaterId());
		groupEventDTO.setEventCreatedOn(this.parseDate(this.getEventDate(), BaseForm.DATE_FORMAT));
		groupEventDTO.setEventDescription(this.getEventDescription());

		if(this.getEventAmount() != null && !"".equals(this.getEventAmount())){
			groupEventDTO.setTotalTransactionAmount(Double.parseDouble(this.getEventAmount()));
		}else{
			groupEventDTO.setTotalTransactionAmount(0d);
		}
		
		if(this.getDtlsList() != null && this.getDtlsList().size() > 0){
			for(GroupTransactionPaymentDtlsForm paymentDtlsForm : this.getDtlsList()){
				UserTransactionDtlsDTO transactionDtlsDTO = new UserTransactionDtlsDTO();
				//transactionDtlsDTO.setUserGroupEvent(groupEventDTO);
				paymentDtlsForm.fillDTO(transactionDtlsDTO);
				groupEventDTO.addUserTransactionsDtls(transactionDtlsDTO);
			}
		}
	}
	@Override
	public void fillED(String mode) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors actionErrors = new ActionErrors();
		
		if("save".equals(request.getParameter("method"))){
			
			double totalPaymentAmt = 0d;
			double totalContriAmt = 0d;
			double eventAmount = 0d;
			try{
				eventAmount = Double.parseDouble(this.getEventAmount());
			}catch(Exception e){
				actionErrors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.amount",new Object[]{this.getEventAmount()}));
			}
			for(GroupTransactionPaymentDtlsForm paymentDtlsForm : dtlsList){
				
				try{
					if(paymentDtlsForm.getTxnsUserPayAmount() != null && !"".equals(paymentDtlsForm.getTxnsUserPayAmount())){
						totalPaymentAmt += Double.parseDouble(paymentDtlsForm.getTxnsUserPayAmount());
					}
				}catch(Exception e){
					actionErrors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.payamount",new Object[]{paymentDtlsForm.getTxnsUserPayAmount()}));
				}
				try{
					if(paymentDtlsForm.getTxnsUserContriAmount() != null && !"".equals(paymentDtlsForm.getTxnsUserContriAmount())){
						totalContriAmt += Double.parseDouble(paymentDtlsForm.getTxnsUserContriAmount());
					}
				}catch(Exception e){
					actionErrors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.contriamount",new Object[]{paymentDtlsForm.getTxnsUserContriAmount()}));
				}
			}
			
			if(eventAmount != totalPaymentAmt){
				actionErrors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.amount.mismatch"));
			}
			if(totalContriAmt != totalPaymentAmt){
				actionErrors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.payamount.mismatch"));
			}
			
		}
		System.out.println("actionErrors : "+actionErrors);
		return actionErrors;
	}
}
