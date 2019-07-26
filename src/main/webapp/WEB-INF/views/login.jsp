<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>

<body>
	<form:form action="authenticate" method="post" modelAttribute="user">
		User: <form:input path="email" type="email" /><br>
		Password:<form:input path="password" type="password"/><br>
		<input type="submit" value="Login"/>
	</form:form>
</body>
</html>