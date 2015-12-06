package com.xpense.listing.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xpense.commons.action.BaseListAction;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.login.Ticket;
import com.xpense.master.dto.UserGroupDTO;
import com.xpense.master.service.UserGroupService;
import com.xpense.master.service.impl.UserGroupServiceImpl;

public class UserGroupList extends BaseListAction{

	private String[] pageHeaders = new String[]{"Group Code","Group Name","No Of Users"}; 
	private String[] propertyNames = new String[]{"GroupCode","GroupName","NoOfUsers"};
		
	private UserGroupService getUserGroupService(){
		return new UserGroupServiceImpl();
	}
	
	@Override
	public String getAction() {
		return "/userGroup";
	}

	@Override
	public String getActionForward() {
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
		
		UserGroupService service = getUserGroupService();
		List<UserGroupDTO> list = null;
		try {
			list = service.findAllAuthorized(spec);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	@Override
	public String getPrefix() {
		return "/jsp/master";
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
		if(session.getAttribute("UserGroupForm") != null){
			session.removeAttribute("UserGroupForm");
		}
	}

	@Override
	public String getHyperlinkColumn() {
		return propertyNames[0];
	}

	@Override
	public String getModule() {
		return "Group";
	}

	@Override
	public String getInstructions() {
		return "This is a Listing screen for Group Creation and Modification";
	}

	@Override
	public String getInstructionsParent(String childAction) {
		return "Click on any group below to proceed";
	}

	protected List<? extends BaseFieldsDTO> prepareListdata(HttpServletRequest request) throws Exception{
		
		Ticket ticket = (Ticket) request.getSession().getAttribute("Ticket");
		String spec = " userid = '"+ticket.getUserId()+"'";
		return getListingData(spec);
	}
}
