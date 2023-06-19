<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Show</title>
</head>
<body>
	<div>
		<h1> Expense Details</h1>
		<a href="/"> Go back </a>
	</div>
	<div>
			<p>Expense Name: <c:out value="${expense.name}"/></p>
			<p>Expense Description:<c:out value="${expense.description}"/> </p>
			<p>Vendor:<c:out value="${expense.vendor}"/> </p>
			<p>Amount Spent:<c:out value="${expense.amount}"/> </p>	
	</div>
</body>
</html>