package com.xpense.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.xpense.commons.action.BaseDispatchAction;
import com.xpense.login.Ticket;
import com.xpense.login.form.LoginForm;
import com.xpense.login.service.LoginService;
import com.xpense.login.service.impl.LoginServiceImpl;

public class LoginAction extends BaseDispatchAction{

	LoginService loginService;
	
	private LoginService getLoginService(){
		return new LoginServiceImpl();
	}
	
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		LoginForm loginForm = (LoginForm)form;
		String userName = loginForm.getUserName();
		String password = loginForm.getPassword();
		
		loginService = getLoginService();
		try{
			
			Ticket ticket = loginService.authenticateUser(userName, password);
			
			if(ticket != null){

				request.getSession().invalidate();
				request.getSession(true);
				request.getSession().setMaxInactiveInterval(600);
				request.getSession().setAttribute("Ticket", ticket);
				
				return mapping.findForward("MainMenu");
			}else{
				
				ActionErrors actionErrors = new ActionErrors();
				ActionMessage message = new ActionMessage("error.invalid.login");
				actionErrors.add(ActionErrors.GLOBAL_MESSAGE,message);
				saveErrors(request, actionErrors);
				
				return mapping.getInputForward();
			}
			
		}catch(Exception exception){

			//TODO
			//log exception here as well
			
			ActionErrors actionErrors = new ActionErrors();
			ActionMessage message = new ActionMessage("error.login");
			actionErrors.add(ActionErrors.GLOBAL_MESSAGE,message);
			saveErrors(request, actionErrors);
			
			return mapping.getInputForward();
			
		}
	}
	
	public ActionForward loginPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Ticket ticket = (Ticket)request.getSession().getAttribute("Ticket");
		
		if(ticket != null){
			return mapping.findForward("MainMenu");
		}else{
			return mapping.findForward("LoginPage");
		}
		
	}
	
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.getSession().removeAttribute("Ticket");
		
		return mapping.findForward("Logout");
		
	}
	
	public ActionForward newUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("NewUser");
	}
	
}
