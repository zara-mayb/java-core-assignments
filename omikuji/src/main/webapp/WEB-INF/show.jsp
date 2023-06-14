<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Here's Your Omikuji</h1>
		<div class="d-flex justify-content-center border">
			<p>
				In <c:out value = "${num}"/> years, you will live in <c:out value = "${city}"/> with <c:out value = "${person}"/> 
				as your roommate, <c:out value = "${hobby}"/> for a living. The next time you see a <c:out value = "${livingThing}"/>, you will have good luck. Also, 
				<c:out value = "${comment}"/>
			</p>
		</div>
		<a href = "/omikuji"> Go back</a>
	</div>
</body>
</html>