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
		<h1>Welcome, <c:out value="${userName}"></c:out></h1>
		<a href="/logout">Logout</a>
		<div>
			<a href="/books/new">Add a book to my shelf</a>
		</div>
		<h3> Books from everyone's shelves: </h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books}">		
					<tr>
						<td> ${book.id} </td>
						<td> <a href="/books/${book.id}"> <c:out value="${book.title}"/> </a></td>
						<td> <c:out value="${book.author}"/> </td>
						<td> <c:out value="${book.user.userName}"/> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>