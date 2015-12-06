<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" errorPage="/jsp/Error.jsp"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
   
	<title>Settlement Report</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link type="text/css" rel="stylesheet" href='<c:url value="/css/table.css"></c:url>'>
	<script type="text/javascript" src='<c:url value="/js/TextFunctions.js"/>'></script>
	
	<script>
	
		var cancel = false;
		var cancelLink = "./toModule.do?prefix=&page=/jsp/DashBoardForm.jsp";
		
		function validateFields(){
			if(!checkCombo(document.all.group)){
				return false;
			}
			return true;
		}
		
		function frmSubmit(){
			if(!validateFields()){
				return false;
			}
			return true;
		}
		
	</script>
	<script src="js/jquery-1.9.1.js"></script>
	<script>
		$(document).ready(function() {
			
			var logoutLink = "toModule.do?prefix=&page=/logout.do&method=logout";
			
			$("#cancelbutton").click(function(){
				$.get(cancelLink,function(data){
						$("#content").html(data);				
				}).fail(function(xhr, ajaxOptions, thrownError){
					window.location.href = logoutLink;
				});
				return false;
			});
			
			$("#submitbutton").click(function(){
				var status = frmSubmit();
				if(status == true){
					$.post($("#settlementReport").attr("action"),$("#settlementReport").serialize(),function(data){
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

%>	

	<html:form styleId="settlementReport" action="/settlementReport">
		
		<h3 class="formheader">Settlement Report >>> </h3>
		
		<table class="centeralign">
			<tr>
				<td style="background-color: bisque">
					<html:errors/>		
				</td>
			</tr>
		</table>	
		
		<table class="centeralign">
		<tr>
			<td>
				<table>
				<tr>
					<td>Group Name</td>
					<td> : </td>
					<td>
						<html:select name="SettlementReportForm" property="group" title="Group Name">
							<html:option value="">Select</html:option>
							<html:optionsCollection name="SettlementReportForm" property="groupDTOs" label="groupName" value="id"/>
						</html:select>	
					</td>
					<td>&nbsp;</td>
					<td>
							<input id="submitbutton" type="button" value="Submit">
							<input id="cancelbutton" type="button" value="Cancel" onclick="cancel=true;">
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
		
		<logic:notEmpty name="SettlementReportForm" property="reportData.headers">
			<table class="bordered" width="100%">
				<tr>
					<th>Date</th>
					<th>Desc</th>
					<th>Amount</th>
				<logic:iterate name="SettlementReportForm" property="reportData.headers" id="hd">
					<bean:define name="hd" property="value" id="hdr"></bean:define>
					<th>
						${hdr}
					</th>					
				</logic:iterate>
				</tr>
				
					
					<logic:iterate name="SettlementReportForm" property="reportData.dataDtls" id="datalist">
					<tr>
						<logic:iterate name="datalist" id="item">
							<td>${item}</td>
						</logic:iterate>
					</tr>
					</logic:iterate>
					
			</table>
			
			<h4 class="formheader" align="center">Settlement Summary </h4>
			<table class="bordered" align="center">
				<logic:iterate name="SettlementReportForm" property="reportData.summary" id="entry">
					<bean:define name="entry" property="value" id="val"></bean:define>
					<bean:define name="entry" property="key" id="key"></bean:define>
					<tr>
						<td style="background-color: silver;">
							${key}
						</td>
						<td style="background-color: silver;">
							${val}
						</td>
					</tr>
				</logic:iterate>
			</table>
		</logic:notEmpty>
		
		<input type="hidden" name="method" value="getReport"/>
				
	</html:form>			

<%
}catch(Exception e){
	e.printStackTrace();
}
%>
	</body></html>
