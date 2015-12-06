package com.xpense.transaction.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xpense.commons.action.BaseTransactionAction;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.login.Ticket;
import com.xpense.master.dto.UserGroupDTO;
import com.xpense.master.dto.UserGroupDtlsDTO;
import com.xpense.master.service.UserGroupService;
import com.xpense.master.service.impl.UserGroupServiceImpl;
import com.xpense.transaction.dto.UserGroupEventDTO;
import com.xpense.transaction.form.GroupTransactionForm;
import com.xpense.transaction.form.GroupTransactionPaymentDtlsForm;
import com.xpense.transaction.service.GroupTransactionService;
import com.xpense.transaction.service.impl.GroupTransactionServiceImpl;

public class GroupTransactionAction extends BaseTransactionAction{

	public UserGroupService getUserGroupService(){
		return new UserGroupServiceImpl();
	}
	
	public GroupTransactionService getGroupTransactionService(){
		return new GroupTransactionServiceImpl();
	}
	
	public String getActionForward() {
		return "GroupTransactionForm";
	}

	public BaseFieldsDTO getDTO() {
		return new UserGroupEventDTO();
	}

	public void saveObject(BaseFieldsDTO baseFieldsDTO) throws Exception {
		GroupTransactionService transactionService = getGroupTransactionService();
		UserGroupEventDTO eventDTO = (UserGroupEventDTO) baseFieldsDTO;
		Ticket ticket = getTicket();
		eventDTO.setCreaterId(ticket.getUserId()+"");
		if(baseFieldsDTO.getId() == null || "".equals(baseFieldsDTO.getId())){
			transactionService.create(eventDTO);
		}else{
			transactionService.update(eventDTO);
		}
	}
	
	@Override
	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		GroupTransactionForm transactionForm = (GroupTransactionForm)form;
		transactionForm.getDtlsList().clear();

		ActionForward forward = super.show(mapping, form, request, response);
		
		Ticket ticket = getTicket();
		if(ticket == null){
			throw new Exception("Security breach");
		}
		
		String mode = request.getParameter("mode");
		if(mode == null || "add".equals(mode)){
			String groupId = (String) request.getSession().getAttribute("GroupId");
			if(groupId != null){
				UserGroupService userGroupService = getUserGroupService();
				UserGroupDTO groupDto = userGroupService.findById(groupId);
				transactionForm.setGroupId(groupDto.getId());
				transactionForm.setGroupName(groupDto.getGroupName());
				
				for(UserGroupDtlsDTO dtlsDTO : groupDto.getGroupDtls()){
					GroupTransactionPaymentDtlsForm dtlsForm = new GroupTransactionPaymentDtlsForm();
					dtlsForm.setTxnsUserId(dtlsDTO.getId());
					dtlsForm.setTxnsUserName(dtlsDTO.getName());
					dtlsForm.setIsTranUser(dtlsDTO.getActive());
					transactionForm.getDtlsList().add(dtlsForm);
				}
			}
		}
		Map<String,String> userNameMap = new HashMap<String, String>();
		Map<String,Boolean> userActiveMap = new HashMap<String, Boolean>();
		if("edit".equals(mode) || "view".equals(mode)){
			String groupId = (String) request.getSession().getAttribute("GroupId");
			if(groupId != null){
				UserGroupService userGroupService = getUserGroupService();
				UserGroupDTO groupDto = userGroupService.findById(groupId);
				
				for(UserGroupDtlsDTO dtlsDTO : groupDto.getGroupDtls()){
					userNameMap.put(dtlsDTO.getId(), dtlsDTO.getName());
					userActiveMap.put(dtlsDTO.getId(), dtlsDTO.getActive());
				}
				
				for(GroupTransactionPaymentDtlsForm dtlsForm : transactionForm.getDtlsList()){
					dtlsForm.setTxnsUserName(userNameMap.get(dtlsForm.getTxnsUserId()));
					dtlsForm.setIsTranUser(userActiveMap.get(dtlsForm.getTxnsUserId()));
				}
			
			}
			
		}
		
		return forward;
	}

	@Override
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		GroupTransactionForm transactionForm = (GroupTransactionForm)form;
		
		ActionForward forward = super.save(mapping, form, request, response);
		
		String id = transactionForm.getGroupId();
		request.getSession().setAttribute("parentId", id);
		
		return forward;
	}
	
	
	@Override
	public String getActionViewForward() {
		return "GroupTransactionView";
	}

	@Override
	public BaseFieldsDTO getDtoById(String id) throws Exception {
		
		GroupTransactionService transactionService;
		UserGroupEventDTO groupEventDTO = null;
		try{
			transactionService = getGroupTransactionService();
			groupEventDTO = transactionService.findById(id);
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return groupEventDTO;
	}

	
	
	@Override
	public String getActionListingForward() {
		return "GroupTransactionList";
	}

}
