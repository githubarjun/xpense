package com.xpense.master.action;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.xpense.commons.action.BaseOperationAction;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.master.form.UserGroupDtlsForm;
import com.xpense.master.form.UserGroupForm;

public class UserGroupDtlsAction extends BaseOperationAction{

	@Override
	public String getActionForward() {
		return "UserGroupDtlsForm";
	}

	@Override
	public BaseFieldsDTO getDTO() {
		return null;
	}

	@Override
	public void saveObject(BaseFieldsDTO baseFieldsDTO) throws Exception {
		
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserGroupDtlsForm dtlsForm = (UserGroupDtlsForm) form;
		
		UserGroupForm groupForm = (UserGroupForm) request.getSession().getAttribute("UserGroupForm");
		boolean canAdd = true;
		ActionErrors actionErrors = new ActionErrors();
		for(UserGroupDtlsForm groupDtlsForm : groupForm.getUserDtls()){
			if(groupDtlsForm.getName() != null && groupDtlsForm.getName().equals(dtlsForm.getName())){
				ActionMessage error = new ActionMessage("error.user.present");
				actionErrors.add(ActionMessages.GLOBAL_MESSAGE,error);
				saveErrors(request, actionErrors);
				canAdd = false;
			}
		}
		
		if(canAdd){
			UserGroupDtlsForm newForm = new UserGroupDtlsForm();
			newForm.setName(dtlsForm.getName());
			newForm.setActive(true);
			groupForm.getUserDtls().add(newForm);
		}
		
		dtlsForm.setName("");
		
		return mapping.findForward(getActionForward());
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserGroupDtlsForm dtlsForm = (UserGroupDtlsForm) form;
		String name = request.getParameter("name");
		UserGroupForm groupForm = (UserGroupForm) request.getSession().getAttribute("UserGroupForm");
		Set<UserGroupDtlsForm> newSet = new LinkedHashSet<UserGroupDtlsForm>();
		
		for(UserGroupDtlsForm looperDtlsForm : groupForm.getUserDtls()){
			
			if(name != null && !name.equals(looperDtlsForm.getName())){
				newSet.add(looperDtlsForm);
			}
		}
		groupForm.setUserDtls(newSet);
		
		dtlsForm.setName("");
		
		return mapping.findForward(getActionForward());
	}
	
	public ActionForward enabledisable(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserGroupDtlsForm dtlsForm = (UserGroupDtlsForm) form;
		String name = request.getParameter("name");
		UserGroupForm groupForm = (UserGroupForm) request.getSession().getAttribute("UserGroupForm");
		
		if(dtlsForm.getId() == null || "".equals(dtlsForm.getId())){
			
			ActionErrors actionErrors = new ActionErrors();
			ActionMessage message = new ActionMessage("error.usergroupdtls.changestatus", new Object[]{name});
			actionErrors.add(ActionErrors.GLOBAL_MESSAGE,message);
			saveErrors(request, actionErrors);
			
			return mapping.getInputForward();
			
		}else{
			for(UserGroupDtlsForm looperDtlsForm : groupForm.getUserDtls()){
				
				if(name != null && name.equals(looperDtlsForm.getName())){
					Boolean active = looperDtlsForm.getActive();
					if(active){
						looperDtlsForm.setActive(false);
					}else{
						looperDtlsForm.setActive(true);
					}
				}
			}
			
			dtlsForm.setName("");
		}
		
		
		return mapping.findForward(getActionForward());
	}

	@Override
	public String getActionViewForward() {
		return "UserGroupDtlsView";
	}

	@Override
	public BaseFieldsDTO getDtoById(String id) throws Exception {
		return null;
	}

	@Override
	public String getActionListingForward() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
