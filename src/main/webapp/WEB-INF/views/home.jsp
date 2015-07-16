<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.List,java.util.HashMap,java.util.ArrayList" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored ="false" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Home</title>
</head>
<%
	HashMap result = (HashMap) request.getAttribute("result");
	if (result != null) { 
		if(result.get("message") != null){
		 	pageContext.setAttribute("message", result.get("message").toString());
		}
	
	}
							        
%>
<body>
	<h1>Customer Service Centre</h1>
	 
	<P>
		<c:if test="${message != null}">
            <div style="color:#FF0000">${message}</div>
        </c:if>
        <br>
		<div><a href="createUser">Create customer</a></div> 
		<br>
		<div><a href="customerList">List all customers</a></div>
		<br>
		 

        
	<div><form name="getCustomerForm" action="getCustomer" method="post">
		<table>

			<tr>
				<td>Get customer by email:</td>
				<td><input  type="text" name="email" maxlength="255" size="50" value="" tabindex="1" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="Retrieve Customer" onclick="document.getCustomerForm.submit()"></td>

			</tr>
		</table>
	</form> 
	</div>
	 
</body>
</html>
