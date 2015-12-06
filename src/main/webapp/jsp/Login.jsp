<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" errorPage="/jsp/Error.jsp"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>Login Page</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<html:base />
	
	<style type="text/css">
		
		.loginprompt{
			font-family: sans-serif;
			font-size: 16px;
			margin-top: 10px;
			margin-left: auto;
			margin-right: auto;
			
		}
		
		.newuser{
			font-family: sans-serif;
			font-size: 16px;
			text-align: center;
			margin-top: 20px;
		}
	</style>
	
	<link rel="stylesheet" type="text/css" href='<c:url value="/css/style.css"></c:url>'>
	<link rel="stylesheet" type="text/css" href='<c:url value="/css/table.css"></c:url>'>
	<script type="text/javascript" src='<c:url value="/js/TextFunctions.js"></c:url>'></script>
	<script>
	
		document.LoginForm.userName.focus();
	
		function validateRequest(){
			if(document.LoginForm.userName.value == ""){
				alert("Please Enter Username.");
				document.LoginForm.userName.focus();
				return false;
			}else{
				if(!validateBlankText(document.LoginForm.userName)){
					alert("Please Enter Proper Values.");
					document.LoginForm.userName.focus();
					return false;
				}
			}
			
			if(document.LoginForm.password.value == ""){
				alert("Please Enter Password.");
				document.LoginForm.password.focus();
				return false;
			}else{
				if(!validateBlankText(document.LoginForm.password)){
					alert("Please Enter Proper Values.");
					document.LoginForm.password.focus();
					return false;
				}
			}
			return true;
		}
		
		
		function validateBlankText(obj){
			var ifBlankText = true;
			if(obj != null && obj.value.length > 0){
				var objVal = obj.value;
				for(var i=0;i<objVal.length;i++){
					if(objVal.substring(i,i+1) != " "){
						ifBlankText = false;
					}
				}
				if(ifBlankText){
					obj.value="";
					obj.focus();
					return false;
				}
			}
			return true;
		}
		
		function test(){
			trimLeadingSpaces(document.LoginForm.userName);
			trimLaggingSpaces(document.LoginForm.userName);
		}
	</script>
	
	</head>
 
	<body>
	<html:form action="/login" onsubmit="return validateRequest();">
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
		
		<h3 style="text-align: center;">Sign In</h3>
		
		<table class="login loginprompt">
		<tr>
			<td>Username</td>
			<td>
				<html:text property="userName"></html:text>
			</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>
				<html:password property="password"></html:password>
			</td>
		</tr>
		<tr>
			<td>
				<html:submit></html:submit>
			</td>
			<td>
				<input type="reset" value="Reset">
			</td>
		</tr>
		</table>
		
		<p class="newuser">New User ??? <a href="./../login.do?method=newUser">Sign Up</a> Here !!!</p>
	
	<html:hidden property="method" value="login"/>
	</html:form>
	</body>
</html>
