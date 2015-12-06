<%@page import="org.apache.struts.Globals"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
   
	<title>Error Page</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">
		
		.error{
			margin: 0 auto 0 auto;
			padding: 10 10 10 10;
			text-align: center;
		}
	
	</style>
	
	<script src="js/jquery-1.9.1.js"></script>
	<script>
		$(document).ready(function() {
			
			var cancelLink = "./toModule.do?prefix=&page=/jsp/DashBoardForm.jsp";
			
			$("#back").click(function(){
				$.get(cancelLink,function(data){
						$("#content").html(data);				
				});
			});
			return false;
		});
	</script>
	
	</head>
 
	<body> 
<%
try{
	
%>	
		
		<div class="error">
			<h3>Error Page : </h3>
			
			<p>
			<%=request.getAttribute(Globals.EXCEPTION_KEY)%>
			</p>			
			
			<input id="back" type="button" value="Back">
			
		</div>
		
<%
}catch(Exception e){
	e.printStackTrace();
}
%>
	</body></html>
