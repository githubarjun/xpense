package com.xpense.master.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.xpense.commons.action.BaseOperationAction;
import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.commons.form.BaseForm;
import com.xpense.master.dto.UserDTO;
import com.xpense.master.service.UserService;
import com.xpense.master.service.impl.UserServiceImpl;

public class UserAction extends BaseOperationAction{

	
	public String getActionForward() {
		return "UserForm";
	}

	public BaseFieldsDTO getDTO() {
		return new UserDTO();
	}

	private UserService getUserService(){
		return new UserServiceImpl();
	}

	public void saveObject(BaseFieldsDTO baseFieldsDTO) throws Exception {
		UserService userService = getUserService();
		UserDTO userDTO = (UserDTO)baseFieldsDTO;
		if("0".equals(baseFieldsDTO.getId()) || "".equals(baseFieldsDTO.getId())
				|| baseFieldsDTO.getId() == null){
			userService.create(userDTO);
		}else{
			userService.update(userDTO);
		}
	}

	
	public ActionForward saveUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		BaseForm baseForm = (BaseForm)form;
		BaseFieldsDTO baseFieldsDTO = getDTO();
		baseForm.fillDTO(baseFieldsDTO);
		try{
			saveObject(baseFieldsDTO);
		}catch(Exception exception){
			ActionErrors actionErrors = new ActionErrors();
			ActionMessage message = new ActionMessage("error.user.exist");
			actionErrors.add(ActionErrors.GLOBAL_MESSAGE,message);
			saveErrors(request, actionErrors);
			
			return mapping.getInputForward();
		}

		return mapping.findForward("LoginPage");
		
	}
	@Override
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//super.unspecified(mapping, form, request, response);
		
		return mapping.findForward("success");
		
	}

	@Override
	public String getActionViewForward() {
		return "UserView";
	}

	@Override
	public BaseFieldsDTO getDtoById(String id) throws Exception {
		return null;
	}

	@Override
	public String getActionListingForward() {
		return null;
	}
	
}