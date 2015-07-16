<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Login</title>
</head>
<body>

	<div>
		<h2>System User Login</h2>
<jsp:include page="include/homeLink.jsp" />
		<br>
		<c:if test="${param.error != null}">
            <div style="color:#FF0000">Credential error!</div>
        </c:if>
		<form name="loginForm" action="securityLogin" method="post">
			<table>

				<tr>
					<td>
						<div align="left"  >Email</div>
					</td>
					<td>
						<div align="left">
							<input type="text" name="username" maxlength="255" size="30" value="" tabindex="1" />
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div align="left"  >Password</div>
					</td>
					<td>
						<div align="left">
							<input type="text" name="password" maxlength="60" size="30" value="" tabindex="2" />
						</div>
					</td>
				</tr>
				<tr>

					<td colspan="2">
						<div align="right">
							<input type="button" value="Login" onclick="document.loginForm.submit()">
						</div>
					</td>

				</tr>
			</table>
		</form>
	</div>

</body>
</html>
