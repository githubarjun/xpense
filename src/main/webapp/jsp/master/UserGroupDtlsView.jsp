<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" errorPage="/jsp/Error.jsp"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
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
	
	<link rel="stylesheet" type="text/css" href='<c:url value="/css/style.css"/>'>
	<link type="text/css" rel="stylesheet" href='<c:url value="/css/table.css"></c:url>'>

	<script>
	
		var cancel = false;
		var cancelLink = "toModule.do?prefix=/jsp/xpense&page=/showMenu.do";
		
		function validateRequest(){
			
			if(cancel){
				window.location.href = cancelLink;
				return false;
			}else{
				return frmSubmit();
			}
		}
		
		function frmSubmit(){
			
			if(document.all.name.value == ""){
				document.all.name.focus();
				alert("Please Enter Name.");
				return false;
			}

			//call parent function
			if(window.parent.validateParent()){
				return true;
			}else{
				return false;
			}
		}
		
	</script>
	</head>
 
	<body>
<%
try{
%>

	<html:form action="/userGroupDtls" onsubmit="return validateRequest();">
	
		<logic:notEmpty name="UserGroupForm" property="userDtls">
		
		<h3 style="text-align: center;">Group Details</h3>
		<table class="centeralign bordered">
		<tr>
			<th>Sr No.</th>
			<th>Group Member Name</th>
			<th>Active</th>
		</tr>
		<logic:iterate id="grpDtls" name="UserGroupForm" property="userDtls" indexId="srno">
			<tr>	
				<td>${srno+1}</td>
				<td>${grpDtls.name}</td>
				<td>${grpDtls.active}</td>				
			</tr>
			
		</logic:iterate>
		</table>		
		</logic:notEmpty>
	</html:form>
<%
}catch(Exception e){
	e.printStackTrace();
}
%>
	</body>
</html>