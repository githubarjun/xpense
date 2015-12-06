<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" errorPage="/jsp/Error.jsp"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title></title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="<c:url value='/js/jquery-1.9.1.js'></c:url>"></script>
	<script src="<c:url value='/js/htmlDatePicker.js'></c:url>"></script>
	<link rel="stylesheet" href='<c:url value="/css/htmlDatePicker.css"></c:url>'>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'></c:url>">
	<link type="text/css" rel="stylesheet" href='<c:url value="/css/table.css"></c:url>'>
	
	<script>
	
		var cancel = false;
		var cancelLink = "toModule.do?prefix=/jsp/listing&page=/groupTransactionList.do&method=list&parentId="+${GroupTransactionForm.groupId};
	  	
	</script>
	<script>
		$(document).ready(function() {
		
			var logoutLink = "toModule.do?prefix=&page=/logout.do&method=logout";
			
			$("#groupTransaction").submit(function(){
				if(cancel == true){
					$.get(cancelLink,function(data){
						$("#content").html(data);				
					}).fail(function(xhr, ajaxOptions, thrownError){
						window.location.href = logoutLink;
					});
				}
				return false;
			});
			
		});
	</script>
	</head>
 
	<body> 
<%
	try{
	
	String mode = request.getParameter("mode");
%>

		<html:form styleId="groupTransaction" action="groupTransaction">

		<h3 class="formheader"><%=mode.toUpperCase()%> Group Event >>> </h3>

		<table class="centeralign">
		<tr>
			<td>
				<html:errors/>
			</td>
		</tr>
		<tr>
			<td>
			<table class="centeralign">
			<tr>
				<td>Group Name</td>
				<td>
					<html:text property="groupName" readonly="true"></html:text>
					<html:hidden property="groupId"/>
				</td>
			</tr>
			<tr>
				<td>Event Date</td>
				<td>
					<html:text property="eventDate" styleId="SelectedDate" onclick="GetDate(this);"></html:text>
				</td>
			</tr>
			<tr>
				<td>Event Description</td>
				<td>
					<html:text property="eventDescription" readonly="true"></html:text>	
				</td>
			</tr>
			<tr>
				<td>Total Amount</td>
				<td>
					<html:text property="eventAmount" readonly="true"></html:text>	
				</td>
			</tr>
			</table>
			
			</td>
		</tr>
		<tr>
		
			<td colspan="2">
		
				<fieldset>
				<legend>Payment Details</legend>
				<table  class="bordered">
				<tr>
					<th>#</th>
					<th>User Name</th>
					<th>Payment Amount</th>
					<th>Contribution Amount</th>
				</tr>
				<logic:iterate id="paydtls" name="GroupTransactionForm" property="dtlsList" indexId="index">
				
				<tr>
					<td>${index+1}</td>
					<td>${paydtls.txnsUserName}</td>
					<td>
						<html:text name="GroupTransactionForm" property="dtlsList[${index}].txnsUserPayAmount" size="10" readonly="true"></html:text>
					</td>
					<td>
						<html:text name="GroupTransactionForm" property="dtlsList[${index}].txnsUserContriAmount" size="10" readonly="true"></html:text>
					</td>
				</tr>
				</logic:iterate>				
				</table>
				
				</fieldset>
			</td>
			
		</tr>
		<tr>
			<td>
			<table class="rightalign">
			<tr>
				<td>
					<html:cancel onclick="cancel=true;">Back</html:cancel>
				</td>
			</tr>
			</table>
			</td>
		</tr>
		</table>
		</html:form>			
<%
	}catch(Exception e){
		e.printStackTrace();
	}
%>

	</body>
</html>
