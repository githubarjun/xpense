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
	
	<link rel="stylesheet" type="text/css" href='<c:url value="/css/style.css"/>'>
	<script type="text/javascript" src='<c:url value="/js/TextFunctions.js"/>'></script>

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
		
		function validateParent(){
			return validateFields();		
		}
		
		function validateFields(){
			
			if(!validateCode(document.all.groupCode)){
				return false;
			}
			if(!validateName(document.all.groupName)){
				return false;
			}
			if(!checkNum(document.all.noOfUsers)){
				return false;	
			}
			
			return true;
		}
		
		function frmSubmit(){
			if(!validateFields()){
				return false;
			}
			if(document.all.noOfUsers.value != document.all.childCount.value){
				alert("Add correct number of users.");
				return false;
			}
			
			return true;
		}
		
		function setChildCount(countt){
			document.all.childCount.value = countt;
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
					$.post($("#userGroup").attr("action"),$("#userGroup").serialize(),function(data){
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
	
		<!-- <div id="groupinput"> -->
		
		<table class="centeralign">
			<tr>
				<td style="background-color: bisque">
					<html:errors/>		
				</td>
			</tr>
		</table>	
		
		<h3 class="formheader"><%=mode.toUpperCase()%> Group >>> </h3>
		
			<table class="centeralign">
			<tr>
				<td>
				Group Code
				</td>
				<td>
					<html:text property="groupCode" alt="Group Code" disabled="${UserGroupForm.groupCodeED}"></html:text>
					<font color="Red">*</font>			
				</td>
			</tr>
			<tr>
				<td>
				Group Name 
				</td>
				<td>
					<html:text property="groupName" alt="Group Name" disabled="${UserGroupForm.groupNameED}"></html:text>
					<font color="Red">*</font>			
				</td>
			</tr>
			<tr>
				<td>
				No. Of Users 
				</td>
				<td>
					<html:text property="noOfUsers" alt="No. Of Users" disabled="${UserGroupForm.noOfUsersED}"></html:text>
					<font color="Red">*</font>
				</td>
			</tr>
			</table>
			
		<!-- </div> -->
		<div class="centeralign frame">
			<iframe src="./toModule.do?prefix=/jsp/master&amp;page=/userGroupDtls.do&method=show&mode=<%=mode%>" width="100%" height="50%"></iframe>			
		</div>
		<!-- <div style="float: right;"> -->
			<table class="rightalign">
			<tr>
				<td>
					<input id="submitbutton" type="button" value="Submit">
				</td>
				<td>
					<input id="cancelbutton" type="button" value="Cancel" onclick="cancel=true;">
				</td>
			</tr>
			</table>
		<!-- </div> -->	
		<input type="hidden" name="method" value="save"/>
		<input type="hidden" name="childCount" />	
	</html:form>
<%
}catch(Exception e){
	e.printStackTrace();
}
%>

	</body>
</html>
