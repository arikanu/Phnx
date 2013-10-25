<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head><title>Register</title></head>
	<body>
		<h1>Registration Page</h1>
		<form:form method="POST" commandName="registerUser" action="registerSubmit">
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
						<td><form:label path="firstName">First Name: </form:label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><form:label path="lastName">Last Name: </form:label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
					<td colspan="2">
						<input value="Register" type="submit">
					</td>
				</tr>
				</tbody></table>
			</form:form>
	</body>
</html>