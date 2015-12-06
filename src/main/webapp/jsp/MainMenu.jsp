<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1" errorPage="/jsp/Error.jsp"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	
	<script src="js/jquery-1.9.1.js"></script>
	<script>
		$(document).ready(function() {
			$("a").click(function(event){
				event.preventDefault();
				var href = $(this).attr("href");
				if(href != "" && href.indexOf("logout") > -1){
					window.location.href = "toModule.do?prefix=&page=/logout.do&method=logout";
				}else if(href != ""){
					$("#content").html("<div style='margin-top : 100px; text-align:center;'> <img src='image/299.GIF' alt='Loading'/></div>");
					$.get(href,function(data){
						$("#content").html(data);
					}).fail(function(xhr, ajaxOptions, thrownError){
						window.location.href = "toModule.do?prefix=&page=/logout.do&method=logout";
					});				
				}
			});
			
			$("#vertical_menu li").hover(
				function(){
					$(this).css("background-color","orange");				
				},
				function(){
					$(this).css("background-color","white");				
				}
			);
			
		});
	</script>
	
	
	</head>
 
	<body>
		<h3 id="linkheader">Links</h3>
		<ul id="vertical_menu">
			<li>
			<a href="toModule.do?prefix=/jsp/listing&page=/userGroupList.do&method=list&mode=add" target="ContentFrame">Create Group</a>
			</li>
			<li>
			<a href="toModule.do?prefix=/jsp/listing&page=/userGroupList.do&method=parentList&childAction=groupTransactionList" target="ContentFrame">Create Group Event</a>
			</li>
			<li>
			<a href="toModule.do?prefix=/jsp/report&page=/spendingReport.do&method=show" target="ContentFrame">Spending Report</a>
			</li>
			<li>
			<a href="toModule.do?prefix=/jsp/report&page=/settlementReport.do&method=show" target="ContentFrame">Settlement Report</a>
			</li>
			<li>
			<a href="toModule.do?prefix=&page=/logout.do&method=logout">Sign Out</a>
			</li>
		</ul>
		
	</body>
</html>
