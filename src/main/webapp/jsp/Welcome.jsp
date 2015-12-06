<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" errorPage="/jsp/Error.jsp"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
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
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'></c:url>">
	<script src="<c:url value='/js/jquery-1.9.1.js'></c:url>"></script>
	<script>
		$(document).ready(function() {
			var MENU_URL="./toModule.do?prefix=&page=/jsp/MainMenu.jsp";
			var DASHBOARD_URL="./toModule.do?prefix=&page=/jsp/DashBoardForm.jsp";
			//load menu
			$.get(MENU_URL,function(data){
				$("#menu").html(data);
			});
			//load dashboard
			$.get(DASHBOARD_URL,function(data){
				$("#content").html(data);
			});
			
			$("#menubutton").on("click",function(){
				$("#menu").slideToggle("slow");
			});
		});
	</script>

	</head>
 
	<body>
	
		<div id="header">
			Expense Calculator...
			<div id="menubutton"><img src="<c:url value='/image/nav_icon.png'></c:url>" alt="aa" /></div>
		</div>
		<div id="menu"></div>
		<div id="division"></div>
		<div id="content"></div>
	
	</body>
</html>
