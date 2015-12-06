package com.xpense.commons.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.xpense.login.Ticket;

public abstract class BaseDispatchAction extends DispatchAction{

	
	private ThreadLocal<Ticket> ticketThreadLocal = new ThreadLocal<Ticket>();
	
	public void setTicket(HttpSession session){
		Ticket ticket = (Ticket) session.getAttribute("Ticket");
		ticketThreadLocal.set(ticket);
	}
	
	public Ticket getTicket(){
		return ticketThreadLocal.get();
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getParameter("method");
		
		if(!("loginPage".equals(method) || "login".equals(method) 
				|| "logout".equals(method) || "newUser".equals(method)
				|| "saveUser".equals(method)) 
				&& !checkTicket(request)){
			
			response.sendError(500,"Session Expired.");
		}
		
		setTicket(request.getSession());
		return super.execute(mapping, form, request, response);
	}
	
	private boolean checkTicket(HttpServletRequest request) {
		boolean flag = false;
		Ticket ticket = (Ticket) request.getSession().getAttribute("Ticket");
		if(ticket != null){
			flag = true;
		}
		return flag;
	}

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		return super.unspecified(mapping, form, request, response);
	}
	
	protected boolean checkIfNoElement(List<? extends Object> objects){
		
		if(objects != null && objects.size() > 0){
			return false;
		}else{
			return true;
		}
		
	}
	
}
