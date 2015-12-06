<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" errorPage="/jsp/Error.jsp"%>
<%@page import="com.xpense.commons.action.ListDataHolder"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
   
	<title></title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'></c:url>">
	<link type="text/css" rel="stylesheet" href='<c:url value="/css/table.css"></c:url>'>
	</head>
 
	<body> 

<%
String actionString = ""; 
try{ 
 
	ListDataHolder dataHolder = (ListDataHolder)request.getAttribute("holder");
	if(dataHolder.getPrefix() != null && dataHolder.getAction() != null){
		actionString = "toModule.do?prefix="+dataHolder.getPrefix()+"&page="+dataHolder.getAction()+".do&method=show&mode=add";	 
	}
 
%>	

	<form action="<%=actionString%>" method="post" onclick="return validateRequest()">
		
		<h3 class="formheader">You Are Here >> <%=dataHolder.getModule()%></h3>
		<h4 class="formheader"><%=dataHolder.getInstructions()%></h4>
		<table class="bordered" width="100%">
			<tr>
				<th>
					#
				</th>
			<logic:iterate id="colheader" name="holder" property="pageHeaders" indexId="srno">
				<th>
					${colheader}
				</th>
			</logic:iterate>
			</tr>
			<%
			if("0".equals(dataHolder.getCount())){
			%>
			<tr align="center">
				<td colspan="${holder.headerCount+2}">
					No Records Found.
				</td>			
			</tr>
			<%
			}
			%>
		
			<%	
			if(!"0".equals(dataHolder.getCount())){
			%>
			<logic:iterate id="datas" name="holder" property="pageData" indexId="srno">
			<tr>
				<td>
					${srno+1}
				</td>
				<logic:iterate id="field" name="datas">
				<td>
					${field}
				</td>				
				</logic:iterate>
			</tr>
			</logic:iterate>
			<%
			}
			%>
			
		</table>
		<table class="listingtable">  
		<tr align="right">
			<td>
			<%
			if(dataHolder.isAddNewVisible()){
			%>
				<%-- <html:submit>Add New</html:submit> --%>
				<input type="button" id="addnew" value="Add New"/>
			<%
			}
			%>
				<%-- <html:submit onclick="cancel=true;">Cancel</html:submit> --%>
				<input type="button" id="cancel" value="Cancel" onclick="cancel=true;"/>
			</td>
		</tr>
		</table>
	</form>

<%
}catch(Exception e){
	e.printStackTrace();
}
%>

	<script>
		var action = "<%=actionString%>";
		var cancel = false;
		var cancelLink = "./toModule.do?prefix=&page=/jsp/DashBoardForm.jsp";
		
		function validateRequest(){
			
			if(cancel){
				window.location.href = cancelLink;
				return false;
			}else{
				return frmSubmit();
			}
		}
		
		function frmSubmit(){
			return true;
		}
		
	</script>
	<script src="js/jquery-1.9.1.js"></script>
	<script>
		$(document).ready(function() {
		
			var logoutLink = "toModule.do?prefix=&page=/logout.do&method=logout";
		
			$("#addnew").on("click",function(event){
				event.preventDefault();
				$(this).attr("disabled","disabled");
				$.get(action,function(data){
					$("#content").html(data);
				}).fail(function(xhr, ajaxOptions, thrownError){
					window.location.href = logoutLink;
				});				
			});
			
			$("#cancel").on("click",function(event){
				event.preventDefault();
				$(this).attr("disabled","disabled");
				$.get(cancelLink,function(data){
					$("#content").html(data);
				}).fail(function(xhr, ajaxOptions, thrownError){
					window.location.href = logoutLink;
				});				
			});
			
			$(".listlink").click(function(event){
				event.preventDefault();
				var href = $(this).attr("href");
				$(this).removeAttr("href");
				$.get(href,function(data){
					$("#content").html(data);
				}).fail(function(xhr, ajaxOptions, thrownError){
					window.location.href = logoutLink;
				});				
			});		
		});
	</script>
	</body>
</html>
