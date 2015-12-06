package com.xpense.report.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xpense.commons.action.BaseOperationAction;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.login.Ticket;
import com.xpense.master.dto.UserGroupDTO;
import com.xpense.master.dto.UserGroupDtlsDTO;
import com.xpense.master.service.UserGroupService;
import com.xpense.master.service.impl.UserGroupServiceImpl;
import com.xpense.report.form.SpendingReportData;
import com.xpense.report.form.SpendingReportForm;
import com.xpense.report.service.ReportService;
import com.xpense.report.service.impl.ReportServiceImpl;
import com.xpense.transaction.dto.UserGroupEventDTO;
import com.xpense.transaction.dto.UserTransactionDtlsDTO;

public class SpendingReportAction extends BaseOperationAction{

	@Override
	public BaseFieldsDTO getDTO() {
		return null;
	}

	@Override
	public void saveObject(BaseFieldsDTO baseFieldsDTO) throws Exception {
	}

	@Override
	public BaseFieldsDTO getDtoById(String id) throws Exception {
		return null;
	}

	@Override
	public String getActionForward() {
		return "SpendingReportForm";
	}

	@Override
	public String getActionViewForward() {
		return null;
	}

	@Override
	public String getActionListingForward() {
		return null;
	}
	
	private UserGroupService getUserGroupService(){
		return new UserGroupServiceImpl();
	}

	@Override
	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		SpendingReportForm reportForm = (SpendingReportForm)form;
		
		ActionForward forward = super.show(mapping, form, request, response);

		UserGroupService service = getUserGroupService();
		
		Ticket ticket = (Ticket) request.getSession().getAttribute("Ticket");
		String spec = " userid = '"+ticket.getUserId()+"'";
		
		List<UserGroupDTO> userGroupDtos = service.findAllAuthorized(spec);
		reportForm.setGroupDTOs(userGroupDtos);
		
		return forward;
	}
	
	private ReportService getReportService(){
		return new ReportServiceImpl();
	}
	
	public ActionForward getReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		SpendingReportForm reportForm = (SpendingReportForm)form;
		
		SpendingReportData reportData = new SpendingReportData();
		
		Map<String,Double> summary = new LinkedHashMap<String, Double>();
		
		UserGroupService userGroupService = getUserGroupService();
		UserGroupDTO userGroupDTO = userGroupService.findById(reportForm.getGroup());
		List<UserGroupDTO> userGroupDtos = userGroupService.findAllAuthorized("");

		Map<String,String> headerMap = new LinkedHashMap<String, String>();
		for(UserGroupDtlsDTO dtlsDTO : userGroupDTO.getGroupDtls()){
			headerMap.put(dtlsDTO.getId(), dtlsDTO.getName());
		}
		reportData.setHeaders(headerMap);
		
		ReportService reportService = getReportService();
		List<UserGroupEventDTO> eventDtos = reportService.getSpendingReport(reportForm.getGroup());
		for(UserGroupEventDTO eventDTO : eventDtos){
			
			Set<UserTransactionDtlsDTO> userTransactionsDtls = eventDTO.getUserTransactionsDtls();

			List<String> event = new ArrayList<String>();
			event.add(eventDTO.getEventCreatedOn().toString());
			event.add(eventDTO.getEventDescription());
			event.add(eventDTO.getTotalTransactionAmount()+"");
			
			Map<String, UserTransactionDtlsDTO> dtlsMap = new LinkedHashMap<String, UserTransactionDtlsDTO>();
			for(UserTransactionDtlsDTO dto : userTransactionsDtls){
				
				dtlsMap.put(dto.getGroupUserId(), dto);
				
				if(summary.containsKey(headerMap.get(dto.getGroupUserId()))){
					Double val = summary.get(headerMap.get(dto.getGroupUserId()));
					summary.put(headerMap.get(dto.getGroupUserId()), val+dto.getPaidAmount());
				}else{
					summary.put(headerMap.get(dto.getGroupUserId()), dto.getPaidAmount());
				}
				
			}
			
			for(String groupUserId : headerMap.keySet()){
				UserTransactionDtlsDTO dtlsDTO = dtlsMap.get(groupUserId);
				if(dtlsDTO != null){
					event.add(dtlsDTO.getPaidAmount()+"");
				}else{
					event.add("NA");
				}
			}
			
			reportData.getDataDtls().add(event);
			
		}
		
		reportData.setSummary(summary);
		
		reportForm.setGroupDTOs(userGroupDtos);
		reportForm.setReportData(reportData);
		
		return mapping.findForward("SpendingReportForm");
		
	}
	
}
