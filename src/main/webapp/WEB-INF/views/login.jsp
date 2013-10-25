<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head><title>Login</title></head>
	<body>
		<h1>Login Page</h1>
		<form:form method="POST" commandName="loginUser" action="loginSubmit">
			<table><tbody>
				<tr>
					<td><form:label path="emailAddress">Name: </form:label></td>
					<td><form:input path="emailAddress"/></td>
				</tr>
				<tr>
					<td><form:label path="passWord">Password: </form:label></td>
					<td><form:password path="passWord"/></td>
				</tr>
				<tr>
				<td colspan="2">
					<input value="Login" type="submit">
				</td>
			</tr>
			</tbody></table>
		</form:form>
	</body>
</html>
