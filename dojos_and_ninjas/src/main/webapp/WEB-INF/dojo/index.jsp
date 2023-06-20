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
	<h1> <c:out value="${dojo.name}"/> Location Ninjas </h1>
	<table>
		<thead>
			<tr>
				<th> First Name </th>
				<th> Last Name </th>
				<th> Age </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ninja" items="${dojo.ninjas}">
				<tr>
					<td> <c:out value="${ninja.first_name}"/> </td>
					<td> <c:out value="${ninja.last_name}"/> </td>
					<td> <c:out value="${ninja.age}"/> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/dojos/new"> go back</a>
</body>
</html>