<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5">
		<h1>Register</h1>
		<form:form action="/register" method="post" modelAttribute="newUser">
			<div class="form-group">
				<form:label path="userName"> User Name:</form:label>
				<form:input path="userName" class="form-control"/>
				<form:errors path="userName" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="email"> Email:</form:label>
				<form:input path="email"   class="form-control"/>
				<form:errors path="email" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="password"> Password:</form:label>
				<form:input type="password" path="password" class="form-control"/>
				<form:errors path="password" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="confirm"> Confirm Password:</form:label>
				<form:input type="password" path="confirm" class="form-control"/>
				<form:errors path="confirm" class="text-danger"/>
			</div>
			<button type="submit" class="btn btn-primary">Register</button>
		</form:form>
		<h1>Log In</h1>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			<div class="form-group">
				<form:label path="email"> Email:</form:label>
				<form:input path="email" class="form-control"/>
				<form:errors path="email" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="password"> Password:</form:label>
				<form:input path="password" type="password" class="form-control"/>
				<form:errors path="password"  class="text-danger"/>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form:form>
	</div>
</body>
</html>