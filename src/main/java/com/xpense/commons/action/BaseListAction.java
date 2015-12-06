package com.xpense.commons.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xpense.commons.dto.BaseFieldsDTO;

public abstract class BaseListAction extends BaseDispatchAction{

	private ThreadLocal<Boolean> isParentList = new ThreadLocal<Boolean>();

	public abstract List<? extends BaseFieldsDTO> getListingData(String specification)throws Exception;
	public abstract List<String> getListHeaders();
	public abstract List<String> getSortableHeaders();
	//used for parent listings
	public abstract String getHyperlinkColumn();
	public abstract List<String> getPropertyNames();
	public abstract String getPrefix();
	public abstract String getAction();
	public abstract String getActionForward();
	public abstract void manipulateSession(HttpServletRequest request);
	public abstract String getModule();
	public abstract String getInstructions();
	public abstract String getInstructionsParent(String childAction);
	
	public String getViewLink(String id){
		String url = "./toModule.do?prefix="+getPrefix()+"&page="+getAction()+".do&method=show&mode=view&id="+id;
		String viewLink="<a class='listlink' href='"+url+"'>View</a>";
		return viewLink;
	}
	
	public String getEditLink(String id){
		String url = "./toModule.do?prefix="+getPrefix()+"&page="+getAction()+".do&method=show&mode=edit&id="+id;
		String editLink="<a class='listlink' href='"+url+"'>Edit</a>";
		return editLink;
	}
	
	public String getEnableLink(){
		return "";
	}
	
	public String getDisableLink(){
		return "";
	}
	
	public String getPageLinks(String id){
		StringBuilder links = new StringBuilder();
		links.append(getViewLink(id));
		links.append("/");
		links.append(getEditLink(id));
		return links.toString();
	}
	
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ListDataHolder holder = new ListDataHolder();
		holder.setDtos(prepareListdata(request));
		holder.setPropertyNames(getPropertyNames());
		List<String> listHeaders = getListHeaders();
		listHeaders.add("Links");
		holder.setPageHeaders(listHeaders);
		holder.setPrefix(getPrefix());
		holder.setAction(getAction());
		holder.setActionForward(getActionForward());
		holder.setAddNewVisible(true);
		
		validateData(holder);
		
		manipulateSession(request);
		
		List<List<String>> pageData = convertToColumns(holder.getDtos(), holder.getPropertyNames(),null);

		holder.setPageData(pageData);
		holder.setCount(pageData.size()+"");
		holder.setHeaderCount(holder.getPageHeaders().size());
		
		holder.setModule(getModule());
		holder.setInstructions(getInstructions());
		
		request.setAttribute("holder", holder);
		
		/*request.setAttribute("pageData", pageData);
		request.setAttribute("pageHeaders", holder.getPageHeaders());
		request.setAttribute("prefix", holder.getPrefix());
		request.setAttribute("action", holder.getAction());*/

		return mapping.findForward("listPage");
	}

	
	public ActionForward parentList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		isParentList.set(true);//used as a flag while creating hyperlink for parent listing
		ListDataHolder holder = new ListDataHolder();
		holder.setDtos(prepareListdata(request));
		holder.setPropertyNames(getPropertyNames());
		holder.setPageHeaders(getListHeaders());
		holder.setAddNewVisible(false);
		String childAction = getChildAction(request);
		
		validateData(holder);
		
		manipulateSession(request);
		
		List<List<String>> pageData = convertToColumns(holder.getDtos(), holder.getPropertyNames(),childAction);
		
		holder.setPageData(pageData);
		holder.setCount(pageData.size()+"");
		holder.setHeaderCount(holder.getPageHeaders().size());
		
		holder.setModule(getModule());
		holder.setInstructions(getInstructionsParent(childAction));
		
		request.setAttribute("holder", holder);
		
		return mapping.findForward("listPage");
	}
	
	
	protected List<? extends BaseFieldsDTO> prepareListdata(HttpServletRequest request) throws Exception{
		
		String id = "";
		String spec = "";
		
		id = request.getParameter("id");
		if(id == null){
			id = (String)request.getAttribute("id");
		}
		
		if(id != null){
			spec = " id = "+id;
		}
		return getListingData(spec);
	}
	
	private void validateData(ListDataHolder holder) {
		
		
		
	}
	protected List<List<String>> convertToColumns(List<? extends BaseFieldsDTO> dtos, List<String> props, String childAction){
		
		List<List<String>> listDatas = new ArrayList<List<String>>();
		
		if(!checkIfNoElement(dtos) && !checkIfNoElement(props)){
			
			for(BaseFieldsDTO baseFieldsDTO : dtos){
				
				List<String> row = new ArrayList<String>();
				for(String property : props){
				
					String method = "get"+property;
					Class dtoClass = baseFieldsDTO.getClass();
					Method dtoMethod = null;
					Object object = null;
					try {
						dtoMethod = dtoClass.getMethod(method, new Class[] {});
						object = dtoMethod.invoke(baseFieldsDTO, new Object[]{});
					} catch (SecurityException e) {} 
					catch (NoSuchMethodException e) {} 
					catch (IllegalArgumentException e) {} 
					catch (IllegalAccessException e) {} 
					catch (InvocationTargetException e) {}
					
					if(object != null){
						if(isParentList.get() != null && isParentList.get() && property.equals(getHyperlinkColumn())){
							String hyperlink = "<a class='listlink' href='./toModule.do?prefix=/jsp/listing&page=/"+childAction+".do&parentId="+baseFieldsDTO.getId()+"&method=list'>"+object.toString()+"</a>";
							row.add(hyperlink);
						}else{
							row.add(object.toString());
						}
						
					}else{
						row.add(null);
					}
				}
				if(isParentList.get() == null || !isParentList.get()){
					//Set Links
					row.add(getPageLinks(baseFieldsDTO.getId()));
				}
				listDatas.add(row);
			}
			
		}
		return listDatas;
	}
	
	private String getChildAction(HttpServletRequest request){
		return request.getParameter("childAction");
	}
	public void setIsParentList(Boolean isParentList) {
		this.isParentList.set(isParentList);
	}
	
	
}
