package com.xpense.commons.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xpense.commons.dto.BaseFieldsDTO;
import com.xpense.commons.form.BaseForm;

public abstract class BaseOperationAction extends BaseDispatchAction{
	
	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BaseForm baseForm = (BaseForm)form;
		BaseFieldsDTO baseFieldsDTO = null;
		String actionPath = null;
		String mode = request.getParameter("mode");
		if(mode == null){
			mode = "add";
		}
		
		baseForm.fillED(mode);
		
		String id = request.getParameter("id");
		if(id != null){
			baseFieldsDTO = getDtoById(id);
			if(baseFieldsDTO != null){
				baseForm.fillForm(baseFieldsDTO);
			}
		}
		
		if("add".equals(mode) || "edit".equals(mode)){
			actionPath = getActionForward();
		}else if("view".equals(mode)){
			actionPath = getActionViewForward();
		}
		
		return mapping.findForward(actionPath);
	}
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BaseForm baseForm = (BaseForm)form;
		BaseFieldsDTO baseFieldsDTO = getDTO();
		baseForm.fillDTO(baseFieldsDTO);
		saveObject(baseFieldsDTO);
		return mapping.findForward(getActionListingForward());
	}
	
	public abstract BaseFieldsDTO getDTO();
	public abstract void saveObject(BaseFieldsDTO baseFieldsDTO)throws Exception;
	public abstract BaseFieldsDTO getDtoById(String id)throws Exception;
	public abstract String getActionForward();
	public abstract String getActionViewForward();
	public abstract String getActionListingForward();
	
}
