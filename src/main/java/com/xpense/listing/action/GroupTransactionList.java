package com.xpense.listing.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xpense.commons.action.BaseListAction;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.transaction.dto.UserGroupEventDTO;
import com.xpense.transaction.service.GroupTransactionService;
import com.xpense.transaction.service.impl.GroupTransactionServiceImpl;

public class GroupTransactionList extends BaseListAction{

	private String[] pageHeaders = new String[]{"Group Name","Description","Date","Amount"};
	private String[] propertyNames = new String[]{"GroupName","EventDescription","EventCreatedOn","TotalTransactionAmount"};

	@Override
	public String getAction() {
		return "/groupTransaction";
	}

	@Override
	public String getActionForward() {
		return null;
	}

	@Override
	public String getHyperlinkColumn() {
		return null;
	}

	@Override
	public List<String> getListHeaders() {
		ArrayList<String> list = new ArrayList<String>();
		for(String s : pageHeaders){
			list.add(s);
		}
		return list;
	}

	@Override
	public List<? extends BaseFieldsDTO> getListingData(String spec) throws Exception {
		
		List<UserGroupEventDTO> eventDTOs = null;
		GroupTransactionService transactionService = getGroupTransactionService();
		try{
			eventDTOs = transactionService.findAllAuthorized(spec);
		}catch(Exception e){
			e.printStackTrace();
		}
		return eventDTOs;
	}

	@Override
	protected List<? extends BaseFieldsDTO> prepareListdata(
			HttpServletRequest request) throws Exception {
		
		String parentId = null;
		parentId = request.getParameter("parentId");
		if(parentId == null){
			parentId = (String) request.getSession().getAttribute("parentId");
		}
		return getListingData("groupId = "+parentId);
	}
	
	
	private GroupTransactionService getGroupTransactionService() {
		return new GroupTransactionServiceImpl();
	}

	@Override
	public String getPrefix() {
		return "/jsp/xpense";
	}

	@Override
	public List<String> getPropertyNames() {
		return Arrays.asList(propertyNames);
	}

	@Override
	public List<String> getSortableHeaders() {
		return null;
	}

	@Override
	public void manipulateSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String groupId = request.getParameter("parentId");
		if(groupId == null){
			groupId = (String)request.getAttribute("parentId");
		}
		session.setAttribute("GroupId", groupId);
		
		if(session.getAttribute("GroupTransactionForm") != null){
			session.removeAttribute("GroupTransactionForm");
		}
	}

	@Override
	public String getModule() {
		return "Group Event";
	}

	@Override
	public String getInstructions() {
		return "This is a listing screen for Group Event";
	}

	@Override
	public String getInstructionsParent(String childAction) {
		return null;
	}

}
