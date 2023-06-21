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
		<div class="d-flex justify-content-between">
			<h1><c:out value="${book.title}"></c:out></h1>
			<a href="/books">Back to the shelves</a>
		</div>
		<div>
			<p> <span class="text-danger"> <c:out value="${book.user.userName}"/> </span> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/> </p>
			<p> Here are <c:out value="${book.user.userName}"/>'s thoughts: </p>
			<hr/>
			<p> <c:out value="${book.thoughts}"/> </p>
			<hr/>	
			<c:if test="${book.user.id.equals(userId)}">
				<a class="btn btn-primary" href="/books/${book.id}/edit" role="button">Edit</a>
				<form action="/books/${book.id}/delete" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="Delete">
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>