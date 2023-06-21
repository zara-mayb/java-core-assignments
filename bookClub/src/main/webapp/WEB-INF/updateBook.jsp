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
		<h1>Add a Book to Your Shelf!</h1>
		<a href="/books">Back to the shelves</a>
		<form:form action="/books/${book.id}/edit" method="put" modelAttribute="book" class="form-control">
			<form:hidden path="user" />
			<div class="form-group">
				<form:label path="title"> Title:</form:label>
				<form:input path="title" class="form-control"/>
				<form:errors path="title" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="author"> Author:</form:label>
				<form:input path="author" class="form-control"/>
				<form:errors path="author" class="text-danger"/>
			</div>
				<div class="form-group">
				<form:label path="thoughts"> My thoughts:</form:label>
				<form:textarea path="thoughts" class="form-control"/>
				<form:errors path="thoughts" class="text-danger"/>
			</div>
			<button type="submit" class="btn btn-primary">Update</button>
		</form:form>
	</div>
</body>
</html>