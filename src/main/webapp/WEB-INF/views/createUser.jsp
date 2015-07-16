<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.List,java.util.HashMap" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Create customer</title>
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

	<div>
		<h2>Create Customer</h2>
<jsp:include page="include/logoutLink.jsp" />
<br>
<jsp:include page="include/homeLink.jsp" />
<br>

		<c:if test="${message != null}">
            <div style="color:#FF0000">${message}</div>
        </c:if>
        
		<form name="createForm"	action="createCustomer"	method="post">
			<table  >

				<tr>
					<td  >
						<div align="right" class="name">Name</div>
					</td>
					<td  >
						<div align="left"  >
							<input   type="text" name="customerName" maxlength="255" size="30" value="" tabindex="1" />
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right" class="name">Email</div>
					</td>
					<td>
						<div align="left"  >
							<input  type="text" name="email" maxlength="60" size="30" value="" tabindex="2" />
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right" class="name">Phone</div>
					</td>
					<td>
						<div align="left"  >
							<input  type="text" name="phone" maxlength="60" size="30" value="" tabindex="3" />
						</div>
					</td>
				</tr>
								<tr>
					<td>
						<div align="right" class="name">Address</div>
					</td>
					<td>
						<div align="left"  >
							<input  type="text" name="address" maxlength="60" size="30" value="" tabindex="4" />
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2"><div align="left">
							<input type="button" value="Create" onclick="document.createForm.submit()">
						</div></td>

				</tr>
			</table>
		</form>
	</div>

</body>
</html>
