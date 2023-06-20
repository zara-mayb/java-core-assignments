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
	<h1>NEW Dojo</h1>
	<form:form action="/dojos/add" mode="post" modelAttribute="dojo">
		<form:label path="name"> Dojo Name: </form:label>
		<form:input path="name"/>
		<form:errors path="name" class="text-danger"/>
		<div>
			<input type="submit" value="Submit"/>		
		</div>
	</form:form>
	<a href="/ninjas/new"> Add a new ninja</a>
	<h1>Dojos</h1>
	<c:forEach var="dojos" items="${dojos}">
		<div>
			<a href="/dojos/show/${dojos.id}"> <c:out value="${dojos.name}"/>  </a>
		</div>
	</c:forEach>
</body>
</html>