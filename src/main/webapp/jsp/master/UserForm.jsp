<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" errorPage="/jsp/Error.jsp"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
   
	<title>New User</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
	
		var cancel = false;
		var cancelLink = "toModule.do?prefix=&page=/login.do&method=loginPage";
		
		function validateRequest(){
			
			if(cancel){
				window.location.href = cancelLink;
				return false;
			}else{
				return frmSubmit();
			}
		}
		
		function frmSubmit(){
			
			if(document.all.userName.value == ""){
				alert("Please Enter UserName");
				document.all.userName.focus();
				return false;
			}
			
			if(document.all.password.value == ""){
				alert("Please Enter Password");
				document.all.password.focus();
				return false;
			}
			
		}
		
	</script>
	<style type="text/css">
	
		.loginprompt{
			font-family: sans-serif;
			font-size: 16px;
			margin-top: 10px;
			margin-left: auto;
			margin-right: auto;
			
		}
	
	</style>	
	<link rel="stylesheet" type="text/css" href='<c:url value="/css/style.css"></c:url>'>
	<link rel="stylesheet" type="text/css" href='<c:url value="/css/table.css"></c:url>'>
	
	</head>
 
	<body> 
<%
try{
%>

		<html:form action="/user" method="post" onsubmit="return validateRequest();">
			<div id="header">
				Expense Calculator... 
			</div>
			
			<table class="centeralign" cellspacing="10">
			<tr>
				<td style="background-color: bisque">
					<html:errors/>		
				</td>
			</tr>
			</table>	
		
			<h3 style="text-align: center;">Sign Up Form </h3>		
			<table class="login loginprompt">
			<tr>
				<td>UserName:</td>
				<td>
					<html:text property="userName"></html:text>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td>
					<html:password property="password"></html:password>
				</td>
			</tr>
			<tr>
				<td>
					<html:submit></html:submit>
				</td>
				<td>
					<html:cancel onclick="cancel=true;">Back to Sign In</html:cancel>
				</td>
			</tr>
			
			</table>
		
		<input type="hidden" name="method" value="saveUser"/>
		</html:form>			

	</body>
<%
}catch(Exception e){
	e.printStackTrace();
}
%>
</html>
