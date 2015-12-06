package com.xpense.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xpense.commons.action.BaseDispatchAction;

public class MenuAction extends BaseDispatchAction{

	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return mapping.findForward("MainMenu");

	}
}
