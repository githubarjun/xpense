<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" errorPage="/jsp/Error.jsp"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
   
	<title></title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script>
	
		var cancel = false;
		var cancelLink = "toModule.do?prefix=/jsp/listing&page=/userGroupList.do&method=list";
		
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
			
			$("#userGroup").submit(function(){
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

	<html:form styleId="userGroup" action="/userGroup">
		
		<h3 class="formheader"><%=mode.toUpperCase()%> Group >>> </h3>
		
		<!-- <div id="groupinput"> -->
		<table class="centeralign">
		<tr>
			<td>
			Group Code
			</td>
			<td>
				<html:text property="groupCode" readonly="true"></html:text>
			</td>
		</tr>
		<tr>
			<td>
			Group Name 
			</td>
			<td>
				<html:text property="groupName" readonly="true"></html:text>
			</td>
		</tr>
		<tr>
			<td>
			No. Of Users 
			</td>
			<td>
				<html:text property="noOfUsers" readonly="true"></html:text>
			</td>
		</tr>
		</table>
		<!-- </div> -->
		
		<div class="centeralign frame">
			<iframe src="./toModule.do?prefix=/jsp/master&amp;page=/userGroupDtls.do&method=show&mode=<%=mode%>" width="100%" height="50%"></iframe>			
		</div>
		
		<table class="rightalign">
		<tr>
			<td>
				<html:cancel onclick="cancel=true;">Back</html:cancel>
			</td>
		</tr>
		</table>
		<input type="hidden" name="method" value="save"/>	
	</html:form>
<%
}catch(Exception e){
	e.printStackTrace();
}
%>

	</body>
</html>
