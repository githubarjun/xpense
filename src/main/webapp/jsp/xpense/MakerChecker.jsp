<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<table>

	<tr>
		<td>
		Effective From 
		</td>
		<td>
			<html:text property="effectiveFrom"></html:text>
			<font color="Red">*</font>
		</td>
	</tr>
	<tr>
		<td>Effective Till</td>
		<td>
			<html:text property="effectiveTill"></html:text>
		</td>
	</tr>
	
</table>