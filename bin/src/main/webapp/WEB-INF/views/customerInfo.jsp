<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.List,java.util.HashMap,com.rga.customer.bean.Customer,java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Customer</title>
</head>

<%
	HashMap result = (HashMap) request.getAttribute("result");
	if (result != null) { 
	
		pageContext.setAttribute("workflow", result.get("workflow"));
		if(result.get("customer") != null){
		 	pageContext.setAttribute("customerList", (List)result.get("customer"));
		}
		if(result.get("message") != null){
		 	pageContext.setAttribute("message", result.get("message").toString());
		}
	
	}
							        
%>
<body>
<c:choose>
	<c:when test="${workflow == 'create'}">
		<h1>Customer created !</h1>				 
	</c:when>
	<c:otherwise>
		<h1>Customer List</h1>					 
	</c:otherwise>
</c:choose>	
	<jsp:include page="include/logoutLink.jsp" />
	<br>
	<jsp:include page="include/homeLink.jsp" />
	<br>
	<div>
		<c:if test="${message != null}">
            <div style="color:#FF0000">${message}</div>
        </c:if>

		<c:if test="${customerList != null}">
			<form name="userForm" action="" method="post">
				<table width="70%" border="2">
					<tr  >
						<td ><div>Name</div></td>
						<td ><div>Email</div></td>
						<td ><div>Phone</div></td>
						<td ><div>Address</div></td>
						<td></td>
					</tr>
					<c:forEach var="customer" items="${customerList}">
					<tr >
						<td><div align="left">${customer.name}</div></td>
						<td><div align="left">${customer.email}</div></td>
						<td><div align="left">${customer.phone}</div></td>
						<td><div align="left">${customer.address}</div></td>
						 
						<td>
							<div align="left">
								<input type="button" value="Update" onclick="javascript:document.location.href='updateCustomer?id=${customer.id}'"> 
								<input type="button" value="Delete" onclick="javascript:document.location.href='deleteCustomer?id=${customer.id}'">
							</div>
						</td>
					</tr>
 
					</c:forEach>
				</table>
			</form>
		</c:if>
         


	</div>
</body>
</html>
