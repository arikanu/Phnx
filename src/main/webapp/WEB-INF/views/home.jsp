<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${model.formattedDate}. </P>
<P>  Valid Login = ${model.validLogin}. </P>
<br>

<c:choose>
	<c:when test="${model.user != null }">
		Email = ${model.user.emailAddress }<br>
		Password = ${model.user.passWord }<br>
		First Name = ${model.user.firstName }<br>
		Last Name = ${model.user.lastName }<br>
	</c:when>
	<c:otherwise>
		User is NULL.
	</c:otherwise>
</c:choose>

<br />
<P><a href="/mvc/login">Login</a></P>
<P><a href="/mvc/register">Register</a></P>

</body>
</html>
